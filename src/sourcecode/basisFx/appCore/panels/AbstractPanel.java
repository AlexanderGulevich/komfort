/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.interfaces.Initiated;
import basisFx.appCore.fabrics.EventFactory;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public abstract class AbstractPanel implements Initiated{
    
    protected Coordinate panelCoordinate;
    protected AnchorPane parent;
    protected Stage stage;
    protected AnchorPane panel;
    protected Double width;
    protected Double height;
    protected Insets insects;
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected FontsStore font;
    protected double fontSize;


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
       this.font=b.font;
       this.fontSize=b.fontSize;
       this.stage=b.stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
    public static class  PanelBuilder {
        
        protected Coordinate panelCoordinate;
        protected AnchorPane parent;
        protected Double width;
        protected Double height;
        protected Insets insects;
        protected FontsStore font;
        protected double fontSize;
        protected Stage stage;

        public PanelBuilder setStage(Stage stage) {
            this.stage = stage;
            return this;
        }

        public PanelBuilder setFont(FontsStore font, double size) {
            this.font = font;
            this.fontSize=size;
            return this;
        }

        public PanelBuilder setPanelCoordinate(Coordinate panelCoordinate) {
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
