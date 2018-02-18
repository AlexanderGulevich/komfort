/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.Pojo;
import java.util.Iterator;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public  class NTableView <T extends Pojo> extends AppNode {

    private   TableView<T> table=null;
    private  ObservableList <T>  allPojo=FXCollections.<T> observableArrayList();

    NTableView(NodeBuilder builder) {
        
        element=new TableView();

        table=(TableView<T>) this.element;
        
        init(builder);
       
     
    }
    
    
    
    

    
     public NTableView setColums(TableColumn  ...columns){
     
         for (TableColumn column : columns) {
            
             table.getColumns().addAll(column);
             
         }
           
               
          return this;
        
     }
     public NTableView setSortableAllCollums(boolean b){
     
        
        ObservableList<TableColumn<T, ?>> columns = table.getColumns();
        
         for (Iterator<TableColumn<T, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<T, ? extends Object> next = iterator.next();
             next.setSortable(b);
         }
             
        
           
               
          return this;
        
     }
     
     public NTableView setEditable(boolean isEditable){
         
          this.table.setEditable(isEditable);
          return this;
        
     }
     



    public NTableView<T> setColumsSize(int colNum,double val) {
        table.getColumns().get(colNum).prefWidthProperty()
                .bind(this.table.widthProperty().multiply(val));
        
        return this;
     

    }
    

    public NTableView<T> setTablesSize(double val,ReadOnlyDoubleProperty widthProperty) {
        table.prefWidthProperty()
                .bind(widthProperty.multiply(val));
     
        return this;

    }
    
    
    
    public void setPojo(T pojo){
        this.allPojo.add(pojo);
    };
    
    public ObservableList cloneAllPojo()throws CloneNotSupportedException{
    
    ObservableList<T>  col=FXCollections.observableArrayList(this.allPojo);
    
    return col;
 
    }
     
     

}
