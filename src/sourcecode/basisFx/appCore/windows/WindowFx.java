package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.StylesLoader;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.domainModel.settings.CSSID;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author 62
 */
public abstract class WindowFx {
    
    protected String id;
    protected double width;
    protected double height;
    protected double top;
    protected double right;
    protected double bottom;
    protected double left;
    protected  Stage stage;
    protected  Scene scene;
    protected  AnchorPane root;
    protected AnchorPane visibleRoot;
    protected AnchorPane contentLauer;
    protected Boolean iconIneded;
    protected AnchorPane titlePanel;
    protected AnchorCoordinate titlePanelCoordinate;
    protected AnchorCoordinate titleNameCoordinate;
 
    abstract void initIcon();
    abstract void initTitle();
    abstract void initControlTopButton();
    
        
    protected void windowInit(){
        
      this.scene= new Scene(root,width,height);

      stage.setScene(scene);

      StylesLoader.loadAll(scene);
      
      scene.setFill( Color.TRANSPARENT);
      stage.initStyle(StageStyle.TRANSPARENT);

    }

    public WindowFx getWindow(){
     return this;
    }
     public WindowFx windowShow(){
         setTitlePanel();
         windowInit();
         initTitle();
         initControlTopButton();
         stage.show();
         return this;
         
     }
     
    
     public void windowClose(){
         stage.close();
     }

     protected void setTransparentRoot(){
                 this.root=(AnchorPane) AppNode.NodeBuilder.create()
                         .setId(CSSID.TRANSPARENT_ROOT)
                         .setStage(stage)
                         .setInsects(new Insets(3d, 3d, 3d, 3d))
                         .createNpAnchor()
                         .getElement();
                 
                Layers.setTransparentRoot(root);
     }
     
     protected void setVisibleRoot(){
                 this.visibleRoot=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(root, 0d, 0d, 0d, 0d)
                         .setId(CSSID.VISIBLE_ROOT)
                         .setStage(stage)
//                         .setDropShadow(new DropShadow())
                         .createNpAnchor()
                         .getElement();
                 
                 Layers.setVisibleRoot(visibleRoot);
     }
     
     protected void setTitlePanel(){
                 this.titlePanel=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(this.titlePanelCoordinate)
                         .setParent(visibleRoot)
                         .setId(CSSID.TITLE_PANEL)
                         .setStage(stage)
//                         .setEvent(AppEvent.createMaximazingSwitcher())
                         .setEvent(AppEvent.createStageDragging())
                         .createNpAnchor()
                         .getElement();
                 
     Layers.setTitlePanel(titlePanel);

     }
     
      public WindowFx setTitlePanelCoordinate(AnchorCoordinate c){
          this.titlePanelCoordinate=c;
          return this;
      }
     
      public WindowFx setTitleNameCoordinate(AnchorCoordinate c){
          this.titleNameCoordinate=c;
          return this;
      }
     
     
     public abstract WindowFx setContentLayer(double t,double r,double b,double l);
        
}
