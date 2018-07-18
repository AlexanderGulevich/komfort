package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowDecorated extends Window {

    public WindowDecorated(Stage st,WindowKind implimentation) {
        super(implimentation);
        stage=st;
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(kind.getTitleName());
        stage.show();
    }
    public WindowDecorated(WindowKind implimentation) {
        super(implimentation);
        stage=new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(kind.getTitleName());
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
