package basisFx.appCore.appStructura;

import basisFx.appCore.windows.Panel;
import basisFx.appCore.fabrics.WindowEventFabric;
import basisFx.appCore.windows.Window;
import javafx.fxml.Initializable;

import javax.naming.InitialContext;
import java.util.ArrayList;

public abstract class GuiStructura{

    protected WindowEventFabric eventFabric= WindowEventFabric.getInstance();

    protected Window window;

    protected ArrayList <Panel> panels = new ArrayList<>();

    public ArrayList<Panel> getPanels() {
        return panels;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public abstract void init();
}
