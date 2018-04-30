package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class PopupButtonPanel extends AbstractPanel {

    public PopupButtonPanel(PanelBuilder b) {

        build(b);
        init();

    }
    @Override
    public void init() {



        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                .setId(CSSID.WindowButtonsPanel)
                .setCoordinate(panelCoordinate)
                .setHeight(height).setWidth(width)
                .setParent(parent)
                .createAnchorPanelWrapper().getElement();

    }

    @Override
    public void register() {
        Layers.setPopupButtonPanel(panel);
    }
}
