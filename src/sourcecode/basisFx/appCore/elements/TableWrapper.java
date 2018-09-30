package basisFx.appCore.elements;

import basisFx.appCore.Mediator;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.domain.domaine.ActiveRecord;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.controls.TableListener;

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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public  class TableWrapper extends AppNode  {
    private boolean isEditable;
    private Callback<TableView.ResizeFeatures,Boolean> columnResizePolicy ;
    private boolean isSortableColums;
    private Double widthPercent;
    private ReadOnlyDoubleProperty parentWidthProperty;
    private double prefHeight;
    private Mediator mediator;
    private ColumnWrapper [] columnWrappers;
    private TableView<ActiveRecord> element;
    private ObservableList<ActiveRecord>  list=FXCollections.observableArrayList();
    public UnitOfWork unitOfWork;
    private TableListener  tableListener=new TableListener (this);
    public  ActiveRecord clickedDomain;
    public  ActiveRecord activeRecord;

    private TableWrapper(Builder builder) {

        events = builder.events;
        width = builder.width;
        height = builder.height;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        name = builder.name;
        stage = builder.stage;
        isEditable = builder.isEditable;
        columnResizePolicy = builder.columnResizePolicy;
        isSortableColums = builder.isSortableColums;
        prefHeight = builder.prefHeight;
        setMediator(builder.mediator);
        columnWrappers = builder.columnWrappers;
        unitOfWork = builder.unitOfWork;
        clickedDomain = builder.clickedDomain;
        activeRecord = builder.activeRecord;
        widthPercent=builder.widthPercent;
        parentWidthProperty=builder.parentWidthProperty;
        isEditable=builder.isEditable;


        element =new TableView<>(list);
        element.setId(CSSID.TABLE.get());

        applyColumnResizePolicy();
        applyColums();
        applyListener();
        applyEditable();
        applyColumnResizePolicy();
        applyPlaceholder();
        applySortableAllCollums();
        applyTablesWidthProperty();


//        manageScrollBar();
        setClickedRowDetection();
        setClickedUpDownRowDetection();


    }

    public static Builder newBuilder() {
        return new Builder();
    }


    private void applyListener() {
        list.addListener(tableListener);
    }
    private void applyEditable() {
        element.setEditable(isEditable);
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

        verticalBar.visibleProperty().addListener((observableValue, aBoolean, aBoolean2) ->
                System.err.println("Scrol Pane visible!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!".toUpperCase()));
    }
    private void applyColumnResizePolicy(){

        if (columnResizePolicy != null) {
            element.setColumnResizePolicy(columnResizePolicy);
        }

    }
    private void applyColums(){

        if (columnWrappers != null) {
            for (ColumnWrapper cw : columnWrappers) {
                cw.setTableWrapper(this);
//             cw.setEditPoliticy(editCreater.editCreate());
//             cw.initEditPoliticy();
                element.getColumns().addAll(cw.getColumn());
                applyColumsSize(cw);
            }
        }


    }
    private void applySortableAllCollums(){

        ObservableList<TableColumn<ActiveRecord, ?>> columns = element.getColumns();

        for (Iterator<TableColumn<ActiveRecord, ?>> iterator = columns.iterator(); iterator.hasNext();) {
            TableColumn<ActiveRecord, ? extends Object> next = iterator.next();
            next.setSortable(isSortableColums);
        }
    }
    private void applyColumsSize(ColumnWrapper columnWrapper) {
        TableColumn column = columnWrapper.getColumn();
        column.prefWidthProperty()
                .bind(this.element.widthProperty().multiply(
                        columnWrapper.getColumnSize()
                ));
    }
    private void applyTablesWidthProperty() {

        if (widthPercent != null) {
            if (parentWidthProperty != null) {
                element.prefWidthProperty()
                        .bind(parentWidthProperty.multiply(widthPercent));
            }
        }




    }
    public TableView<ActiveRecord> getElement() {
        return element;
    }
    private ScrollBar getVerticalScrollbar() {
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
    public ObservableList cloneAllPojo()throws CloneNotSupportedException{

    ObservableList<ActiveRecord>  clon=FXCollections.observableArrayList(this.list);

    return clon;

    }
    private void setClickedUpDownRowDetection(){

        element.setOnKeyPressed(event -> {

                    if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {

                        ActiveRecord itemFromEvent = element.getSelectionModel().getSelectedItem();

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
    private void setClickedRowDetection(){
        element.setRowFactory(tv -> {
            TableRow<ActiveRecord> row = new TableRow<>();
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
    private void scrollToDomainObectItem(ActiveRecord domainObject) {
        int newPojoIndex = element.getItems().indexOf(domainObject);
        element.scrollTo(newPojoIndex);
        element.getSelectionModel().select(newPojoIndex);
//        element.getSelectionModel().focus(newPojoIndex);
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public static final class Builder {
        private ReadOnlyDoubleProperty parentWidthProperty;
        private double widthPercent;
        private ArrayList<AppEvent> events;
        private Double width;
        private Double height;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private Stage stage;
        private boolean isEditable;
        private Callback<TableView.ResizeFeatures, Boolean> columnResizePolicy;
        private boolean isSortableColums;
        private double prefHeight;
        private Mediator mediator;
        private ColumnWrapper[] columnWrappers;
        private UnitOfWork unitOfWork;
        private ActiveRecord clickedDomain;
        private ActiveRecord activeRecord;


        public Builder setWidthPercent(double widthPercent) {
            this.widthPercent = widthPercent;
            return this;
        }


        public Builder setSortableColums(boolean sortableColums) {
            isSortableColums = sortableColums;
            return this;
        }

        public Builder setParentWidthProperty(ReadOnlyDoubleProperty property) {
            parentWidthProperty = property;
            return this;
        }



        private Builder() {
        }



        public Builder setEvents(ArrayList<AppEvent> val) {
            events = val;
            return this;
        }

        public Builder setWidth(Double val) {
            width = val;
            return this;
        }

        public Builder setHeight(Double val) {
            height = val;
            return this;
        }

        public Builder setParentAnchor(AnchorPane val) {
            parentAnchor = val;
            return this;
        }

        public Builder setParentGroup(Group val) {
            parentGroup = val;
            return this;
        }

        public Builder setParentFlowPane(FlowPane val) {
            parentFlowPane = val;
            return this;
        }

        public Builder setParentScrollPane(ScrollPane val) {
            parentScrollPane = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Builder setStage(Stage val) {
            stage = val;
            return this;
        }

        public Builder setIsEditable(boolean val) {
            isEditable = val;
            return this;
        }

        public Builder setColumnResizePolicy(Callback<TableView.ResizeFeatures, Boolean> val) {
            columnResizePolicy = val;
            return this;
        }

        public Builder setIsSortableColums(boolean val) {
            isSortableColums = val;
            return this;
        }

        public Builder setPrefHeight(double val) {
            prefHeight = val;
            return this;
        }

        public Builder setMediator(Mediator val) {
            mediator = val;
            return this;
        }

        public Builder setColumnWrappers(ColumnWrapper[] val) {
            columnWrappers = val;
            return this;
        }

        public Builder setUnitOfWork(UnitOfWork val) {
            unitOfWork = val;
            return this;
        }

        public Builder setClickedDomain(ActiveRecord val) {
            clickedDomain = val;
            return this;
        }

        public Builder setActiveRecord(ActiveRecord val) {
            activeRecord = val;
            return this;
        }

        public TableWrapper build() {
            return new TableWrapper(this);
        }
    }
}
