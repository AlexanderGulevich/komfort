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
        stage=st;
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(kind.getTitleName());
        stage.show();
    }

    @Override
    protected void createScene() {
        scene= new Scene(root, this.kind.getWidth(), this.kind.getHeight());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }

    public WindowAbstractionDecorated(WindowImpl implimentation, GuiStructura structura) {
        super(implimentation,structura);
        stage=new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(kind.getTitleName());
        stage.show();
    }

    @Override
    protected void initRoot() {
        root= AnchorWrapper.newBuilder()
                .setCSSid(CSSID.TRANSPARENT_ROOT)
                .setInsects(new Insets(0d, 0d, 0d, 0d))
                .build().getElement();
    }


}
