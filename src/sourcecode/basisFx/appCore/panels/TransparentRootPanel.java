package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class TransparentRootPanel extends AbstractPanel {

    public TransparentRootPanel(AbstractPanel.PanelBuilder b) {
        build(b);
    }

    @Override
    public void init() {
        panel=(AnchorPane)  AppNode.NodeBuilder.create()
                .setId(CSSID.TRANSPARENT_ROOT)
                .setInsects(insects)
                .createAnchorPanelWrapper()
                .getElement();

    }

    @Override
    public void register() {
        Layers.setTransparentRoot(panel);
    }

}
