package basisFx;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.presentation.MainMenuSketch;
import javafx.application.Application;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import java.sql.SQLException;


public class App{


    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

//        Application.setUserAgentStylesheet("/res/css/modena/modena.css");

        CSSHandler.init(StylesPathes.CUSTOM_1);

        WindowFabric.WindowUndecoratedFabric();

        SystemRegistry.windowFabric.mainWindow(
                GuiStructuraFabric.leftAndTopMenuUndecorated(), primaryStage
        );

        DbFactory.createEmbeded();

        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());




//      ScenicView.show(MainWindow.getInstance().getWindow().getScene());


    }
    
}
