/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSID;

import static basisFx.appCore.settings.Settings.PRELODER_COUNT_LIMIT;

import basisFx.appCore.utils.Coordinate;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppPreloader extends Preloader {


    private Scene scene;

//    private Label progress;
    private AnchorPane root;
    private Stage stage;
    private AnchorPane visibleRoot;

    public double WIDTH_VISIBLE=600d;
    public double HEIGHT_VISIBLE= 400d ;

    public double WIDTH_TRANSPARENT= WIDTH_VISIBLE+5d;
    public double HEIGHT_TRANSPARENT= HEIGHT_VISIBLE+5d;

    @Override
    public void init() throws Exception {
      
        Platform.runLater(() -> {

        setTransparentRoot();
        setVisibleRoot();


        this.scene= new Scene(root,WIDTH_TRANSPARENT,HEIGHT_TRANSPARENT);


        scene.setFill( Color.TRANSPARENT);

                    Path path = null;
                    try {
                        path = Paths.get("src", "res","res", "css", "custom_1", "windows.css").toRealPath();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    String stringPaths=null;
            try {
                 stringPaths = path.toUri().toURL().toExternalForm();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


                    String stringPaths2 = System.getProperty("user.dir") + File.separator + "src\\res\\res\\css\\custom_1\\windows.css";
                    //todo стили
        scene.getStylesheets().add(
                stringPaths2
        );
//                    scene.setUserAgentStylesheet(
//                "src/res/res/css/custom_1/windows.css"
//        );

            }
        );



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
                 this.root=AnchorWrapper.newBuilder()
                         .setCSSid(CSSID.PRELOADER_TRANSPARENT_ROOT)
                         .setInsects(new Insets(5d, 5d, 5d, 5d))
                         .build().getElement();
              
             
     }
     
     protected void setVisibleRoot(){
                 this.visibleRoot=AnchorWrapper.newBuilder()
                         .setParentAnchor(root)
                         .setCSSid(CSSID.PRELOADER_VISIBLE_ROOT)
                         .setCoordinate( new Coordinate(0d, 0d, 0d, 0d))
                         .build().getElement();
                 
                 
                
                 
                 
                
     }

}
