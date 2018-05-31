/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.settings.Settings;
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
public class WindowDecorated extends WindowFx{


    public WindowDecorated(double w,double h, Stage primaryStage) {
        this.root=new AnchorPane();
        this.width=w;
        this.height=h;
        this.stage=primaryStage;
        stage.setTitle(WindowsTitlesNames.MAIN_WINDOW_NAME.get());
        this.stage.initStyle(StageStyle.DECORATED);
        initIcon();
    }
    
    void initIcon() {
          stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }

    @Override
    void initControlTopButton() {

    }

    @Override
    public WindowFx windowShow() {
        windowInit();
        scene.setFill( Color.TRANSPARENT);
        stage.show();
        return this;
    }

}
