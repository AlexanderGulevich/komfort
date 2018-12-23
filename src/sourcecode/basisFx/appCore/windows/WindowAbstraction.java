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

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl windowImpl;
    protected GuiStructura structura;
    private HashMap<String,AppNode> nodesHashMap =new HashMap<>();

    public WindowAbstraction(WindowImpl windowImpl, GuiStructura structura) {
        this.stage=new Stage();
        this.windowImpl = windowImpl;
        this.windowImpl.setWindowAbstraction(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initStructuraNods(structura);
        windowImpl.init();

    }
    public WindowAbstraction(Stage st, WindowImpl windowImpl, GuiStructura structura) {
        stage=st;
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

        structura.setStage(stage);
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
        topVisiblePanel = AnchorWrapper.newBuilder()
                .setParentAnchor(root)
                .setCoordinate( new Coordinate(0d, 0d, 0d, 0d) )
                .setCSSid(CSSID.TopVisiblePanel)
                .build()
                .getElement();
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
