package basisFx;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.Registry;
import basisFx.presentation.MainMenuSketch;
import basisFx.presentation.appStructura.InfoWindowStructura;
import javafx.stage.Stage;

import java.sql.SQLException;


public class App{


    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        CSSHandler.init(StylesPathes.CUSTOM_1);

        WindowFabric.WindowUndecoratedFabric();

        Registry.windowFabric.mainWindow(
                GuiStructuraFabric.leftAndTopMenuUndecorated(), primaryStage
        );

        DbFactory.createDbServer();
//        DbFactory.createEmbeded();

        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());


//      ScenicView.show(WindowImplMain.getInstance().getWindowAbstraction().getScene());


        Registry.windowFabric.infoWindow(
                new InfoWindowStructura()
        );
    }
    
}
