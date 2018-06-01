package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

public class IconAnchorPanel extends AbstractPanel{


    public IconAnchorPanel(AbstractPanel.PanelBuilder b) {

        build(b);




    }


    @Override
    public void init() {
        panel=(AnchorPane)  AppNode.NodeBuilder.create()
                .setCoordinate(panelCoordinate)
                .setParent(parent)
                .setId(CSSID.IMG_ICON)
                .createAnchorPanelWrapper()
                .getElement();



    }

    @Override
    public void register() {
        Layers.setIconAnchorPanel(panel);
    }


}
