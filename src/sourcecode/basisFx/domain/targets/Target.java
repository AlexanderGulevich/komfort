/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domain.targets;

import basisFx.appCore.*;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.DataMapperFabric;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alek
 */
public abstract class Target {


//    protected AnchorPane panel;
//    protected ColumnFabric columnFabric=new ColumnFabric();
//    protected DataMapperFabric dataMapperFabric =new DataMapperFabric();
//    protected EditFabric editFabric=new EditFabric();
//    protected EventFactory eventFactory=EventFactory.getInstance();
//    protected TargetStackLogic targetStack=TargetStackLogic.getInstance();
//    protected ButtonFactory buttonFactory =new ButtonFactory();
//    protected TableFabric tableFabric=new TableFabric();
//    protected TextFabric textFabric=new TextFabric();
//    protected VidgetFactory vidgetFactory=new VidgetFactory();
//    protected GridPaneWrapper gridPaneWrapper;
//    protected GridFabric gridFabric=new GridFabric();
//    protected GridPane commonGridPane;
//    protected ChartFabric chartFabric=new ChartFabric();

//
//    protected abstract void configurate();
//
//    public AnchorPane getTargetElement() {
//       return  this.panel;
//    }


//    public void init() {
//
//        targetStackLogic();
//        createPanel();
//        configurate();
//
//
//    }
//
//    protected void targetStackLogic(){
//
//         targetStack.handle(this);
//
//    }

    protected void createPanel(){
//
//        (AnchorPane) AppNode.NodeBuilder.create()
//                .setId(CSSID.TARGET_PANEL)
//                .setCoordinate(panelCoordinate)
//                .setParent(parent)
//                .createAnchorPanelWrapper().getElement();

//        ScrollPane scrollPane = (ScrollPane) AppNode.NodeBuilder.create()
//                .setParent(Layers.getContentLayer())
//                .setCoordinate(panelCoordinate)
//                .createScrollPaneWrapper().getElement();

//         panel=panelFabric.innerContentPanel(
//            new AbstractPanel.PanelBuilder()
//                    .setParent(Layers.getContentLayer())
//                    .setPanelCoordinate(new Coordinate(10d, 10d, 10d, 10d)))
//                .getPanel();
    }

//    protected void createGridBasedPanel(){
//        gridPaneWrapper = AppNode.NodeBuilder.create()
//                .setParent(panel)
//                .setCoordinate(new Coordinate(0d,0d,0d,0d))
//                .createGridPaneWrapper();
//
//         commonGridPane = (GridPane) gridPaneWrapper.getElement();
//
//
//    }







}
