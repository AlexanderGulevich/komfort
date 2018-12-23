package basisFx.appCore.windows;

import basisFx.appCore.utils.CSSHandler;
import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowAbstractionUndecorated extends WindowAbstraction {

    public WindowAbstractionUndecorated(Stage st, WindowImpl implimentation, GuiStructura structura) {
        super(st,implimentation,structura);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public WindowAbstractionUndecorated(WindowImpl implimentation, GuiStructura structura) {
        super(implimentation,structura);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    protected void createScene() {
        scene= new Scene(root, this.windowImpl.getWidth(), this.windowImpl.getHeight());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }


    @Override
    protected void initRoot() {
        root= AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(3d, 3d, 3d, 3d))
                .build()
                .getElement();
    }



}

    