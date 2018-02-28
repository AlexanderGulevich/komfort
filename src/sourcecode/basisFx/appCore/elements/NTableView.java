/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.controlPolicy.Column;
import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.events.TableListener;
import java.util.Iterator;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public  class NTableView <T> extends AppNode {

    private TableView<T> table=null;
    private ObservableList<T>  list=FXCollections.<T> observableArrayList();
    private UnitOfWork unitOfWork=new UnitOfWork();
    private TableListener  tableListener=new TableListener (this);
    
    @SuppressWarnings("unchecked")
    NTableView(NodeBuilder builder) {
        table=new TableView<>(list);
        setElement(table);
        table.setEditable(true);
        init(builder);
        list.addListener(tableListener);

    }
/**
 * @param policy  
 * TableView.CONSTRAINED_RESIZE_POLICY,                 
 * TableView.UNCONSTRAINED_RESIZE_POLICY
 */
    public NTableView<T>  setColumnResizePolicy( Callback<TableView.ResizeFeatures,Boolean> policy){
        table.setColumnResizePolicy(policy);
        return this;
    }
    @SuppressWarnings("unchecked")
    public NTableView<T>  setColums(Column  ...columns){
       
         for (Column column : columns) {
             
             column.setTableViewManager(this);
            
             table.getColumns().addAll(column.getColumn());
             
         }
         
       
         setSortableAllCollums(false);
    
         return this;
        
     }
    public NTableView<T>  setSortableAllCollums(boolean b){

        ObservableList<TableColumn<T, ?>> columns = table.getColumns();
        
         for (Iterator<TableColumn<T, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<T, ? extends Object> next = iterator.next();
             next.setSortable(b); 
         }
   
          return this;
     }
    public NTableView<T>  setEditable(boolean isEditable){
         
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
        this.list.add(pojo);
    };
    public ObservableList cloneAllPojo()throws CloneNotSupportedException{
    
    ObservableList<T>  clon=FXCollections.observableArrayList(this.list);
    
    return clon;
 
    }
    public NTableView setList(ObservableList<T> tablesPojo) {
        
        this.table.setItems(tablesPojo);
        
        return this;
    
    }
    public  ObservableList<T>  getList(){
    
        return this.list;
        
        
    }
    

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }
    
    
    
    public void refresh(){
    
        
    
    }
  
     

}
