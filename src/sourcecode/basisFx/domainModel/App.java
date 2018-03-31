package basisFx.domainModel;

import basisFx.appCore.appStructura.AppStructuraFabric;
import basisFx.appCore.utils.AnchorCoordinate;
import basisFx.appCore.MenuTrigger;
import basisFx.appCore.dataSource.DbFactory;
import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.registry.Layers;
import java.sql.SQLException;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.panels.PanelFabric;
import basisFx.appCore.windows.TitleFabric;
import basisFx.appCore.windows.WindowFabric;

/**
 *
 * @author Alek
 */
public class App{

    AppStructuraFabric appStructuraFabric=new AppStructuraFabric();

    

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createDbServer();

        appStructuraFabric.createLeftSideIconMenuStructura(primaryStage);
        

       

    }
    
}
