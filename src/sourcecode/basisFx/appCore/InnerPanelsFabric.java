package basisFx.appCore;

import javafx.scene.layout.AnchorPane;

public class InnerPanelsFabric
{

    public AnchorPane create


    panel=(AnchorPane) AppNode.NodeBuilder.create()
        .setCoordinate(panelCoordinate)
                         .setParent(parent)
                         .setHeight(height)
                         .setWidth(width)
                         .setId(CSSID.MAIN_CONTENT_ANCHOR)
                         .setStage(stage)
                         .createAnchorPanelWrapper()
                         .getElement();





}
