package basisFx.appCore.windows;

import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.settings.WindowsTitlesNames;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowDecorated extends WindowBridgeAbstraction {
    /**
     *
     */
    public WindowDecorated(Stage stage,WindowBridgeImplimentation implimentation) {
        super(implimentation);
        this.stage=stage;
        this.stage.setTitle(WindowsTitlesNames.MAIN_WINDOW_NAME.get());
        this.stage.initStyle(StageStyle.DECORATED);
    }

    @Override
    public void windowShow() {
        impl.initStageButtons();
        impl.initIcon();
        impl.initTitle();
        scene.setFill( Color.TRANSPARENT);
        stage.show();
    }

    void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }


}
