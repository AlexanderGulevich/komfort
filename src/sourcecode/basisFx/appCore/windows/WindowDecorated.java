/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.settings.WindowsTitlesNames;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 62
 */
public class WindowDecorated extends WindowBridgeAbstraction {

    public WindowDecorated(Stage stage,WindowBridgeImplimentation implimentation) {
        super(implimentation);
        this.stage=stage;
        //todo получать из имплимент
        this.stage.setTitle(WindowsTitlesNames.MAIN_WINDOW_NAME.get());
        this.stage.initStyle(StageStyle.DECORATED);
    }

    @Override
    public void windowShow() {
        initIcon();
        scene.setFill( Color.TRANSPARENT);
        stage.show();
    }

    void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }


}
