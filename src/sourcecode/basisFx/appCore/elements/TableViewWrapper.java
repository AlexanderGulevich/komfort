/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.functional.Refreshable;
import basisFx.appCore.functional.SubmittingDomains;
import basisFx.appCore.TextFabric;
import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.controlPolicy.TableListener;
import basisFx.appCore.domainScetch.DomainObject;

import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.settings.FontsStore;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.util.Callback;

public  class TableViewWrapper <T> extends AppNode implements Refreshable, SubmittingDomains {

    private TableView<DomainObject> table=null;
    private ObservableList<DomainObject>  list=FXCollections.<DomainObject> observableArrayList();
    private UnitOfWork unitOfWork=new UnitOfWork();
    private TableListener  tableListener=new TableListener (this);
    protected DataMapper dataMapper;
    private ArrayList <TableViewWrapper> observers=new ArrayList();
    private boolean isObserver=false;
    private  DomainObject clickedDomain;


    @SuppressWarnings("unchecked")
 public   TableViewWrapper(NodeBuilder builder) {
        table=new TableView<>(list);
        setElement(table);
        table.setEditable(true);
        init(builder);
        setClickedRowDetection();
        setClickedUpDownRowDetection();
        list.addListener(tableListener);
        unitOfWork.setRefreshable(this);

//todo вставить значение
        TextFabric textFabric=new TextFabric();
        TextWrapper text = textFabric.createText("Контент отсутствует", FontsStore.ROBOTO_LIGHT, 25d, null, null);
        Text elem = (Text) text.getElement();
        table.setPlaceholder(elem);

    }

    public void markAsObserver(boolean isObserver) {
        this.isObserver = isObserver;
    }

    public void setDataMapperToObject(DomainObject d){
        d.setDataMapper(dataMapper);
    }

    public TableViewWrapper<T>  setColumnResizePolicy( Callback<TableView.ResizeFeatures,Boolean> policy){
        table.setColumnResizePolicy(policy);
        return this;
    }
    @SuppressWarnings("unchecked")
    public TableViewWrapper<T>  setColums(ColumnWrapper  ...columnWrappers){
       
         for (ColumnWrapper cw : columnWrappers) {
             
             cw.setTableWrapper(this);
             
//             cw.setEditPoliticy(editPoliticy);
             cw.setEditPoliticy(editCreater.editCreate());

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

    public void setDataMapperToList( ObservableList<DomainObject>  list){
        for (DomainObject domainObject : list) {
            domainObject.setDataMapper(dataMapper);
        }

    }

    public void setClickedDomain(DomainObject clickedDomain) {
        System.out.println("setClickedDomain(DomainObject clickedDomain)");
        this.clickedDomain = clickedDomain;
    }

    @Override
    public TableViewWrapper refresh(){
        System.out.println("TableViewWrapper.refresh");

        if (isObserver){
            System.out.println("TableViewWrapper refresh()---isObserver TRUE    clickedDomain---"+clickedDomain.getId());
            refresh(clickedDomain);

        }else {

            this.table.getItems().clear();
            this.list.clear();
            this.unitOfWork.clearStoredPojoesId();

            this.dataMapper.getAllDomainObjectList(list);
            setDataMapperToList(list);

        }
        return this;
    }

    @Override
    public TableViewWrapper refresh(DomainObject selectedDomainObject) {

        System.out.println("TableViewWrapper.refresh(DomainObject selectedDomainObject)");

        this.table.getItems().clear();
        this.list.clear();
        this.unitOfWork.clearStoredPojoesId();

        setDataMapperToList(list);
        this.dataMapper.getAllDomainObjectList(list,selectedDomainObject);

        return this;
    }

    private void setClickedUpDownRowDetection(){

        table.setOnKeyPressed(event -> {

                    if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {

                        DomainObject itemFromEvent = table.getSelectionModel().getSelectedItem();

                        int size = table.getItems().size();
                        int selectedIndex = table.getSelectionModel().getSelectedIndex();

                        int nextIndex=0;

                        if(event.getCode() == KeyCode.UP ) nextIndex=selectedIndex-1;
                        if(event.getCode() == KeyCode.DOWN)nextIndex=selectedIndex+1;

                        DomainObject selectedItem = table.getItems().get(nextIndex);

                        System.out.println("table.setOnKeyPressed(event -> ");

                        for (TableViewWrapper observer : observers) {

                            if (selectedItem.getId() != null) {

                                System.out.println("TableViewWrapper.setClickedRowDetection()   ---   for (TableViewWrapper observer : observers) {");

                                observer.setClickedDomain(selectedItem);
                                observer.dataMapper.setObservableDomaineId(selectedItem.getId());


                                if (!observers.isEmpty()) {


                                    for (TableViewWrapper concreteObserver : observers) {
                                        concreteObserver.refresh(selectedItem);
                                    }

                                }


                            }


                        }



                    }
                }

        );



    }

    private void setClickedRowDetection(){

        table.setRowFactory(tv -> {
            TableRow<DomainObject> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                   DomainObject domainObject=row.getItem();


                    for (TableViewWrapper observer : observers) {

                        if (domainObject.getId() !=null) {

                            System.out.println("TableViewWrapper.setClickedRowDetection()   ---   for (TableViewWrapper observer : observers) {");

                            observer.setClickedDomain(domainObject);
                            observer.dataMapper.setObservableDomaineId(domainObject.getId());



                            if (!observers.isEmpty()){


                                for (TableViewWrapper concreteObserver : observers) {
                                    concreteObserver.refresh(domainObject);
                                }

                            }


                        }


                    }




                }
            }

            );






            return row ;
        });


    }

    public  TableViewWrapper setBoundTable(TableViewWrapper observer){
            observer.markAsObserver(true);
            observers.add(observer);

        return this;
    }


    @Override
    public ObservableList<DomainObject> submitList() {
        return this.list;
    }
}
