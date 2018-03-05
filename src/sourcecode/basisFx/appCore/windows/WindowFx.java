package basisFx.appCore.windows;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.StylesLoader;
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
    public abstract WindowFx windowShow();
    public abstract WindowFx setContentLayer(double t,double r,double b,double l);
             
    protected void windowInit(){
        
      this.scene= new Scene(root,width,height);

      stage.setScene(scene);

      StylesLoader.loadAll(scene);


    }

    public WindowFx getWindow(){
        return this;
    }
     public void windowClose(){
         stage.close();
     }
        
}
