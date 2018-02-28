/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.domainModel.pojo.DomainObject;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Alek
 * @param <T>
 */
public class TextColumn<T> extends Column<T>{
    protected TableColumn<T,String> column;
    protected String propertyName;
    protected DomainChange <T,String>domainChange;
    protected ValueChecking valueChecking;
    
    public TextColumn(String columnName,String propertyName, ValueChecking valueChecking,DomainChange embBeh) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        this.domainChange=embBeh;
        this.valueChecking=valueChecking;
        setEddingPoliticy();
        setOnEditCommit();
        
    }
 
    public TextColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        return this;
    }
    
      public TableColumn<T,String> getColumn(){
    
        return this.column;
    
    }
      
      
      
       public void setOnEditCommit() {
            
            column.setOnEditCommit((event) -> {
               
                DomainObject domain= (DomainObject) event.getRowValue();
              
                //проверяет, новый ли это объект
                if (tableManeger.getUnitOfWork().getNewPojoes().contains(domain)) {

                    //вставить значение в домен
                    this.domainChange.change(domain,event.getNewValue());
                    
                    if (domain.isReadyToTransaction()) {
//                         unitOfWork.setChangedPojoes(domain);
                         tableManeger.getUnitOfWork().commitNew();
                        
                         
//                         tableManeger.refresh(event.getTablePosition());
                    } 
                    
                   
                }
                else 
                    if(tableManeger.getUnitOfWork().getChangedPojoes().contains(domain)) {
                     //вставить значение в домен
                    this.domainChange.change(domain,event.getNewValue());
//                    
                    if (domain.isReadyToTransaction()) {
                         tableManeger.getUnitOfWork().setChangedPojoes(domain);
                         tableManeger.getUnitOfWork().commitChanged();
                       
                    } 
                    
                
                
                
                }
             
                
               

        });
             
       }
       
       
      
}
