package basisFx.appCore.utils;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TaskPanelIcomToPlatform {
    private Stage stage;

    public TaskPanelIcomToPlatform(Stage stage) {
        this.stage = stage;
        init();
    }

    private void init() {
        String path = "file:/" + System.getProperty("user.dir") + "/src/res/res/img/panelIcon.png";
        path=path.replace("\\","/");

        stage.getIcons().add(
                new Image(path));
    }


}
