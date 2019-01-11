package basisFx.appCore.windows;

import basisFx.appCore.utils.IconToPlatform;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.CrossWindowMediator;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.HashMap;

public abstract class WindowAbstraction {

    protected Stage stage;
    protected Scene scene;
    protected DynamicContentPanel currentDynamicContent;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl windowImpl;
    protected WindowAbstraction parentWindow;
    protected CrossWindowMediator crossWindowMediator=new CrossWindowMediator(this);
    public  enum DefaultPanelsNames {rootTransparent, topVisibleAnchor, mainContentAnchor}
    protected HashMap<String,AppNode> appNodMap =new HashMap<>();
    protected HashMap<String,Node> nodMap =new HashMap<>();

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

    public void clearSubWindow() {
        crossWindowMediator.clearSubWindow();
    }
    public boolean hasParentWindow(){
        if ( parentWindow != null) {
            return true;
        }
        return false;
    }
    public void setCurrentDynamicContent(DynamicContentPanel currentDynamicContent) {
        this.currentDynamicContent = currentDynamicContent;
    }
    public CrossWindowMediator getCrossWindowMediator() {
        return crossWindowMediator;
    }
    public void clearCurrentDynamicContentPanel() {
        this.currentDynamicContent = null;
    }
    protected abstract void createScene();
    public void setNodToMap(AppNode node) {
            appNodMap.put(node.getMetaName(),node);
    }
    public void setNodToMap(Node node, String name) {
            nodMap.put(name,node);
    }
    public  AppNode getAppNode(String str){
        return appNodMap.get(str);
    }
    public  Node getNode(String str){
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
