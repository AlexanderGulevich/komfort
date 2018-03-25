/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.Settings;
import static basisFx.domainModel.settings.Settings.PRELODER_COUNT_LIMIT;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppPreloader extends Preloader {


    private Scene scene;

//    private Label progress;
    private AnchorPane root;
    private Stage stage;
    private AnchorPane visibleRoot;

    public double WIDTH_VISIBLE= Settings.Preloader_WIDTH;
    public double HEIGHT_VISIBLE= Settings.Preloader_HEIGHT ;

    public double WIDTH_TRANSPARENT= Settings.Preloader_WIDTH+5d;
    public double HEIGHT_TRANSPARENT= Settings.Preloader_HEIGHT+5d;

    @Override
    public void init() throws Exception {
      
        Platform.runLater(() -> {
            
        setTransparentRoot();
        setVisibleRoot();     
        
      
        this.scene= new Scene(root,WIDTH_TRANSPARENT,HEIGHT_TRANSPARENT);

        
        scene.setFill( Color.TRANSPARENT);
        
        scene.getStylesheets().add(getClass().getResource(
             "/res/css/windows.css"
      ).toExternalForm());
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stage=primaryStage;
        stage.setScene(scene);
       
      stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
  
          }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {

//        if (info instanceof ProgressNotification) {
//            progress.setText(((ProgressNotification) info).getProgress() + "%");
//        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
  
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                break;
            case BEFORE_INIT:
                break;
            case BEFORE_START:
                stage.hide();
                break;
        }
    }
    
    
        
    public static void coundown(EntryPoint ep)  {
   
        for (int i = 0; i <PRELODER_COUNT_LIMIT; i++) {
            double progress = (100 * i) / PRELODER_COUNT_LIMIT;
            
            LauncherImpl.notifyPreloader(
                    ep, new Preloader.ProgressNotification(progress)
            );
        }
    }
    
     protected void setTransparentRoot(){
                 this.root=(AnchorPane) AppNode.NodeBuilder.create()
                         .setId(CSSID.PRELOADER_TRANSPARENT_ROOT)
                         .setInsects(new Insets(5d, 5d, 5d, 5d))
//                         .setWidth(WIDTH_VISIBLE)
//                         .setHeight(HEIGHT_VISIBLE)
                         .createAnchorPanelWrapper()
                         .getElement();
              
             
     }
     
     protected void setVisibleRoot(){
                 this.visibleRoot=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(root, 0d, 0d, 0d, 0d)
                         .setId(CSSID.PRELOADER_VISIBLE_ROOT)
//                         .setWidth(WIDTH_VISIBLE)
//                         .setHeight(HEIGHT_VISIBLE)
                         .createAnchorPanelWrapper()
                         .getElement();
                 
                 
                
                 
                 
                
     }
    
}
