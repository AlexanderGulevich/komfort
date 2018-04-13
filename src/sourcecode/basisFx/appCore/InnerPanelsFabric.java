package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;
//
public class InnerPanelsFabric
{

    public AnchorPane createInnerPanels(AnchorPane panel, double widthPerCent, Coordinate coordinate) {

        return (AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(coordinate)
                .setParent(panel)
                .setWidthPerCent(widthPerCent)
                .setId(CSSID.INNER_PANE)
                .createAnchorPanelWrapper()
                .getElement();

    }



}
