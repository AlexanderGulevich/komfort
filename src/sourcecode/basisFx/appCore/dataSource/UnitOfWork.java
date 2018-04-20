/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.appCore.Refreshable;
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

        System.out.println("UnitOfWork.setChangedPojoes,   getTableName==="+p.getTableName());
    
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
        System.out.println("UnitOfWork.clearChangedPojoesList");
        this.changedPojoes.clear();
    
    }
    public void commitAll() throws SQLException{
        commitNew();
        commitChanged();
        commitRemoved();

        System.out.println("UnitOfWork.commitAll");
    }
    public void commitNew(){


        boolean isReady=true;
      
        for (Iterator<DomainObject> iterator = newPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();

            if (next.getDataMapper().isReadyToTransaction(next)) {


                System.out.println("UnitOfWork --КОММИТ НОВОГО ДОМЕНА");
                System.out.println("UnitOfWork --ДАТА МАППЕР----" + next.getDataMapper());

                next.getDataMapper().insertDomainObject(next);

                System.out.println("UnitOfWork.commitNew");




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

                System.out.println("UnitOfWork --КОММИТ ИЗМЕНЕННОГО ДОМЕНА");
                System.out.println("UnitOfWork --ДАТА МАППЕР----" + next.getDataMapper());
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
            next.getDataMapper().deleteDomainObject(next);

            System.out.println("UnitOfWork.commitRemoved");
            
        }
        clearRemovedPojoesList();
        
    
    }

    public void setRefreshable(Refreshable r) {


       this.refreshable=r;
       
    }

}
