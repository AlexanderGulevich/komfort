package basisFx.appCore.elements;

import basisFx.appCore.Mediator;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.interfaces.Actionable;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.controls.TableListener;
import basisFx.domain.domaine.DomainObject;
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
import javafx.util.Callback;

public  class TableWrapper extends AppNode implements Actionable {
    private boolean isEditable=true;
    private Callback<TableView.ResizeFeatures,Boolean> columnResizePolicy ;
    private boolean isSortableColums;
    private double prefHeight;
    private Mediator mediator;
    private ColumnWrapper [] columnWrappers;
    private TableView<DomainObject> element =null;
    private ObservableList<DomainObject>  list=FXCollections.<DomainObject> observableArrayList();
    public UnitOfWork unitOfWork=null;
    private TableListener  tableListener=new TableListener (this);
    public  DomainObject clickedDomain;

    @SuppressWarnings("unchecked")
 public TableWrapper() {
        element =new TableView<>(list);

        element.setEditable(isEditable);

        list.addListener(tableListener);
        unitOfWork.setRefreshable(this);


    }

    private void applyPlaceholder() {
        TextWrapper wrapper =TextWrapper.newBuilder()
                .setText("Контент отсутствует".toLowerCase())
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(25d)
                .setCssid(CSSID.PLACEHOLDER)
                .build();

        element.setPlaceholder(wrapper.getElement());
    }


    private void manageScrollBar(){
//        ScrollBar verticalBar = (ScrollBar) element.lookup(".scroll-bar:vertical");
        ScrollBar verticalBar = getVerticalScrollbar();

        verticalBar
                .visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(final ObservableValue<? extends Boolean> observableValue, final Boolean aBoolean, final Boolean aBoolean2) {
                System.err.println("Scrol Pane visible!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!".toUpperCase());

            }
        });


    }

    private ScrollBar getVerticalScrollbar()
    {
        ScrollBar result = null;
        for (Node n : element.lookupAll(".scroll-bar"))
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

    public void applyColumnResizePolicy(){
        element.setColumnResizePolicy(columnResizePolicy);
    }

    public TableView<DomainObject> getElement() {
        return element;
    }

    public void applyColums(){

         for (ColumnWrapper cw : columnWrappers) {

             cw.setTableWrapper(this);

//             cw.setEditPoliticy(editCreater.editCreate());

//             cw.initEditPoliticy();

             element.getColumns().addAll(cw.getColumn());

             applyColumsSize(cw);

         }


     }
    public void applySortableAllCollums(){

        ObservableList<TableColumn<DomainObject, ?>> columns = element.getColumns();

         for (Iterator<TableColumn<DomainObject, ?>> iterator = columns.iterator(); iterator.hasNext();) {
             TableColumn<DomainObject, ? extends Object> next = iterator.next();
             next.setSortable(isSortableColums);
         }

     }
    private TableWrapper applyColumsSize(ColumnWrapper columnWrapper) {

        TableColumn column = columnWrapper.getColumn();
        column.prefWidthProperty()
                .bind(this.element.widthProperty().multiply(
                columnWrapper.getColumnSize()
                ));

        return this;

    }
    public TableWrapper applyTablesWidthProperty(double val, ReadOnlyDoubleProperty widthProperty) {
        element.prefWidthProperty()
                .bind(widthProperty.multiply(val));

        return this;

    }
    public ObservableList cloneAllPojo()throws CloneNotSupportedException{

    ObservableList<DomainObject>  clon=FXCollections.observableArrayList(this.list);

    return clon;

    }

    private void setClickedUpDownRowDetection(){

        element.setOnKeyPressed(event -> {

                    if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {

                        DomainObject itemFromEvent = element.getSelectionModel().getSelectedItem();

                        int size = element.getItems().size();
                        int selectedIndex = element.getSelectionModel().getSelectedIndex();

                        int nextIndex=0;

                        if(event.getCode() == KeyCode.UP ) nextIndex=selectedIndex-1;
                        if(event.getCode() == KeyCode.DOWN)nextIndex=selectedIndex+1;

                        clickedDomain= element.getItems().get(nextIndex);


                        if (mediator != null) {
                            mediator.inform(this);
                        }



                    }
                }
        );
    }


    private void scrollToDomainObectItem(DomainObject domainObject) {
        int newPojoIndex = element.getItems().indexOf(domainObject);
        element.scrollTo(newPojoIndex);
        element.getSelectionModel().select(newPojoIndex);
//        element.getSelectionModel().focus(newPojoIndex);
    }

    private void setClickedRowDetection(){

        element.setRowFactory(tv -> {
            TableRow<DomainObject> row = new TableRow<>();

            row.setOnMouseClicked(event -> {

                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                   clickedDomain=row.getItem();


                    if (mediator != null) {
                        mediator.inform(this);
                    }

                }
            }
            );
            return row ;
        });


    }

    @Override
    public void action() {

    }
}
