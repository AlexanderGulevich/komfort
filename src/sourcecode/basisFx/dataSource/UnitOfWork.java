
package basisFx.dataSource;
import basisFx.appCore.interfaces.Refreshable;
import basisFx.domain.domaine.DomainObject;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UnitOfWork {
    private List<Integer> storedPojoesId=new ArrayList<>();
    private List <DomainObject>newPojoes=new ArrayList<>();
    private List <DomainObject>removedPojoes=new ArrayList<>();
    private List <DomainObject>changedPojoes=new ArrayList<>();
    private Refreshable refreshable;

    public void setNewPojoes(DomainObject p){

        this.newPojoes.add(p);

    }
    public void setRemovedPojoes(DomainObject p){

        this.removedPojoes.add(p);

    }
    public void setChangedPojoes(DomainObject p){

        this.changedPojoes.add(p);

    }
    public List <DomainObject> getNewPojoes(){

        return newPojoes;

    }
    public List<DomainObject> getRemovedPojoes() {

        return removedPojoes;
    }
    public List<DomainObject> getChangedPojoes() {

        return changedPojoes;
    }
    public List<Integer> getStoredPojoesId() {

        return storedPojoesId;
    }
    public void clearStoredPojoesId(){


        this.storedPojoesId.clear();

    }
    public void clearNewPojoesList(){

        this.newPojoes.clear();
    }
    public void clearRemovedPojoesList(){

        this.removedPojoes.clear();
    }
    public void clearChangedPojoesList(){
        this.changedPojoes.clear();

    }
    public void commitAll() throws SQLException{
        commitNew();
        commitChanged();
        commitRemoved();
    }
    public void commitNew(){

        boolean isReady=true;
        Set<DomainObject> domainObjects = Collections.newSetFromMap(new ConcurrentHashMap<DomainObject, Boolean>() {});
        domainObjects.addAll(newPojoes);



        for (Iterator<DomainObject> iterator = domainObjects.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();

            if (next.getActiveRecord().isReadyToTransaction(next)) {

                next.getActiveRecord().insertDomainObject(next);


            }else {
                isReady=false;
            }


        }


        if (isReady){

            clearNewPojoesList();
            refreshable.refresh();

        }

    }
    public void commitChanged(){

        boolean isReady=true;

        for (Iterator<DomainObject> iterator = changedPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();

            if (next.getActiveRecord().isReadyToTransaction(next)) {

                next.getActiveRecord().updateDomainObject(next);


            }else {
                isReady=false;
            }


        }


        if (isReady){

            clearChangedPojoesList();
            refreshable.refresh();

        }



    }
    public void commitRemoved() throws SQLException{

        for (Iterator<DomainObject> iterator = removedPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();

            if (!getNewPojoes().contains(next)) {// если обеъект не является новым, то удаляем их БД

                next.getActiveRecord().deleteDomainObject(next);

            }else {
            }

        }
        clearRemovedPojoesList();


    }

    public void setRefreshable(Refreshable r) {


       this.refreshable=r;

    }

}
