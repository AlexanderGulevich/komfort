/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.MaximazingManager;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.Settings;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public class MaximazingSwither extends AppEvent{
    protected Node  node;
    protected boolean  max=false;

               
    @Override
    public void setElement(AppNode appNode) {
        this.appNode=appNode;
        this.node= appNode.getElement();
        
        node.setOnMouseClicked( (event) -> {

            run();
        }
       
        ) ;
        
        
}

    @Override
    public void run() {
        try {


            Thread.sleep(100);

            Stage stage =appNode.getStage();
            AnchorPane root=(AnchorPane) stage.getScene().getRoot();

//            if (stage.isMaximized()) {
//                if (stage.isFullScreen()) {
            if (max) {

                  max=false;

                  root.setPadding(new Insets(3d, 3d, 3d, 3d));
                    
                    appNode.getStage().setMaximized(false);
                    stage.setWidth(Settings.WIDTH);
                    stage.setHeight(Settings.HEIGHT);
                    
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    stage.setX(
                            (primScreenBounds.getWidth() - stage.getWidth()) / 2);
                    stage.setY(
                            (primScreenBounds.getHeight() - stage.getHeight()) / 2);


                MaximazingManager.notifyObjects();



            } else {

                 max=true;

                 root.setPadding(new Insets(0d, 0d, 0d, 0d));

//                appNode.getStage().setIconified(true);
//                appNode.getStage().setMaximized(true);
//                appNode.getStage().setFullScreen(true);


                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX(primaryScreenBounds.getMinX());
                stage.setY(primaryScreenBounds.getMinY());
                stage.setWidth(primaryScreenBounds.getWidth());
                stage.setHeight(primaryScreenBounds.getHeight());


                MaximazingManager.notifyObjects();

            }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}
