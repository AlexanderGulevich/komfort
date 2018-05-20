package basisFx.appCore.windows;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.StylesLoader;
import basisFx.appCore.fabrics.EventFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import org.scenicview.ScenicView;


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
    protected Coordinate titlePanelCoordinate;
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected boolean  isPopup;
 
    abstract void initControlTopButton();
    public abstract WindowFx windowShow();

    public void setIsPopup(boolean popup) {

        isPopup = popup;
    }

    public Stage getStage() {
        return stage;
    }

    protected void windowInit(){
        
      this.scene= new Scene(root,width,height);

      stage.setScene(scene);

      StylesLoader.loadAll(scene);
      //TODO scenicView
//      ScenicView.show(scene);


    }

    public WindowFx getWindow(){
        return this;
    }
     public void windowClose(){
         stage.close();
     }
        
}
