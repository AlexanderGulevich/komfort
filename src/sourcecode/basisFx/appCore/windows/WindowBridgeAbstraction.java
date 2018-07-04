package basisFx.appCore.windows;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.fabrics.EventFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import org.scenicview.ScenicView;


/**
 *
 * @author 62
 */
public abstract class WindowBridgeAbstraction {

    protected Stage stage;
    protected Scene scene;
    protected WindowBridgeImplimentation implimentation;
    protected EventFactory eventFactory = EventFactory.getInstance();

    public WindowBridgeAbstraction(WindowBridgeImplimentation implimentation) {
        this.implimentation = implimentation;
        this.scene= new Scene(Layers.getTransparentRoot(),implimentation.getWidth(),implimentation.getHeight());
        stage.setScene(scene);
        CSSHandler.setScene(scene);
        //todo переделать
    }

    public abstract void windowShow();


    public void setTitle(AbstracttTitle t){
        t.init();
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }


    public void setPanel(AbstractPanel p){
        p.setStage(stage);
        p.init();
        p.register();
    }

    public void setPanel(AbstractPanel ... p){

        for (AbstractPanel abstractPanel : p) {
            abstractPanel.setStage (stage);
            abstractPanel.init();
            abstractPanel.register();
        }


    }



}
