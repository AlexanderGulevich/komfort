/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.domainModel.pojo.DomainObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public class UnitOfWork {
    private ObservableList<DomainObject>  storedPojoes=FXCollections.<DomainObject> observableArrayList();
    private List <DomainObject>newPojoes=new ArrayList<>();
    private List <DomainObject>removedPojoes=new ArrayList<>();
    private List <DomainObject>changedPojoes=new ArrayList<>();
    
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

    public ObservableList<DomainObject> getStoredPojoes() {
        return storedPojoes;
    }

    
    public void clearStoredPojoes(){
    
        this.storedPojoes.clear();
    
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
      
        for (Iterator<DomainObject> iterator = newPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();
            next.getDataMapper().insertDomainObject(next);
        }
        clearNewPojoesList();
    
    }
    public void commitChanged(){
    
        for (Iterator<DomainObject> iterator = changedPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();
            next.getDataMapper().updateDomainObject(next);
        }
        clearChangedPojoesList();
        
    
    }
    public void commitRemoved() throws SQLException{
    
        for (Iterator<DomainObject> iterator = removedPojoes.iterator(); iterator.hasNext();) {
            DomainObject next = iterator.next();
            next.getDataMapper().deleteDomainObject(next);
            
        }
        clearRemovedPojoesList();
        
    
    }
    
    
    
    
}
