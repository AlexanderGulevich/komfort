/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.Initiated;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public abstract class AbstractPanel implements Initiated{
    
    protected AnchorCoordinate panelCoordinate;
    protected AnchorPane parent;
    protected Stage stage;
    protected AnchorPane panel;

 
    public abstract void init();
    public abstract void register();
    
    public AnchorPane getPanel() {
        return panel;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
    public static class  PanelBuilder {
        
        protected AnchorCoordinate panelCoordinate;
        protected AnchorPane parent;
       

        public PanelBuilder setPanelCoordinate(AnchorCoordinate panelCoordinate) {
            this.panelCoordinate = panelCoordinate;
            return this;
        }

        public PanelBuilder setParent(AnchorPane parent) {
            this.parent = parent;
            return this;
        }

      
      
    
    
        
    }
}
