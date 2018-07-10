package basisFx.appCore.appStructura;


import basisFx.appCore.windows.Panel;
import basisFx.appCore.fabrics.WindowEventFabric;

import java.util.ArrayList;

public abstract class GuiStructura {
    protected WindowEventFabric eventFabric= WindowEventFabric.getInstance();

protected ArrayList <Panel> panels = new ArrayList<>();

    public ArrayList<Panel> getPanels() {
        return panels;
    }
}
