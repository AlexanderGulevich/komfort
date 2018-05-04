package basisFx.appCore.dataTransfers;

import basisFx.appCore.SubmitElement;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.controls.TablesButtonKind;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;

public   class GridDataTransfer{

    private SubmitElement mark;
    private AnchorPane panel;
    private double width;
    private Coordinate coordinate;
    private DataMapper dataMapper;
    private TableWrapper observer;
    private String title;
    private TablesButtonKind tablesButtonKind;
    private Class domainClass;
    private ColumnWrapper[] columnWrappers;

    public SubmitElement getMark() {
        return mark;
    }

    public void setMark(SubmitElement mark) {
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

    public Class getDomainClass() {
        return domainClass;
    }

    public void setDomainClass(Class domainClass) {
        this.domainClass = domainClass;
    }
}

