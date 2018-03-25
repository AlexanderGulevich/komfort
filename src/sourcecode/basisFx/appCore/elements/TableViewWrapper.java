/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.Refreshable;
import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.controlPolicy.TableListener;
import basisFx.appCore.domainScetch.DomainObject;
import java.util.Iterator;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public  class TableViewWrapper <T> extends AppNode implements Refreshable{

    private TableView<DomainObject> table=null;
    private ObservableList<DomainObject>  list=FXCollections.<DomainObject> observableArrayList();
    private UnitOfWork unitOfWork=new UnitOfWork();
    private TableListener  tableListener=new TableListener (this);
    protected DataMapper dataMapper;
    protected String tableName;

    
    
    @SuppressWarnings("unchecked")
 public   TableViewWrapper(NodeBuilder builder) {
        table=new TableView<>(list);

        setElement(table);
        table.setEditable(true);
        init(builder);
        list.addListener(tableListener);
        unitOfWork.setRefreshable(this);


      

    }
/**
 * @param policy  
 * TableView.CONSTRAINED_RESIZE_POLICY,                 
 * TableView.UNCONSTRAINED_RESIZE_POLICY
 */
    public TableViewWrapper<T>  setColumnResizePolicy( Callback<TableView.ResizeFeatures,Boolean> policy){
        table.setColumnResizePolicy(policy);
        return this;
    }
    @SuppressWarnings("unchecked")
    public TableViewWrapper<T>  setColums(ColumnWrapper  ...columnWrappers){
       
         for (ColumnWrapper cw : columnWrappers) {
             
             cw.setTableWrapper(this);
             
             cw.initEditPoliticy();
            
             table.getColumns().addAll(cw.getColumn());
             
             setColumsSize(cw);

         }
         
       
         setSortableAllCollums(false);
    
         return this;
        
     }
    public TableViewWrapper<T>  setSortableAllCollums(boolean b){

        ObservableList<TableColumn<DomainObject, ?>> columns = table.getColumns();
        
         for (Iterator<TableColumn<DomainObject, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<DomainObject, ? extends Object> next = iterator.next();
             next.setSortable(b); 
         }
   
          return this;
     }
    public TableViewWrapper<T>  setEditable(boolean isEditable){
         
          this.table.setEditable(isEditable);
          return this;
        
     }
    private TableViewWrapper<T> setColumsSize(ColumnWrapper columnWrapper) {
       
        TableColumn column = columnWrapper.getColumn();
        column.prefWidthProperty()
                .bind(this.table.widthProperty().multiply(
                columnWrapper.getColumnSize()
                ));
        
        return this;
     

    }
    public TableViewWrapper<T> setTablesWidthProperty(double val, ReadOnlyDoubleProperty widthProperty) {
        table.prefWidthProperty()
                .bind(widthProperty.multiply(val));

        return this;

    }
    public TableViewWrapper<T> setTablesHeight(double val) {
        table.setPrefHeight(val);

        return this;

    }
    public void setPojo(DomainObject pojo){
        this.list.add(pojo);
    };
    public ObservableList cloneAllPojo()throws CloneNotSupportedException{
    
    ObservableList<DomainObject>  clon=FXCollections.observableArrayList(this.list);
    
    return clon;
 
    }
    public TableViewWrapper setList(ObservableList<DomainObject> tablesPojo) {
        
        this.table.setItems(tablesPojo);
        
        return this;
    
    }
    public  ObservableList<DomainObject>  getList(){
    
        return this.list;

    }

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }

    public TableViewWrapper setDataMapper(DataMapper dm) {
        this.dataMapper=dm;
        this.dataMapper.setUnitOfWork(this.unitOfWork);



        return this;
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }

    public TableViewWrapper setDbTableName(String n) {
        this.tableName=n;
        return this;
    }
   
    @Override
    public TableViewWrapper refresh(){
      
        this.table.getItems().clear();
        this.list.clear();
        this.unitOfWork.clearStoredPojoesId();
        
        
        this.dataMapper.getAllDomainObjectList(list,tableName);
        
        

        return this;
        
       
        
    
    }
  
     

}
