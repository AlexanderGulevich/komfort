package basisFx.presentation.appStructura;

import basisFx.appCore.ElementsStore;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.windows.Window;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class GuiStructura{

    protected Window window;
    protected ArrayList <AppNode> nodes = new ArrayList<>();
    private Stage stage;

    public ArrayList<AppNode> getNodes() {return nodes;}

    public void setWindow(Window window) {
        this.window = window;
    }

    public abstract void init();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void copyToElementsStore(){
        for (AppNode node : nodes) {
            ElementsStore.elements.put(node.getName(),node);
        }
    }
}
