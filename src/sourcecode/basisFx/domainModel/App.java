package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;
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
//                .setTextIcon(new AnchorCoordinate(0d, null, null, 0d),FontsStore.MATERIAL_ICONS, 30d,  "")
                .setContentLayer(40d,0d,0d,150d)
                .windowShow();
        
        
        
        MenuCreator.create()
                .setAnchorPane(Layers.getContentLayer())
                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
                .setCss(CSSID.MENUS)
                .setNodes(new MainMenu())
                .setRepresent(MenuRepresent.menuNBarFabric())
                .init();
        
        

       
        
        
        
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
