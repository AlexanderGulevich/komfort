package basisFx;

import basisFx.appCore.guiStructura.LeftAndTopMenuGUI;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.*;
import basisFx.appCore.windows.ButtonsForStageThreeEntity;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.appCore.windows.WindowFabric;
import basisFx.dataSource.DbFactory;
import basisFx.domain.price.Price;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//import org.scenicview.ScenicView;



public class App{

    public App(Stage primaryStage)  {

        Map<String,Double> map=new HashMap<>();

        Set<Map.Entry<String, Double>> entries = map.entrySet();


        IconToPlatform.init(primaryStage);
        CSSHandler.init(StylesPathes.CUSTOM_1);
        WindowFabric.WindowUndecorated();
        FontHandler.getInstanse().loadFontToScene();

//        PropertiesUtils.setProperty("db_path","C:/komfdb/");
//        PropertiesUtils.setProperty("db_name","komdb");

        PropertiesUtils.run();
        PropertiesUtils.setProperty("db_name","komfortdb");
        PropertiesUtils.setProperty("db_folder","komfortdb");
        DbFactory.createDbServerHsql(new DbSchemaPrice());

        Registry.windowFabric.mainWindow(primaryStage,
                WindowBuilder.newBuilder()
                        .setButtonsForStage(new ButtonsForStageThreeEntity(LeftAndTopMenuGUI.Structura.titleAnchor.name()))
                        .setFxmlFileName("Main_v1")
                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                        .setWidth(Settings.WIDTH).setHeight(Settings.HEIGHT)
                        .setPanelCreator(null)
                        .setTitle("KOMFORT")
                        .setMessage(null)
                        .build()
        );




        MenuFabric.menuLeftAndTop( new MainMenuSketch());

//        ScenicView.show(Registry.mainWindow.getScene());



    }


}


