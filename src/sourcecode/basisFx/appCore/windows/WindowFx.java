package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.StylesLoader;
import basisFx.appCore.fabrics.EventFactory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    protected double left;
    protected  Stage stage;
    protected  Scene scene;
    protected  AnchorPane root;
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
        
      this.scene= new Scene(Layers.getTransparentRoot(),width,height);
      stage.setScene(scene);
      StylesLoader.loadAll(scene);
      initIcon();

    }
    public void setTitle(AbstracttTitle t){
        t.init();
    }


    public Scene getScene() {
        return scene;
    }

    public void setPanel(AbstractPanel p){
        p.setStage(stage);
        p.init();
        p.register();
    }

    void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }


}
