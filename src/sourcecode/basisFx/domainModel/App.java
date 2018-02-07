package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;

import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.windows.WindowFx;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.registry.Layers;
import java.sql.SQLException;
import basisFx.appCore.menu.LeftSideMenuRepresent.namesPanelPalaced;
import basisFx.appCore.windows.WindowUndecorated;

/**
 *
 * @author Alek
 */
public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        

        WindowFx.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setKindOfTitle(WindowUndecorated.TITLE_VIEW.IMG)
                .setTitlePanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setTitleNameCoordinate(new AnchorCoordinate(5d, null, null, 90d))
                .setContentLayer(40d,0d,0d,70d)
                .windowShow();
        
          //        
//        MenuCreator.create()
//                .setParentAnchor(Layers.getContentLayer())
//                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
//                .setCss(CSSID.MENUS)
//                .setNodes(new MainMenu())
//                .setRepresent(MenuRepresent.menuNBarFabric())
//                .init();
  
             MenuCreator.create()
                .setParentAnchor(Layers.getVisibleRoot())
                .setCoordinate(new AnchorCoordinate(40d, null, 0d, 0.5d))
                .setWidth(70d)
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(MenuRepresent.menuLeftSideFabric(namesPanelPalaced.CONTENT_PANEL))
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
