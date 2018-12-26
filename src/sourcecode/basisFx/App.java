package basisFx;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.Registry;
import basisFx.presentation.MainMenuSketch;
import basisFx.presentation.appStructura.LeftAndTopMenuGuiStructura;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import java.sql.SQLException;


public class App{


    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        CSSHandler.init(StylesPathes.CUSTOM_1);
        WindowFabric.WindowUndecoratedFabric();
        Registry.windowFabric.mainWindow(new LeftAndTopMenuGuiStructura(), primaryStage);
        DbFactory.createDbServer();
        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());
//      ScenicView.show(WindowImplMain.getInstance().getWindowAbstraction().getScene());





    }
    
}
