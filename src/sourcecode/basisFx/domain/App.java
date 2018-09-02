package basisFx.domain;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.presentation.windows.MainWindow;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import java.sql.SQLException;


public class App{


    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        CSSHandler.init(StylesPathes.CUSTOM_1);

        WindowFabric.WindowUndecoratedFabric();

        SystemRegistry.windowFabric.mainWindow(
                GuiStructuraFabric.leftAndTopMenuUndecorated(), primaryStage
        );

        DbFactory.createEmbeded();

        MenuFabric.createMenuLeftSideRepresentation( new MainMenuSketch());

      ScenicView.show(MainWindow.getInstance().getWindow().getScene());


    }
    
}
