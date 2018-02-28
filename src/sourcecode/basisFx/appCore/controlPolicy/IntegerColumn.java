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
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author 62
 * @param <T>
 */
public class IntegerColumn <T> extends Column<T>{
    protected TableColumn<T,Integer> column;
    protected String propertyName;
    protected DomainChange embededBehavior;

    public IntegerColumn(String columnName,String propertyName) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        setEddingPoliticy();
        setOnEditCommit();
 
    }
     public IntegerColumn(String columnName,String propertyName, ValueChecking valueChecking,DomainChange embBeh) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        this.embededBehavior=embBeh;
        setEddingPoliticy();
        
    }

    public IntegerColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                        TextFieldTableCell.forTableColumn(
               new IntegerStringConverter()
                        ));
        return this;
    }

      public TableColumn<T,Integer>  getColumn(){
    
        return this.column;
    
    }
        public void setOnEditCommit() {
            
            column.setOnEditCommit((event) -> {
              
                if (event.getRowValue().equals(tableManeger.getUnitOfWork().getNewPojoes().get(0))) {
               
                    this.embededBehavior.change(
                            (DomainObject) event.getRowValue(),
                            event.getNewValue()
                            );
         
                   
                }
                
               

        });
             
       }
}
