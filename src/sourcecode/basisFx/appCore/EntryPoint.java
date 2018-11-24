package basisFx.appCore;
        

import basisFx.appCore.utils.TaskPanelIcomToPlatform;
import com.sun.javafx.application.LauncherImpl;
import basisFx.App;
import javafx.application.Application;
import javafx.stage.Stage;


public class EntryPoint extends Application  {
    
    

    public static void main(String[] args) {
        LauncherImpl.launchApplication(EntryPoint.class, AppPreloader.class, args);
    }

     @Override
    public void init() throws Exception {
        new PathesResearch();
        AppPreloader.coundown(this);

    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        new TaskPanelIcomToPlatform(primaryStage);
        new App(primaryStage);
        

   }
    
  
    
}
