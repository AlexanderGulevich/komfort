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

public  class WindowAbstractionDecorated extends WindowAbstraction {

    public WindowAbstractionDecorated(Stage st, WindowImpl implimentation, GuiStructura structura) {
        super(implimentation,structura);
        primaryStage =st;
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle(windowImpl.getTitleName());
        primaryStage.show();
    }

    @Override
    protected void createScene() {
        scene= new Scene(root, this.windowImpl.getWidth(), this.windowImpl.getHeight());
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }

    public WindowAbstractionDecorated(WindowImpl implimentation, GuiStructura structura) {
        super(implimentation,structura);
        primaryStage =new Stage();
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle(windowImpl.getTitleName());
        primaryStage.show();
    }

    @Override
    protected void initRoot() {
        root= AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(0d, 0d, 0d, 0d))
                .build().getElement();
    }


}
