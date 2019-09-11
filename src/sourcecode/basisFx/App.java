package basisFx;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.*;
import basisFx.appCore.windows.ButtonsForStageThreeEntity;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.appCore.guiStructura.LeftAndTopMenuGUI;
import basisFx.appCore.windows.WindowFabric;
import basisFx.dataSource.DbFactory;
import javafx.stage.Stage;
//import org.scenicview.ScenicView;



public class App{

    public App(Stage primaryStage)  {

        IconToPlatform.init(primaryStage);
        CSSHandler.init(StylesPathes.CUSTOM_1);
        WindowFabric.WindowUndecorated();
        FontHandler.getInstanse().loadFontToScene();


//        PropertiesUtils.setProperty("db_path","C:/komfdb/");
//        PropertiesUtils.setProperty("db_name","komdb");

        PropertiesUtils.run();
        PropertiesUtils.setProperty("db_name","price_db_OMTS");
        PropertiesUtils.setProperty("db_folder","OMTS");
        DbFactory.createDbServer(new DbSchemaPrice());

        Registry.windowFabric.mainWindow(primaryStage,
                WindowBuilder.newBuilder()
//                        .setButtonsForStage(new ButtonsForStageThreeEntity(LeftAndTopMenuGUI.Structura.titleAnchor.name()))
                        .setFxmlFileName("Main_v2")
                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                        .setWidth(1250d)
                        .setHeight(Settings.HEIGHT)
                        .setPanelCreator(null)
                        .setTitle(Settings.TITLE)
                        .setMessage(null)
                        .build()
                );








        MenuFabric.menuLeft( new MainMenuSketch());

//        ScenicView.show(Registry.mainWindow.getScene());



    }


}


