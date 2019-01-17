package basisFx.appCore.windows;

import basisFx.appCore.utils.IconToPlatform;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.DynamicContentPanel;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.HashMap;

public    abstract  class  WindowAbstraction<T extends  Object> {

    protected Stage stage;
    protected Scene scene;
    protected DynamicContentPanel currentDynamicContent;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl windowImpl;
    public  enum DefaultPanelsNames {rootTransparent, topVisibleAnchor, mainContentAnchor}
    protected HashMap<String, T> nodMap =new HashMap<>();

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


    public void setCurrentDynamicContent(DynamicContentPanel currentDynamicContent) {
        this.currentDynamicContent = currentDynamicContent;
    }
    public void clearCurrentDynamicContentPanel() {
        this.currentDynamicContent = null;
    }

    public DynamicContentPanel getCurrentDynamicContent() {
        return currentDynamicContent;
    }

    protected abstract void createScene();

    public void setNodeToMap(T  node, String name) {
        nodMap.put(name,node);
    }
    public T getNodeFromMap(String str){
        return nodMap.get(str);
    }

    protected abstract void initRoot();
    private void initTopVisiblePanel() {
        AnchorWrapper anchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(root)
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setCSSid(CSSid.TopVisiblePanel)
                .setMetaName(DefaultPanelsNames.topVisibleAnchor.name())
                .build();
        topVisiblePanel =anchorWrapper.getElement();

        setNodeToMap((T) topVisiblePanel,anchorWrapper.getMetaName());
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

    public WindowImpl getWindowImpl() {
        return windowImpl;
    }
}
