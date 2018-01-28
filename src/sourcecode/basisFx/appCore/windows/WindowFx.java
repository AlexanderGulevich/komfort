package basisFx.appCore.windows;

import basisFx.appCore.StylesLoader;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.menu.MenuCreator;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.Styles;
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
    protected AnchorPane innerRoot;
    protected AnchorPane contentLauer;
    protected Boolean iconIneded;
////    protected String titleName;
 
    
    
//    public abstract WindowFx setTitleName(String str);
    abstract void initIcon();
    abstract void initTitle();
    abstract void initControlTopButton();
    
        
    protected void windowInit(){
        
      this.scene= new Scene(root,width,height);

      stage.setScene(scene);

      StylesLoader.load(scene, Styles.MAIN);
      StylesLoader.load(scene, Styles.BUTTONS);
      StylesLoader.load(scene, Styles.PANES);
      StylesLoader.load(scene, Styles.TABLES);
      StylesLoader.load(scene, Styles.MENUS);
      StylesLoader.load(scene, Styles.WINDOWS);
      StylesLoader.load(scene, Styles.MENU_BAR);
      scene.setFill( Color.TRANSPARENT);
      stage.initStyle(StageStyle.TRANSPARENT);

    }

    
     public void windowShow(){
         windowInit();
         initTitle();
         initControlTopButton();
         stage.show();
         
     }
     
    
     public void windowClose(){
         stage.close();
     }
     
     
     
     protected void createTransparentRoot(){
                 this.root=(AnchorPane) AppNode.NodeBuilder.create()
                         .setId(CSSID.TRANSPARENT_ROOT)
                         .setStage(stage)
                         .setInsects(new Insets(3d, 3d, 3d, 3d))
                         .createNpAnchor()
                         .getElement();
                 
                Layers.setTransparentRoot(root);
     }
     
     protected void createInerRoot(){
                 this.innerRoot=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(root, 0d, 0d, 0d, 0d)
                         .setId(CSSID.INNER_ROOT)
                         .setStage(stage)
//                         .setDropShadow(new DropShadow())
                         .setEvent(AppEvent.createDbClickEvent(
                                 AppEvent.createMaximazingSwitcher()
                         ))
                         .setEvent(AppEvent.createStageDragging())
                         .createNpAnchor()
                         .getElement();
                 
                 Layers.setInerRoot(innerRoot);
     }
     
     public abstract WindowFx setContentLayer(double t,double r,double b,double l);
     
     
     
     
     public static WindowFx createDecoratedWindow(double width, double height){
     
         return new WindowDecorated(width, height);
     
         
     }
     
     public static WindowFx createDecoratedWindow(double width, double height, Stage stage){
     
         return new WindowDecorated(width, height, stage);
     
         
     }
     
     
     public static WindowUndecorated createUnDecoratedWindow(double width, double height){
     
         return new WindowUndecorated(width, height);
     
         
     }
     
     public static WindowUndecorated createUnDecoratedWindow(double width, double height, Stage stage){
     
         return new WindowUndecorated(width, height, stage);
     
         
     }
     

    
}
