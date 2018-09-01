//package basisFx.appCore.controls;
//
//import basisFx.appCore.KindOfSubmitElement;
//import basisFx.dataSource.DataMapper;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.appCore.elements.GridPaneWrapper;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.fabrics.*;
//import basisFx.appCore.grid.GridColWidth;
//import basisFx.appCore.grid.KindOfTable;
//import basisFx.appCore.grid.TablesButtonKind;
//import basisFx.appCore.utils.Coordinate;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//
//import java.util.ArrayList;
//
//
//public abstract class GridTable {
//
//    protected ColumnFabric columnFabric=new ColumnFabric();
//    protected EditFabric editFabric=new EditFabric();
//    protected EventFactory eventFactory=EventFactory.getInstance();
//    protected ButtonFactory buttonFactory =new ButtonFactory();
//    protected TableFabric tableFabric=new TableFabric();
//    protected TextFabric textFabric=new TextFabric();
//    protected String title;
//    protected Class domainClass;
//    protected TablesButtonKind tablesButtonKind;
//    protected AnchorPane parentAnchorPane;
//    protected double width;
//    protected Coordinate coordinate;
//    protected DataMapper dataMapper;
//    protected GridPaneWrapper gridPaneWrapper;
//    protected ColumnWrapper[] columnWrappers;
//    protected TableWrapper tableWrapper;
//    protected TableView<DomainObject> tableView;
//    protected GridPane gridPane;
//    protected ArrayList<TableWrapper> observers=new ArrayList();
//    protected KindOfTable kindOfTable;
//    protected KindOfSubmitElement kindOfSubmitElement;
//    protected GridColWidth gridColWidth;
//
//    public void setKindOfSubmitElement(KindOfSubmitElement kindOfSubmitElement) {
//        this.kindOfSubmitElement = kindOfSubmitElement;
//    }
//
//    public void setKindOfTable(KindOfTable kindOfTable) {
//        this.kindOfTable = kindOfTable;
//    }
//
//
//    public GridPane getGridPane(){
//
//        return (GridPane) gridPaneWrapper.getElement();
//
//    }
//
//    public GridColWidth getGridColWidth() {
//        return gridColWidth;
//    }
//
//    public void setGridColWidth(GridColWidth gridColWidth) {
//        this.gridColWidth = gridColWidth;
//    }
//
//    public abstract void init();
//
//    public void setObserver(TableWrapper observer){
//        observer.markAsObserver(true);
//        observers.add(observer);
//
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDomainClass(Class domainClass) {
//        this.domainClass = domainClass;
//    }
//
//    public void setTablesButtonKind(TablesButtonKind tablesButtonKind) {
//        this.tablesButtonKind = tablesButtonKind;
//    }
//
//    public void setParentAchorPane(AnchorPane panel) {
//        this.parentAnchorPane = panel;
//    }
//
//    public void setWidth(double width) {
//        this.width = width;
//    }
//
//    public void setCoordinate(Coordinate coordinate) {
//        this.coordinate = coordinate;
//    }
//
//    public void setDataMapper(DataMapper dataMapper) {
//        this.dataMapper = dataMapper;
//    }
//
//    public void setColumnWrappers(ColumnWrapper... columnWrappers) {
//        this.columnWrappers = columnWrappers;
//    }
//
//    public GridPaneWrapper getGridPaneWrapper() {
//        return gridPaneWrapper;
//    }
//
//    public void setColumnPercentWidth(int c,double w){
//
//    }
//
//    public ArrayList<TableWrapper> getObservers() {
//        return observers;
//    }
//
//    public TableView<DomainObject> getTableView() {
//        return tableView;
//    }
//
//    public TableWrapper getTableWrapper() {
//        return tableWrapper;
//    }
//}
