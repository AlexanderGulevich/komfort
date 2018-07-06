package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowDecorated extends WindowBridgeAbstraction {

    public WindowDecorated(Stage st,WindowBridgeImplimentation implimentation) {
        super(implimentation);
        stage=st;
        stage.initStyle(StageStyle.DECORATED);
        impl.initDecoratedTitle();
        stage.show();
    }

    @Override
    protected void initRoot() {
        root=(AnchorPane)  AppNode.NodeBuilder.create()
                .setId(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(0d, 0d, 0d, 0d))
                .createAnchorPanelWrapper()
                .getElement();
    }


}
