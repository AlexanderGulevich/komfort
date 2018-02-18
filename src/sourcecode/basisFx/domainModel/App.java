package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.dataSource.DbFactory;

import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.windows.WindowFx;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.registry.Layers;
import java.sql.SQLException;
import basisFx.appCore.menu.LeftSideMenuRepresent.namesPanelPalaced;
import basisFx.appCore.windows.WindowUndecorated;
import java.sql.Connection;

/**
 *
 * @author Alek
 */
public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createEmbeded();
        
        Connection connection = Db.getConnection();


        WindowFx.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setKindOfTitle(WindowUndecorated.TITLE_VIEW.IMG)
                .setTitlePanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setTitleNameCoordinate(new AnchorCoordinate(5d, null, null, 70d))
                .setContentLayer(40d,0d,0d,60d)
                .windowShow();
                          
        MenuCreator.create()
                .setParentAnchor(Layers.getVisibleRoot())
                .setCoordinate(new AnchorCoordinate(40d, null, 0d, 0d))
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(MenuRepresent.menuLeftSideFabric(namesPanelPalaced.CONTENT_PANEL))
                .init();

    }
    
}
