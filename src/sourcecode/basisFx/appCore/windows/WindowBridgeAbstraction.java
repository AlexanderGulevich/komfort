package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.fabrics.EventFactory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import org.scenicview.ScenicView;


/**
 *
 * @author 62
 */
public abstract class WindowBridgeAbstraction {

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowBridgeImplimentation impl;
    protected EventFactory eventFactory = EventFactory.getInstance();

    public WindowBridgeAbstraction(WindowBridgeImplimentation implimentation) {
        impl = implimentation;
        impl.setWindow(this);
        initRoot();
        initTopVisiblePanel();
        scene= new Scene(root, impl.getWidth(), impl.getHeight());
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        initIcon();
        CSSHandler.getInstanse().loadStylesToScene(scene);
    }

    protected abstract void initRoot();

    protected void initTopVisiblePanel() {
        topVisiblePanel = (AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(root, 0d, 0d, 0d, 0d)
                .setId(CSSID.TopVisiblePanel)
                .createAnchorPanelWrapper()
                .getElement();
    }

    public void setTitle(AbstracttTitle t){
        t.init();
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setPanel(AbstractPanel p){
        p.setStage(stage);
        p.init();
        p.register();
    }

    private void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }


    public void setPanel(AbstractPanel ... p){

        for (AbstractPanel abstractPanel : p) {
            abstractPanel.setStage (stage);
            abstractPanel.init();
            abstractPanel.register();
        }


    }



}
