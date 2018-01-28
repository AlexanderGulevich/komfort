/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCustomLogic.settings.Settings;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public class MaximazingSwither extends AppEvent{
    protected Node  node;
     
               
               
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
                 AnchorPane p=(AnchorPane) stage.getScene().getRoot();
                
                if (stage.isMaximized()) {
                    
                  p.setPadding(new Insets(3d, 3d, 3d, 3d));
                    
                    appNode.getStage().setMaximized(false);
                    stage.setWidth(Settings.WIDTH);
                    stage.setHeight(Settings.HEIGHT);
                    
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    stage.setX(
                            (primScreenBounds.getWidth() - stage.getWidth()) / 2);
                    stage.setY(
                            (primScreenBounds.getHeight() - stage.getHeight()) / 2);
                    
                    
                    
                
            } else {
                 p.setPadding(new Insets(0d, 0d, 0d, 0d));    
        
                    appNode.getStage().setMaximized(true);
            }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}
