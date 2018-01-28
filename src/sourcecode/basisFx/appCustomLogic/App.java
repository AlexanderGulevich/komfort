package basisFx.appCustomLogic;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCustomLogic.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.WindowFx;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.registry.LayersRegistry;
import basisFx.appCustomLogic.settings.CSSID;
import basisFx.appCustomLogic.settings.FontsStore;
import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        

        WindowFx.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .createMainMenu(
                        CSSID.MENUS, 
                        LayersRegistry.getContentLayer(),
                        new AnchorCoordinate(0d, 0d, null, 0d),
                        MenuRepresent.menuNBarFabric()
                )
                .setTextIcon(
                        new AnchorCoordinate(0d, null, null, 0d),
                        FontsStore.MATERIAL_ICONS, 
                        30d, 
                        ""
                )
                .setContentLayer(45d,0d,0d,0d)
                .windowShow();
        
        
        
       
               
       
        
        
        
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
