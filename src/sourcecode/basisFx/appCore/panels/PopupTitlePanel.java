package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class PopupTitlePanel extends AbstractPanel{
    public PopupTitlePanel(AbstractPanel.PanelBuilder b) {

        build(b);
        init();

    }
    @Override
    public void init() {



        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                .setId(CSSID.popupTitlePanel)
                .setCoordinate(panelCoordinate)
                .setHeight(height)
                .setStage(stage)
                .setEvent(eventFactory.stageDragging())
                .setParent(parent)
                .createAnchorPanelWrapper().getElement();

    }

    @Override
    public void register() {
        Layers.setPopupTitlePunel(panel);
    }
}

