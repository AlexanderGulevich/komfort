/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.Initiated;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.EventFactory;
import javafx.geometry.Insets;
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
    protected Double width;
    protected Double height;
    protected Insets insects;
    protected EventFactory eventFactory=EventFactory.getInstance();

    
    public abstract void init();
    public abstract void register();
    
    public AnchorPane getPanel() {
        return panel;
    }
    protected void build(PanelBuilder b) {
       this.height=b.height;
       this.width=b.width;
       this.panelCoordinate=b.panelCoordinate;
       this.parent=b.parent;
       this.insects=b.insects;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
    public static class  PanelBuilder {
        
        protected AnchorCoordinate panelCoordinate;
        protected AnchorPane parent;
        protected Double width;
        protected Double height;
        protected Insets insects;
       

        public PanelBuilder setPanelCoordinate(AnchorCoordinate panelCoordinate) {
            this.panelCoordinate = panelCoordinate;
            return this;
        }

        public PanelBuilder setParent(AnchorPane parent) {
            this.parent = parent;
            return this;
        }

        public PanelBuilder setWidth(Double width) {
            this.width = width;
            return this;
        }

        public PanelBuilder setHeight(Double height) {
            this.height = height;
            return this;
        }
        
         public PanelBuilder setPadding(Insets i) {
           
          this.insects=i;
          return this;
          
          
        }

      
      
    
    
        
    }
}
