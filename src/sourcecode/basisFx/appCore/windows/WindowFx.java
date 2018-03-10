package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.StylesLoader;
import basisFx.appCore.events.EventFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



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
    protected AnchorCoordinate titlePanelCoordinate;
    protected EventFactory eventFactory=EventFactory.getInstance();
 
    abstract void initControlTopButton();
    public abstract WindowFx windowShow();
               
    protected void windowInit(){
        
      this.scene= new Scene(root,width,height);

      stage.setScene(scene);

      StylesLoader.loadAll(scene);
      
//      ScenicView.show(scene);


    }

    public WindowFx getWindow(){
        return this;
    }
     public void windowClose(){
         stage.close();
     }
        
}
