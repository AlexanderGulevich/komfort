package basisFx.domainModel;

import basisFx.appCore.MenuTrigger;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.WindowUndecorated;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{
    private final String mainWindowTitleName="KOMFORT";
    private WindowFabric windowFabric = SystemRegistry.windowFabric;
    private WindowImplimentationFabric implimentationFabric=WindowImplimentationFabric.getInstance();
    protected MenuTrigger menuTrigger =new MenuTrigger();
    protected MenuFabric menuFabric  =new MenuFabric();
    protected GuiStructuraFabric structura =new GuiStructuraFabric();
    protected MenuCreator menuCreator=new MenuCreator();

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        DecorationAbstractFabric.createSystemUndecorated();

        windowFabric.createWindow(primaryStage,
                implimentationFabric.mainWindow(structura.guiStructura()));

        DbFactory.createEmbeded();

        CSSHandler.init(StylesPathes.CUSTOM_1);



        WindowUndecorated window = this.windowFabric.unDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage);
//        WindowDecorated window =windowFabric.decoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage);


        structuraFabric.leftSideIconMenuStructura(window);
////        structuraFabric.tabStructura(window);


        menuCreator.setMenuSketch(new MainMenuSketch())
                .setRepresent(menuFabric.createMenuLeftSideRepresentation())
//                .setRepresent(menuFabric.menuBar())
                .init();

//        menuTrigger.verticalMenuButtonFire(1);


//      ScenicView.show(window.getScene());


    }
    
}
