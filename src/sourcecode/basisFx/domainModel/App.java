package basisFx.domainModel;

import basisFx.appCore.MenuTrigger;
import basisFx.appCore.fabrics.AppStructuraFabric;
import basisFx.appCore.fabrics.DbFactory;
import basisFx.appCore.fabrics.WindowFabric;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
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
    protected WindowFabric windowFabric=new WindowFabric();
    protected AppStructuraFabric structuraFabric =new AppStructuraFabric();
    protected MenuCreator menuCreator=new MenuCreator();

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {

        DbFactory.createEmbeded();

        CSSHandler.init(StylesPathes.CUSTOM_1);



        WindowUndecorated window =windowFabric.unDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage);
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
