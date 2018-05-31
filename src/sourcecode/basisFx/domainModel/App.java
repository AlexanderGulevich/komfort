package basisFx.domainModel;

import basisFx.appCore.fabrics.AppStructuraFabric;
import basisFx.appCore.fabrics.DbFactory;
import basisFx.appCore.fabrics.WindowFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.windows.WindowDecorated;
import basisFx.appCore.windows.WindowFx;
import basisFx.appCore.windows.WindowUndecorated;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{

     WindowFabric windowFabric=new WindowFabric();
     AppStructuraFabric structuraFabric =new AppStructuraFabric();



    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createEmbeded();

        WindowUndecorated window =
                windowFabric.unDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage);

//        WindowDecorated window =
//                windowFabric.decoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage);


        structuraFabric.leftSideIconMenuStructura(window);
//        structuraFabric.tabStructura(primaryStage,window);





//      ScenicView.show(window.getScene());

    }
    
}
