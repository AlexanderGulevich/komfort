package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowUndecorated extends WindowAbstraction {

    public WindowUndecorated(Stage st,WindowImplimentation implimentation) {
        super(implimentation);

        stage=st;
        stage.initStyle(StageStyle.UNDECORATED);
//        implimentation.getTitleName();
        implimentation.initUndecoratedStageButtons();
        stage.show();
    }

    @Override
    protected void initRoot() {
        root=(AnchorPane)  AppNode.NodeBuilder.create()
                .setId(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(3d, 3d, 3d, 3d))
                .createAnchorPanelWrapper()
                .getElement();
    }



}

    