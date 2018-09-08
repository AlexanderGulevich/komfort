package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.fabrics.WindowEventFabric;
import basisFx.appCore.windows.Window;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class GuiStructura{

    protected WindowEventFabric eventFabric= WindowEventFabric.getInstance();
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
}
