package basisFx.appCore.windows;

import basisFx.appCore.panels.AbstractPanel;
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
    protected WindowBridgeImplimentation impl;
    protected EventFactory eventFactory = EventFactory.getInstance();

    public WindowBridgeAbstraction(WindowBridgeImplimentation implimentation) {
        impl = implimentation;
        scene= new Scene(impl.getRoot(), impl.getWidth(), impl.getHeight());
        stage.setScene(scene);
        CSSHandler.getInstanse().loadStylesToScene(scene);
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
