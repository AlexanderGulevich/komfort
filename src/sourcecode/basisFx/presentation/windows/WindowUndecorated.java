package basisFx.presentation.windows;

import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowUndecorated extends Window {

    public WindowUndecorated(Stage st,WindowKind implimentation,GuiStructura structura) {
        super(st,implimentation,structura);

        stage.initStyle(StageStyle.TRANSPARENT);
//        implimentation.getTitleName();
        implimentation.initUndecoratedStageButtons();
        SystemRegistry.mainWindow=this;
        stage.show();
    }

    public WindowUndecorated(WindowKind implimentation,GuiStructura structura) {
        super(implimentation,structura);

        stage=new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
//        implimentation.getTitleName();
        SystemRegistry.mainWindow=this;
        implimentation.initUndecoratedStageButtons();
        stage.show();
    }

    protected void createScene() {
        scene= new Scene(root, this.kind.getWidth(), this.kind.getHeight());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }


    @Override
    protected void initRoot() {
        root= AnchorWrapper.newBuilder()
                .setCssid(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(3d, 3d, 3d, 3d))
                .build()
                .getElement();
    }



}

    