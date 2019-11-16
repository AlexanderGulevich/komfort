package basisFx.appCore.utils;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IconToPlatform {

    public static void init(Stage stage) {
        String path = PathToFile.getFilePath("/src/res/res/img/panelIcon.png");
        Image image = new Image(path);
        stage.getIcons().add(image);
    }

}
