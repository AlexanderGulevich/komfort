package basisFx.appCore.fabrics;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
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
