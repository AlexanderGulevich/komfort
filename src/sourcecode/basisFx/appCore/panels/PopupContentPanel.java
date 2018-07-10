package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class PopupContentPanel  extends AbstractPanel{
    public PopupContentPanel(AbstractPanel.PanelBuilder b) {

        build(b);
        init();

    }
    @Override
    public void init() {



        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                .setId(CSSID.popupContentPanel)
                .setCoordinate(panelCoordinate)
                .setHeight(height)
                .setStage(stage)
                .setParent(parent)
                .createAnchorPanelWrapper().getElement();

    }

    @Override
    public void register() {
        Layers.setPopupContentPanel(panel);
    }
}


