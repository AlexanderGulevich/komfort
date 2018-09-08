package basisFx.presentation.targets;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.DataMapperFabric;
import basisFx.appCore.windows.MainWindow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public abstract class DynamicElements {


    protected AnchorPane innerAnchorPane;
    protected AnchorPane targetAnchorPane;
//    protected ColumnFabric columnFabric=new ColumnFabric();
//    protected DataMapperFabric dataMapperFabric =new DataMapperFabric();
//    protected EditFabric editFabric=new EditFabric();
//    protected ButtonFactory buttonFactory =new ButtonFactory();
//    protected TableFabric tableFabric=new TableFabric();
//    protected TextFabric textFabric=new TextFabric();
//    protected VidgetFactory vidgetFactory=new VidgetFactory();
    protected GridPaneWrapper gridPaneWrapper;
//    protected GridFabric gridFabric=new GridFabric();
    protected GridPane commonGridPane;
//    protected ChartFabric chartFabric=new ChartFabric();


    public DynamicElements() {
        createPanel();
    }

    protected abstract void init();

    public AnchorPane getTargetElement() {
       return  this.targetAnchorPane;
    }

    protected void createPanel(){

        targetAnchorPane = AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TARGET_PANEL)
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setParentAnchor(MainWindow.getInstance().getWindow().getTopVisibleAnchor())
                .build().getElement();

        innerAnchorPane= AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, 10d, 10d, 10d))
                .setParentAnchor(targetAnchorPane)
                .build().getElement();

        gridPaneWrapper = AppNode.NodeBuilder.create()
                .setParent(panel)
                .setCoordinate(new Coordinate(0d,0d,0d,0d))
                .createGridPaneWrapper();

        commonGridPane = (GridPane) gridPaneWrapper.getElement();
    }








}
