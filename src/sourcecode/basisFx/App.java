package basisFx;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.IconToPlatform;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.ButtonsForStageThreeEntity;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.presentation.MainMenuSketch;
import basisFx.presentation.appStructura.LeftAndTopMenuGUI;
import javafx.stage.Stage;

import java.sql.SQLException;


public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        IconToPlatform.init(primaryStage);
        CSSHandler.init(StylesPathes.CUSTOM_1);
        WindowFabric.WindowUndecorated();

        Registry.windowFabric.mainWindow(primaryStage,
                WindowBuilder.newBuilder()
                        .setButtonsForStage(new ButtonsForStageThreeEntity(
                                LeftAndTopMenuGUI.Structura.titleAnchor.name()
                        ))
                        .setFxmlFileName(null)
                        .setGUIStructura(new LeftAndTopMenuGUI())
                        .setHeight(Settings.HEIGHT)
                        .setWidth(Settings.WIDTH)
                        .setParentAnchorNameForFXML(null)
                        .setTargetCreater(null)
                        .setTitle(Settings.TITLE)
                        .build()
                );
        DbFactory.createDbServer();
        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());

//        ScenicView.show(WindowImplMain.getInstance().getWindowAbstraction().getScene());


//        Registry.windowFabric.customSubWindow(
//                WindowBuilder.newBuilder()
//                        .setFxmlFileName("q")
//                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                        .setHeight(400d)
//                        .setWidth(800d)
//                        .setTitle("111111111")
//                        .build()
//        );
//        Registry.windowFabric.infoWindow(  "FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  FFFFFFFFFFFFFFFFFF  ");


    }
    
}
