package basisFx.domainModel;

import basisFx.appCore.MenuTrigger;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.Window;
import basisFx.appCore.windows.WindowUndecorated;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{
    protected MenuTrigger menuTrigger =new MenuTrigger();
    protected MenuFabric menuFabric  =new MenuFabric();
    protected GuiStructuraFabric structura =new GuiStructuraFabric();
    protected MenuCreator menuCreator=new MenuCreator();

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        SystemRegistry.windowFabric=WindowFabric.WindowUndecoratedFabric();
        SystemRegistry.windowFabric.mainWindow(structura.leftAndTopMenuUndecorated(), primaryStage);
        DbFactory.createEmbeded();
        CSSHandler.init(StylesPathes.CUSTOM_1);

        menuCreator.setMenuSketch(new MainMenuSketch())
                .setRepresent(menuFabric.createMenuLeftSideRepresentation())
                .init();

//        menuTrigger.verticalMenuButtonFire(1);

//      ScenicView.show(window.getScene());


    }
    
}
