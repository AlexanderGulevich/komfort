package basisFx.appCore.windows;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.HashMap;


public abstract class WindowAbstraction {

    protected Stage primaryStage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl windowImpl;
    protected GuiStructura structura;
    private HashMap<String,AppNode> nodesHashMap =new HashMap<>();

    public WindowAbstraction(WindowImpl windowImpl, GuiStructura structura) {
        this.primaryStage =new Stage();
        this.windowImpl = windowImpl;
        this.windowImpl.setWindowAbstraction(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initStructuraNods(structura);
        windowImpl.init();

    }
    public WindowAbstraction(WindowImpl windowImpl ) {
        this.primaryStage =new Stage();
        this.windowImpl = windowImpl;
        this.windowImpl.setWindowAbstraction(this);
        initRoot();
        initTopVisiblePanel();
        createScene();
        windowImpl.init();

    }
    public WindowAbstraction(Stage primaryStage, WindowImpl windowImpl, GuiStructura structura) {
        this.primaryStage =primaryStage;
        this.windowImpl = windowImpl;
        this.windowImpl.setWindowAbstraction(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initStructuraNods(structura);
        windowImpl.init();

    }

    protected abstract void createScene();

    private void initStructuraNods(GuiStructura structura) {

        structura.setStage(primaryStage);
        structura.setWindowAbstraction(this);
        structura.init();
    }

    public void setNod(AppNode node) {
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
                .setMetaName("TopVisiblePanel")
                .build();

        setNod(anchorWrapper);
        topVisiblePanel =anchorWrapper.getElement();

    }



    public Scene getScene() {
        return scene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public AnchorPane getTopVisibleAnchor() {
        return topVisiblePanel;
    }




}
