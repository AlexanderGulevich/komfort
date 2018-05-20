/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.appCore.interfaces.Refreshable;
import basisFx.appCore.domainScetch.DomainObject;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Alek
 */
public class UnitOfWork {
    private List<Integer> storedPojoesId=new ArrayList<>();
    private List <DomainObject>newPojoes=new ArrayList<>();
    private List <DomainObject>removedPojoes=new ArrayList<>();
    private List <DomainObject>changedPojoes=new ArrayList<>();
//    private Map<Integer,DomainObject>storedPojoesMap=new HashMap<>();
    private Refreshable refreshable;
    
    public void setNewPojoes(DomainObject p){

        this.newPojoes.add(p);
        
    }
    public void setRemovedPojoes(DomainObject p){

        this.removedPojoes.add(p);
        
    } 
    public void setChangedPojoes(DomainObject p){

        System.err.println("UnitOfWork.setChangedPojoes,   getTableName==="+p.getTableName());
    
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
        System.err.println("UnitOfWork.clearChangedPojoesList");
        this.changedPojoes.clear();
    
    }
    public void commitAll() throws SQLException{
        commitNew();
        commitChanged();
        commitRemoved();

        System.err.println("UnitOfWork.commitAll");
    }
    public void commitNew(){

        boolean isReady=true;


        for (Iterator<DomainObject> iterator = newPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();

            if (next.getDataMapper().isReadyToTransaction(next)) {

                System.err.println("UnitOfWork --ПОПЫТКА КОММИТА НОВОГО ДОМЕНА=");

                next.getDataMapper().insertDomainObject(next);

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

            if (next.getDataMapper().isReadyToTransaction(next)) {

                System.err.println("UnitOfWork --КОММИТ ИЗМЕНЕННОГО ДОМЕНА");
                System.err.println("UnitOfWork --ДАТА МАППЕР----" + next.getDataMapper());
                next.getDataMapper().updateDomainObject(next);



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

                next.getDataMapper().deleteDomainObject(next);

                System.err.println("UnitOfWork.commitRemoved");
            }else {
                System.err.println("Объект является новым, поэтому нет обращения к БД на удаление");
            }
            
        }
        clearRemovedPojoesList();
        
    
    }

    public void setRefreshable(Refreshable r) {


       this.refreshable=r;
       
    }

}
