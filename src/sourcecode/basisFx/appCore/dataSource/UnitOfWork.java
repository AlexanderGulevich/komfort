/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.domainModel.pojo.Pojo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alek
 */
public class UnitOfWork {
    
    private List <Pojo>newPojoes=new ArrayList<>();
    private List <Pojo>removedPojoes=new ArrayList<>();
    private List <Pojo>changedPojoes=new ArrayList<>();
    
 
    
    public void setNewPojoes(Pojo p){
    
        this.newPojoes.add(p);
        
    }
    public List <Pojo> getNewPojoes(){
    
        return newPojoes;
        
    }
    public void clearNewPojoesList(){
    
        this.newPojoes.clear();
    
    }
    
    
}
