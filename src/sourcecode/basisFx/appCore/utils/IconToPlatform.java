package basisFx.appCore.utils;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IconToPlatform {

    public static void init(Stage stage) {
        stage.getIcons().add(
                new Image(PathToFile.getPath("/src/res/res/img/panelIcon.png")));
    }

}
