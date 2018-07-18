package basisFx.appCore.appStructura;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class ErrorStructura extends GuiStructura{


    @Override
    public void init() {

//        AppNode.NodeBuilder.create()
//                .setParent(popupContentPanel.getPanel())
//                .setCoordinate( new Coordinate(10d,80d,10d,10d))
//                .setFont(FontsStore.ROBOTO_LIGHT,25d)
//                .setText(message)
//                .setId(CSSID.PopupTextArea)
//                .createTextAreaWrapper();
//
//
//
//        popupTitlePanel = panelFabric.popupTitlePanel(
//                new AbstractPanel.PanelBuilder()
//                        .setHeight(45d)
//                        .setStage(windowUndecorated.getStage())
//                        .setPanelCoordinate(new Coordinate(0d, 0d, null, 0d))
//                        .setParent(Layers.getPopupVisibleRoot())
//
//        );
//
//
//
//        AnchorPane popupTransparentRoot=(AnchorPane) AppNode.NodeBuilder.create()
//                .setId(CSSID.TRANSPARENT_ROOT)
//                .setInsects(new Insets(3d, 3d, 3d, 3d))
//                .createAnchorPanelWrapper()
//                .getElement();
//
//
//        Layers.setPopupTransparentRoot(popupTransparentRoot);
//
//
//
//        AnchorPane visibleRoot
//                = (AnchorPane) AppNode.NodeBuilder.create()
//                .setCoordinate( 0d, 0d, 0d, 0d)
//                .setId(CSSID.TopVisiblePanel)
//                .setParent(Layers.getPopupTransparentRoot())
//                .setStage(windowUndecorated.getStage())
//                .createAnchorPanelWrapper()
//                .getElement();
//
//        Layers.setPopupVisibleRoot(visibleRoot);
//
//
//
//
//
//
//        popupContentPanel = panelFabric.popupContentPanel(
//                new AbstractPanel.PanelBuilder()
//                        .setHeight(45d)
//                        .setStage(windowUndecorated.getStage())
//                        .setPanelCoordinate(new Coordinate(45d, 5d, 5d, 5d))
//                        .setParent(Layers.getPopupVisibleRoot())
//        );
//
//        popupMessageTextPanel =  (AnchorPane) AppNode.NodeBuilder.create()
//                .setId(CSSID.popupMessageTextPanel)
//                .setCoordinate(new Coordinate(10d,40d,10d,10d))
//                .setHeight(height)
//                .setParent(popupContentPanel.getPanel())
//                .createAnchorPanelWrapper().getElement();
//
//        windowUndecorated.setPanel(popupTitlePanel);
//        windowUndecorated.setPanel(popupContentPanel);
//
//        textFabric.createLabel(
//                title,CSSID.PopupTitleText,
//                FontsStore.ROBOTO_BOLD,  Pos.CENTER_LEFT,23d,
//                popupTitlePanel.getPanel(),
//                new Coordinate(10d,0d,null,10d)
//        );
//
//        // icon
//        textFabric.createText(
//                "  \uF06A ", CSSID.ALERT_ICON,
//                FontsStore.FAWESOME5SOLID,50d,
//                popupContentPanel.getPanel(),
//                new Coordinate(10d,-10d,null,null)
//        );
//
//        buttonFactory.popupCloseOkButton(
//                popupContentPanel.getPanel(),
//                new Coordinate(null,15d,10d,null),
//                windowUndecorated.getStage()
//        );
//        windowUndecorated.windowShow();
//
//
//    }
//
//
//








}
}
