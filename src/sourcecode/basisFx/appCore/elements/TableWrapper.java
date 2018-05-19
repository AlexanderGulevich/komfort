/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;


import basisFx.appCore.DataTransferSubmitObject;
import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.Submitted;
import basisFx.appCore.interfaces.Refreshable;
import basisFx.appCore.interfaces.SubmittingDomains;
import basisFx.appCore.fabrics.TextFabric;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.controls.TableListener;
import basisFx.appCore.domainScetch.DomainObject;

import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.util.Callback;

public  class TableWrapper<T> extends AppNode implements Refreshable, SubmittingDomains,Submitted {

    private TableView<DomainObject> table=null;
    private ObservableList<DomainObject>  list=FXCollections.<DomainObject> observableArrayList();
    private UnitOfWork unitOfWork=new UnitOfWork();
    private TableListener  tableListener=new TableListener (this);
    protected DataMapper dataMapper;
    private ArrayList <TableWrapper> observers=new ArrayList();
    private boolean isObserver=false;
    private  DomainObject clickedDomain;


    @SuppressWarnings("unchecked")
 public TableWrapper(NodeBuilder builder) {
        table=new TableView<>(list);
        setElement(table);
        table.setEditable(true);
        init(builder);
        setClickedRowDetection();
        setClickedUpDownRowDetection();
        list.addListener(tableListener);
        unitOfWork.setRefreshable(this);


        TextFabric textFabric=new TextFabric();
        TextWrapper text =
                textFabric.createText(
                        "Контент отсутствует".toLowerCase(),
                        FontsStore.ROBOTO_LIGHT,
                        25d,
                        null,
                        null,
                        CSSID.PLACEHOLDER);

        Text elem = (Text) text.getElement();
        table.setPlaceholder(elem);



    }


    private void manageScrollBar(){
//todo баг в системе не дает найти скролл в таблице и поэтому пока не могу уменьшить ширину активной ячейки, чтобы скролл не напрыгивал на нее
        ScrollBar verticalBar = (ScrollBar) table.lookup(".scroll-bar:vertical");
//        ScrollBar verticalBar = getVerticalScrollbar();

        System.err.println("verticalBarverticalBarverticalBar-----"+verticalBar);
//        verticalBar
//                .visibleProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(final ObservableValue<? extends Boolean> observableValue, final Boolean aBoolean, final Boolean aBoolean2) {
//                System.err.println("Scrol Pane visible".toUpperCase());
//
//            }
//        });


    }

    private ScrollBar getVerticalScrollbar()
    {
        ScrollBar result = null;
        for (Node n : table.lookupAll(".scroll-bar"))
        {
            if (n instanceof ScrollBar)
            {
                ScrollBar bar = (ScrollBar) n;
                if (bar.getOrientation().equals(Orientation.VERTICAL))
                {
                    result = bar;
                }
            }
        }
        return result;
    }

    public boolean isObserver() {
        return isObserver;
    }

    public KindOfSubmitElement getMark (){
        return  this.mark;
    }

    public void markAsObserver(boolean isObserver) {
        this.isObserver = isObserver;
    }

    public void setDataMapperToObject(DomainObject d){
        d.setDataMapper(dataMapper);
    }

    public TableWrapper<T> setColumnResizePolicy(Callback<TableView.ResizeFeatures,Boolean> policy){
        table.setColumnResizePolicy(policy);
        return this;
    }

    public TableView<DomainObject> getTable() {
        return table;
    }

    @SuppressWarnings("unchecked")
    public TableWrapper<T> setColums(ColumnWrapper  ...columnWrappers){
       
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
    public TableWrapper<T> setSortableAllCollums(boolean b){

        ObservableList<TableColumn<DomainObject, ?>> columns = table.getColumns();
        
         for (Iterator<TableColumn<DomainObject, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<DomainObject, ? extends Object> next = iterator.next();
             next.setSortable(b); 
         }
   
          return this;
     }
    public TableWrapper<T> setEditable(boolean isEditable){
         
          this.table.setEditable(isEditable);
          return this;
        
     }
    private TableWrapper<T> setColumsSize(ColumnWrapper columnWrapper) {
       
        TableColumn column = columnWrapper.getColumn();
        column.prefWidthProperty()
                .bind(this.table.widthProperty().multiply(
                columnWrapper.getColumnSize()
                ));
        
        return this;
     

    }
    public TableWrapper<T> setTablesWidthProperty(double val, ReadOnlyDoubleProperty widthProperty) {
        table.prefWidthProperty()
                .bind(widthProperty.multiply(val));

        return this;

    }
    public TableWrapper<T> setTablesHeight(double val) {
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
    public TableWrapper setList(ObservableList<DomainObject> tablesPojo) {
        
        this.table.setItems(tablesPojo);
        
        return this;
    
    }
    public  ObservableList<DomainObject>  getList(){
    
        return this.list;

    }

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }

    public TableWrapper setDataMapper(DataMapper dm) {
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

    public DomainObject getClickedDomain() {
        return clickedDomain;
    }

    @Override
    public TableWrapper refresh(){
        System.out.println("TableWrapper.refresh");

        if (isObserver){
            System.out.println("TableWrapper refresh()---isObserver TRUE    clickedDomain---"+clickedDomain.getId());
            refresh(clickedDomain);

        }else {

            this.table.getItems().clear();
            this.list.clear();
            this.unitOfWork.clearStoredPojoesId();

            this.dataMapper.getDomainList(list);
            setDataMapperToList(list);

        }

        return this;
    }

    @Override
    public TableWrapper refresh(DomainObject selectedDomainObject) {

        System.out.println("TableWrapper.refresh(DomainObject selectedDomainObject)");

        this.table.getItems().clear();
        this.list.clear();
        this.unitOfWork.clearStoredPojoesId();

        setDataMapperToList(list);
        this.dataMapper.getDomainListForObserverTables(list,selectedDomainObject);

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

                        for (TableWrapper observer : observers) {

                            if (selectedItem.getId() != null) {

                                System.out.println("TableWrapper.setClickedRowDetection()   ---   for (TableWrapper observer : observers) {");

                                observer.setClickedDomain(selectedItem);
                                observer.dataMapper.setObservableDomaineId(selectedItem.getId());


                                if (!observers.isEmpty()) {


                                    for (TableWrapper concreteObserver : observers) {
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


                    for (TableWrapper observer : observers) {

                        if (domainObject.getId() !=null) {

                            System.out.println("TableWrapper.setClickedRowDetection()   ---   for (TableWrapper observer : observers) {");

                            observer.setClickedDomain(domainObject);
                            observer.dataMapper.setObservableDomaineId(domainObject.getId());



                            if (!observers.isEmpty()){


                                for (TableWrapper concreteObserver : observers) {
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

    public TableWrapper setBoundTable(TableWrapper observer){
            observer.markAsObserver(true);
            observers.add(observer);

        return this;
    }


    @Override
    public ObservableList<DomainObject> submitList() {
        return this.list;
    }

    @Override
    public DataTransferSubmitObject extractData() {
        return new DataTransferSubmitObject(this);
    }
}
