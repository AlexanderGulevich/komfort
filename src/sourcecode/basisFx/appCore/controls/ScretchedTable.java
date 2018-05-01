package basisFx.appCore.controls;

import basisFx.appCore.TargetStackLogic;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.DataMapperFabric;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public abstract class ScretchedTable {

    protected PanelFabric panelFabric=new PanelFabric();
    protected ColumnFabric columnFabric=new ColumnFabric();
    protected DataMapperFabric dataMapperFabric =new DataMapperFabric();
    protected EditFabric editFabric=new EditFabric();
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected TargetStackLogic targetStack=TargetStackLogic.getInstance();
    protected ButtonFactory buttonFactory =new ButtonFactory();
    protected TableFabric tableFabric=new TableFabric();
    protected InnerPanelsFabric innerPanelsFabric=new InnerPanelsFabric();
    protected TextFabric textFabric=new TextFabric();
    protected VidgetFactory vidgetFactory=new VidgetFactory();
    protected String title;
    protected Class domainClass;
    protected TablesButtonKind tablesButtonKind;
    protected AnchorPane parentAnchorPane;
    protected GridPane parentGridPane;
    protected double width;
    protected Coordinate coordinate;
    protected DataMapper dataMapper;
    protected GridPaneWrapper gridPaneWrapper;
//    protected ArrayList <ColumnWrapper> columnWrappers;
protected ColumnWrapper[] columnWrappers;

    public abstract void init();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDomainClass(Class domainClass) {
        this.domainClass = domainClass;
    }

    public void setTablesButtonKind(TablesButtonKind tablesButtonKind) {
        this.tablesButtonKind = tablesButtonKind;
    }

    public void setPanel(AnchorPane panel) {
        this.parentAnchorPane = panel;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDataMapper(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    public void setColumnWrappers(ColumnWrapper... columnWrappers) {
        this.columnWrappers = columnWrappers;
    }

    public GridPaneWrapper getGridPaneWrapper() {
        return gridPaneWrapper;
    }
}
