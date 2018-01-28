/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;


/**
 *
 * @author 62
 */
public class CloseWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setElement(AppNode n) {
        
        this.appNode=n;
        this.but=(Button) n.getElement();
        
        
        but.setOnMouseClicked((event) -> {
            
            run();
        }
        
        ) ;
        
        
    
    
    
    }

    @Override
    public void run() {
        try {
                Thread.sleep(500);
                appNode.getStage().close();
            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

  
    
}
