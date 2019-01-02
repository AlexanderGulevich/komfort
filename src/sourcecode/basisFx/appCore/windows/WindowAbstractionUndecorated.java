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

    public WindowAbstractionUndecorated(Stage primaryStage, WindowImpl implimentation, GuiStructura structura) {
        super(primaryStage,implimentation,structura);
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
        this.primaryStage.show();
    }

    public WindowAbstractionUndecorated(WindowImpl implimentation, GuiStructura structura) {
        super(implimentation,structura);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
    public WindowAbstractionUndecorated(WindowImpl implimentation) {
        super(implimentation);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    protected void createScene() {
        scene= new Scene(root, this.windowImpl.getWidth(), this.windowImpl.getHeight());
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }


    @Override
    protected void initRoot() {
        root= AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(3d, 3d, 3d, 3d))
                .setMetaName("Root")
                .build()
                .getElement();
    }



}

    