package basisFx.appCore.elements;

import basisFx.appCore.DataTransferSubmitObject;
import basisFx.appCore.Mediator;
import basisFx.appCore.Submitted;
import basisFx.appCore.fabrics.TextFabric;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.dataSource.ActiveRecord;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.controls.TableListener;
import basisFx.domain.domaine.DomainObject;
import java.util.ArrayList;
import java.util.Iterator;
import basisFx.appCore.settings.CSSID;
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

public  class TableWrapper extends AppNode    {
    private boolean isEditable;
    private double prefHeight;
    private Mediator mediator;
    private TableView<DomainObject> element =null;
    private ObservableList<DomainObject>  list=FXCollections.<DomainObject> observableArrayList();
    private UnitOfWork unitOfWork=new UnitOfWork();
    private TableListener  tableListener=new TableListener (this);
    protected ActiveRecord activeRecord;
    private  DomainObject clickedDomain;

    @SuppressWarnings("unchecked")
 public TableWrapper() {
        element =new TableView<>(list);

        element.setEditable(true);

        setClickedRowDetection();
        setClickedUpDownRowDetection();
        list.addListener(tableListener);
        unitOfWork.setRefreshable(this);

        setPlaceholder();

    }


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    private void setPlaceholder() {
        TextWrapper wrapper =TextWrapper.newBuilder()
                .setText("Контент отсутствует".toLowerCase())
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(25d)
                .setCssid(CSSID.PLACEHOLDER)
                .build();

        element.setPlaceholder(wrapper.getElement());
    }


//    private void manageScrollBar(){
////todo баг в системе не дает найти скролл в таблице и поэтому пока не могу уменьшить ширину активной ячейки, чтобы скролл не напрыгивал на нее
//        ScrollBar verticalBar = (ScrollBar) element.lookup(".scroll-bar:vertical");
////        ScrollBar verticalBar = getVerticalScrollbar();
//
////        verticalBar
////                .visibleProperty().addListener(new ChangeListener<Boolean>() {
////            @Override
////            public void changed(final ObservableValue<? extends Boolean> observableValue, final Boolean aBoolean, final Boolean aBoolean2) {
////                System.err.println("Scrol Pane visible".toUpperCase());
////
////            }
////        });
//
//
//    }

//    private ScrollBar getVerticalScrollbar()
//    {
//        ScrollBar result = null;
//        for (Node n : element.lookupAll(".scroll-bar"))
//        {
//            if (n instanceof ScrollBar)
//            {
//                ScrollBar bar = (ScrollBar) n;
//                if (bar.getOrientation().equals(Orientation.VERTICAL))
//                {
//                    result = bar;
//                }
//            }
//        }
//        return result;
//    }

    public void setDataMapperToObject(DomainObject d){
        d.setActiveRecord(activeRecord);
    }

    public TableWrapper setColumnResizePolicy(Callback<TableView.ResizeFeatures,Boolean> policy){
        element.setColumnResizePolicy(policy);
        return this;
    }

    public TableView<DomainObject> getElement() {
        return element;
    }

    public TableWrapper setColums(ColumnWrapper  ...columnWrappers){

         for (ColumnWrapper cw : columnWrappers) {

             cw.setTableWrapper(this);

//             cw.setEditPoliticy(editPoliticy);
             cw.setEditPoliticy(editCreater.editCreate());

             cw.initEditPoliticy();

             element.getColumns().addAll(cw.getColumn());

             setColumsSize(cw);

         }


         setSortableAllCollums(false);

         return this;

     }
    public TableWrapper setSortableAllCollums(boolean b){

        ObservableList<TableColumn<DomainObject, ?>> columns = element.getColumns();

         for (Iterator<TableColumn<DomainObject, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<DomainObject, ? extends Object> next = iterator.next();
             next.setSortable(b);
         }

          return this;
     }
    private TableWrapper setColumsSize(ColumnWrapper columnWrapper) {

        TableColumn column = columnWrapper.getColumn();
        column.prefWidthProperty()
                .bind(this.element.widthProperty().multiply(
                columnWrapper.getColumnSize()
                ));

        return this;


    }
    public TableWrapper setTablesWidthProperty(double val, ReadOnlyDoubleProperty widthProperty) {
        element.prefWidthProperty()
                .bind(widthProperty.multiply(val));

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

        this.element.setItems(tablesPojo);

        return this;

    }
    public  ObservableList<DomainObject>  getList(){

        return this.list;

    }

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }

    public TableWrapper setActiveRecord(ActiveRecord dm) {
        this.activeRecord =dm;
        this.activeRecord.setUnitOfWork(this.unitOfWork);

        return this;
    }

    public ActiveRecord getActiveRecord() {
        return activeRecord;
    }

    public void setDataMapperToList( ObservableList<DomainObject>  list){
        for (DomainObject domainObject : list) {
            domainObject.setActiveRecord(activeRecord);
        }

    }

    public void setClickedDomain(DomainObject clickedDomain) {
        this.clickedDomain = clickedDomain;
    }

    public DomainObject getClickedDomain() {
        return clickedDomain;
    }

    public TableWrapper refresh(){

        if (isObserver){

            refresh(clickedDomain);

        }else {
            this.element.getItems().clear();
            this.list.clear();
            this.unitOfWork.clearStoredPojoesId();
            this.activeRecord.getDomainList(list);
            setDataMapperToList(list);

            System.err.println("\n");
            System.err.println("TableWrapper.refresh");
            System.err.println("Обновление таблицы, которая не является обсервером");
            System.err.println("Объекты - количество- "+ element.getItems().size());
            System.err.println("\n");


        }

        return this;
    }

    public TableWrapper refresh(DomainObject selectedDomainObject) {


        this.element.getItems().clear();
        this.list.clear();
        this.unitOfWork.clearStoredPojoesId();
        this.unitOfWork.clearNewPojoesList();
        this.unitOfWork.clearChangedPojoesList();
        this.unitOfWork.clearRemovedPojoesList();

        setDataMapperToList(list);
        this.activeRecord.getDomainListForObserverTables(list,selectedDomainObject);

        System.err.println("\n");
        System.err.println("TableWrapper.refresh");
        System.err.println("Обновление таблицы-ОБСЕРВЕРА");
        System.err.println("Объекты - количество- "+ element.getItems().size());
        System.err.println("clickedDomain---"+clickedDomain.getId());
        System.err.println("\n");

        return this;
    }


    /**
     * This function operate click and notify all observers and get them clicked domaine id
     */
    private void setClickedUpDownRowDetection(){

        element.setOnKeyPressed(event -> {

                    if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {

                        DomainObject itemFromEvent = element.getSelectionModel().getSelectedItem();

                        int size = element.getItems().size();
                        int selectedIndex = element.getSelectionModel().getSelectedIndex();

                        int nextIndex=0;

                        if(event.getCode() == KeyCode.UP ) nextIndex=selectedIndex-1;
                        if(event.getCode() == KeyCode.DOWN)nextIndex=selectedIndex+1;

                        DomainObject selectedItem = element.getItems().get(nextIndex);

                        for (TableWrapper observer : observers) {

                            if (selectedItem.getId() != null) {

                                observer.setClickedDomain(selectedItem);
                                observer.activeRecord.setObservableDomaineId(selectedItem.getId());


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

        element.setRowFactory(tv -> {
            TableRow<DomainObject> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                   DomainObject domainObject=row.getItem();

                    for (TableWrapper observer : observers) {

                        if (domainObject.getId() !=null) {

                            observer.setClickedDomain(domainObject);
                            observer.activeRecord.setObservableDomaineId(domainObject.getId());

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

}
