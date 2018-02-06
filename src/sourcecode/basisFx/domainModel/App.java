package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.LeftSideMenuRepresent;
import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.windows.WindowFx;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        

        WindowFx.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setTitlePanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setTitleTextCoordinate(new AnchorCoordinate(0d, null, null, 90d))
                .setContentLayer(40d,0d,0d,70d)
                .windowShow();
        
          
        
        new MainMenuView();
        
        
                
                

       
        
        
        
//         //проинициализировал заранее чтобы не возникала NullPointerExeption
//        Stable.getInstance().createDb();
//        Stable.getInstance().setPrimaryStage(primaryStage);
//        Stable.getInstance().createMainMenu();
//        Stable.getInstance().createRoot();
//        Stable.getInstance().createTabPane();
//        Stable.getInstance().createMainTab();
//        
//        
//       
//                
//        
//       
//        
//        new MainBoard();
        
//        primaryStage.close();
//        primaryStage.show();
//        primaryStage.setWidth(300);
//        primaryStage.setHeight(300);
//primaryStage.setOpacity(1);

    
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
   
    
    
}
