package basisFx.appCore.windows;

import basisFx.appCore.utils.IconToPlatform;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.HashMap;


public abstract class WindowAbstraction {

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl windowImpl;
    public  enum DefaultPanelsNames {rootTransparent, topVisibleAnchor, mainContentAnchor}
    protected HashMap<String,AppNode> nodesHashMap =new HashMap<>();

    public WindowAbstraction(WindowImpl windowImpl ) {
        this.stage =new Stage();
        IconToPlatform.init(stage);
        this.windowImpl = windowImpl;
        initRoot();
        initTopVisiblePanel();
        createScene();
        windowImpl.initTemplateMethod(this);
    }
    public WindowAbstraction(Stage stage, WindowImpl windowImpl) {
        this.stage = stage;
        IconToPlatform.init(stage);
        this.windowImpl = windowImpl;
        initRoot();
        initTopVisiblePanel();
        createScene();
        windowImpl.initTemplateMethod(this);
    }
    protected abstract void createScene();
    public void setNodToMap(AppNode node) {
            nodesHashMap.put(node.getMetaName(),node);
    }
    public  AppNode getNode(String str){
        return nodesHashMap.get(str);
    }
    protected abstract void initRoot();
    private void initTopVisiblePanel() {
        AnchorWrapper anchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(root)
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setCSSid(CSSID.TopVisiblePanel)
                .setMetaName(DefaultPanelsNames.topVisibleAnchor.name())
                .build();
        setNodToMap(anchorWrapper);
        topVisiblePanel =anchorWrapper.getElement();
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
    public AnchorPane getTopVisibleAnchor() {
        return topVisiblePanel;
    }

}
