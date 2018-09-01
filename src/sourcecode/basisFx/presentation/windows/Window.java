package basisFx.presentation.windows;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.IMGpath;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import basisFx.appCore.fabrics.*;

import java.util.ArrayList;
import java.util.HashMap;
//import org.scenicview.ScenicView;


/**
 *
 * @author 62
 */
public abstract class Window {

    protected Stage stage;
    protected Scene scene;
    protected AnchorPane root;
    protected AnchorPane topVisiblePanel;
    protected WindowKind kind;
    protected GuiStructura structura;
    private HashMap<String,AppNode> nodesHashMap =new HashMap<>();

    public Window(WindowKind kind,GuiStructura structura) {
        this.kind = kind;
        this.kind.setWindow(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initIcon();
        initStructuraNods(structura);
        loadWindowNodsToMap(structura);

    }
    public Window(Stage st,WindowKind kind,GuiStructura structura) {
        stage=st;
        this.kind = kind;
        this.kind.setWindow(this);
        this.structura=structura;
        initRoot();
        initTopVisiblePanel();
        createScene();
        initIcon();
        initStructuraNods(structura);
        loadWindowNodsToMap(structura);

    }

    protected abstract void createScene();

    private void initStructuraNods(GuiStructura structura) {

        structura.setStage(stage);
        structura.setWindow(this);
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
                .setCssid(CSSID.TopVisiblePanel)
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

    private void initIcon() {
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream(IMGpath.ICONTOOP.get()
                )));
    }

    public AnchorPane getTopVisibleAnchor() {
        return topVisiblePanel;
    }




}
