package basisFx.domain;

//import basisFx.appCore.MenuTrigger;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import javafx.stage.Stage;

import java.sql.SQLException;


public class App{
//    protected MenuTrigger menuTrigger =new MenuTrigger();



    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        CSSHandler.init(StylesPathes.CUSTOM_1);

        WindowFabric.WindowUndecoratedFabric();

        SystemRegistry.windowFabric.mainWindow(
                GuiStructuraFabric.leftAndTopMenuUndecorated(), primaryStage
        );

        DbFactory.createEmbeded();

        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());

//        menuTrigger.verticalMenuButtonFire(1);

//      ScenicView.show(window.getScene());


    }
    
}
