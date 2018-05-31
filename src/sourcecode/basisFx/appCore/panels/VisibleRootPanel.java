package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class VisibleRootPanel extends AbstractPanel {


    public VisibleRootPanel(PanelBuilder b) {

        build(b);
        init();

    }

    @Override
    public void init() {
         panel = (AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(parent, 0d, 0d, 0d, 0d)
                .setId(CSSID.VISIBLE_ROOT)
                .setStage(stage)
                .createAnchorPanelWrapper()
                .getElement();

    }

    @Override
    public void register() {
        Layers.setVisibleRoot(panel);
    }
}
