package basisFx.appCore.grid;

import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;

public   class GridTablesBuilder {

    private KindOfSubmitElement mark;
    private AnchorPane panel;
    private double width;
    private Coordinate coordinate;
    private DataMapper dataMapper;
    private TableWrapper observer;
    private String title;
    private TablesButtonKind tablesButtonKind;
    private Class domainClass;
    private ColumnWrapper[] columnWrappers;
    private KindOfTable kindOfTable;
    private GridColWidth  gridColWidth;

    public GridColWidth getGridColWidth() {
        return gridColWidth;
    }

    public void setGridColWidth(GridColWidth gridColWidth) {
        this.gridColWidth = gridColWidth;
    }

    public KindOfTable getKindOfTable() {
        return kindOfTable;
    }

    public void setKindOfTable(KindOfTable kindOfTable) {
        this.kindOfTable = kindOfTable;
    }

    public KindOfSubmitElement getMark() {
        return mark;
    }

    public void setMark(KindOfSubmitElement mark) {
        this.mark = mark;
    }

    public AnchorPane getPanel() {
        return panel;
    }

    public void setPanel(AnchorPane panel) {
        this.panel = panel;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }

    public void setDataMapper(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    public TableWrapper getObserver() {
        return observer;
    }

    public void setObserver(TableWrapper observer) {
        this.observer = observer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TablesButtonKind getTablesButtonKind() {
        return tablesButtonKind;
    }

    public void setTablesButtonKind(TablesButtonKind tablesButtonKind) {
        this.tablesButtonKind = tablesButtonKind;
    }


    public ColumnWrapper[] getColumnWrappers() {
        return columnWrappers;
    }

    public void setColumnWrappers(ColumnWrapper... columnWrappers) {
        this.columnWrappers = columnWrappers;
    }

    public void setColumn(ColumnWrapper columnWrapper) {
        if (this.columnWrappers == null) {
            this.columnWrappers= new ColumnWrapper[1];
            this.columnWrappers[0]=columnWrapper;
            System.out.println(" this.columnWrapper---"+ this.columnWrappers);
        }else{
            int length=this.columnWrappers.length;
            ColumnWrapper clWrappers[]=new ColumnWrapper[length+1];

            int i;
            for (i = 0; i < length; i++) {

                clWrappers[i]=this.columnWrappers[i];

            }

            clWrappers[i]=columnWrapper;

            this.columnWrappers=clWrappers;



        }

//        this.columnWrapper[this.columnWrapper.length+1]=  columnWrapper;
    }

    public Class getDomainClass() {
        return domainClass;
    }

    public void setDomainClass(Class domainClass) {
        this.domainClass = domainClass;
    }
}

