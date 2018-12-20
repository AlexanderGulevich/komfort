package basisFx.appCore.windows;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class WindowAbstraction {

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowImpl kind;
    protected GuiStructura structura;
    private HashMap<String,AppNode> nodesHashMap =new HashMap<>();

    public WindowAbstraction(WindowImpl kind, GuiStructura structura) {
        this.stage=new Stage();
        this.kind = kind;
        this.kind.setWindowAbstraction(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initStructuraNods(structura);
        loadWindowNodsToMap(structura);

    }
    public WindowAbstraction(Stage st, WindowImpl kind, GuiStructura structura) {
        stage=st;
        this.kind = kind;
        this.kind.setWindowAbstraction(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initStructuraNods(structura);
        loadWindowNodsToMap(structura);

    }

    protected abstract void createScene();

    private void initStructuraNods(GuiStructura structura) {

        structura.setStage(stage);
        structura.setWindowAbstraction(this);
        structura.init();
    }

    private void loadWindowNodsToMap(GuiStructura structura) {
        ArrayList<AppNode> nodes = structura.getNodes();
//todo   cast
        for (AppNode node : nodes) {
            nodesHashMap.put(node.getName(),node);
        }
    }

    public  HashMap getNodesHashMap(){
        return nodesHashMap;
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
