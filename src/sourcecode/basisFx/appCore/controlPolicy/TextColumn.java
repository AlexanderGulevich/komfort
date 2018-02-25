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
    protected DomainChange <T,String>embededBehavior;
    
    public TextColumn(String columnName,String propertyName,DomainChange embBeh) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        this.embededBehavior=embBeh;
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
              
                if (event.getRowValue().equals(unitOfWork.getNewPojoes().get(0))) {
               
                    DomainObject d= (DomainObject) event.getRowValue();
                    
                    this.embededBehavior.add(d,event.getNewValue());
                    
                    if (d.isReadyToTransaction()) {
                         unitOfWork.setChangedPojoes(d);
                         unitOfWork.commitNew();
                         unitOfWork.clearNewPojoesList();
                    } 
                    
                   
                }
                
               

        });
             
       }
       
       
      
}
