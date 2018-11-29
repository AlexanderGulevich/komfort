package basisFx.appCore.elements;

import basisFx.service.ServiceMediator;
import basisFx.appCore.table.ColumnWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.domain.ActiveRecord;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.table.TableListener;

import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Callback;

public  class TableWrapper extends AppNode  {
    private boolean isEditable;
    private Callback<TableView.ResizeFeatures,Boolean> columnResizePolicy ;
    private boolean isSortableColums;
    private Double widthPercent;
    private ReadOnlyDoubleProperty parentWidthProperty;
    private double prefHeight;
    private ServiceMediator serviceMediator;
    private ColumnWrapper [] columnWrappers;
    private TableView<ActiveRecord> element;
    public ObservableList<ActiveRecord>  list;
    public UnitOfWork unitOfWork;
    private TableListener  tableListener=new TableListener (this);
    public  ActiveRecord clickedDomain;
    public  Class activeRecordClass;
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
        setServiceMediator(builder.serviceMediator);
        columnWrappers = builder.columnWrappers;
        unitOfWork = builder.unitOfWork;
        clickedDomain = builder.clickedDomain;
        activeRecordClass = builder.activeRecordClass;
        widthPercent=builder.widthPercent;
        parentWidthProperty=builder.parentWidthProperty;
        isEditable=builder.isEditable;

        createActiveRecord(builder);
        element =new TableView<>();
        applyCSS();
        applyColumnResizePolicy();
        applyColums();
        applyEditable();
        applyColumnResizePolicy();
        applyPlaceholder();
        applySortableAllCollums();
        applyTablesWidthProperty();
        setClickedRowDetection();
    }

    private void applyCSS() {
        element.setId(CSSID.TABLE.get());
    }

    public ServiceMediator getServiceMediator() {
        return serviceMediator;
    }

    private void createActiveRecord(Builder builder) {
        try {
            activeRecord= (ActiveRecord) builder.activeRecordClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ObservableList<ActiveRecord> getItems(){
        return element.getItems();
    }
    private void applyListener() {
        if (list != null) {
            list.addListener(tableListener);
        }
    }

    public void setItems(ObservableList<ActiveRecord> items){
        list=items;
        applyListener();
        element.setItems(list);
        element.refresh();

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
//    public void manageScrollBar() {
//        ScrollBar verticalBar = (ScrollBar) element.lookup(".scroll-bar:vertical");
//        if (verticalBar != null) {
//
//
//            verticalBar.visibleProperty().addListener((observableValue, aBoolean, aBoolean2) ->
//            {
//                if (aBoolean2) {
//                    Node clippedContainer = element.lookup(".clipped-container");
//                    Region region = (Region) clippedContainer;
//                    if (region != null) {
//                        region.setStyle("  -fx-padding:  0, 120, 0, 0; ");
//                        region.setPadding(new Insets(0d, 50d, 0d, 0d));
//
//                        region.setPrefWidth(region.prefWidthProperty().get() - 100d);
//                    }
//                }
//
//                if (aBoolean2) {
//                    Node virtual = element.lookup(".virtual-flow");
//                    Region  region2 = (Region) virtual;
//                    if (region2 != null) {
//                        region2.setStyle("  -fx-padding:  0, 120, 0, 0; ");
//                        region2.setPadding(new Insets(0d,50d,0d,0d));
//
//                        region2.setPrefWidth(region2.prefWidthProperty().get()-100d);
//                    }
//                }
//
//
//            }  );
//
//
//
//        }
//    }
    private void applyColumnResizePolicy(){
        if (columnResizePolicy != null) {
            element.setColumnResizePolicy(columnResizePolicy);
        }
    }
    private void applyColums(){
        if (columnWrappers != null) {
            for (ColumnWrapper cw : columnWrappers) {
                element.getColumns().add(cw.getColumn());
                applyColumsSize(cw);
                cw.tableWrapper=this;
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
                        columnWrapper.columnSize
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

    public ObservableList cloneAllPojo()throws CloneNotSupportedException{
        ObservableList<ActiveRecord>  clon=FXCollections.observableArrayList(this.list);
        return clon;
    }
    private void setClickedRowDetection(){
        element.setRowFactory(tv -> {
            TableRow<ActiveRecord> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 1) {
                   clickedDomain=row.getItem();
                    if (serviceMediator != null) {
                        serviceMediator.inform(this);
                    }
                }
            }
            );
            return row ;
        });
    }
    public void scrollToItem(ActiveRecord domainObject) {
        int newPojoIndex = element.getItems().indexOf(domainObject);
        element.scrollTo(newPojoIndex);
        element.getSelectionModel().select(newPojoIndex);
    }

    public void focusItem(ActiveRecord domainObject) {
        int newPojoIndex = element.getItems().indexOf(domainObject);
        element.scrollTo(newPojoIndex);
        element.getSelectionModel().focus(newPojoIndex);
    }

    public boolean haveNewItem() {
        ObservableList<ActiveRecord> items = element.getItems();
        ActiveRecord activeRecord=null;
        if (items != null) {
            if (items.size()>0) {
                activeRecord = items.get(items.size() - 1);
                return ActiveRecord.isNewDomane(activeRecord);
            }
            if(items.size()==0){
                return false;
            }
        }else {
            throw new NullPointerException();
        }
        return false;
    }

    public boolean  isItemListExist() {
        ObservableList<ActiveRecord> items = element.getItems();
        if ( items!=null) {
            return true;
        }
        return false;
    }

    public void setServiceMediator(ServiceMediator serviceMediator) {
        this.serviceMediator = serviceMediator;
    }

    public static final class Builder {
        private Class activeRecordClass;
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
        private ServiceMediator serviceMediator;
        private ColumnWrapper[] columnWrappers;
        private UnitOfWork unitOfWork;
        private ActiveRecord clickedDomain;


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

        public Builder setServiceMediator(ServiceMediator val) {
            serviceMediator = val;
            return this;
        }

        public Builder setColumnWrappers(ColumnWrapper... val) {
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

        public Builder setActiveRecordClass(Class activeRecordClass) {
            this.activeRecordClass = activeRecordClass;
            return this;
        }

        public TableWrapper build() {
            return new TableWrapper(this);
        }
    }
}
