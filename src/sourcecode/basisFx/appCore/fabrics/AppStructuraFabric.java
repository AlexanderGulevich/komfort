package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.PanelsStructura;
import basisFx.appCore.appStructura.LeftSideIconMenu;
import basisFx.appCore.appStructura.MenuBarStructura;
import basisFx.appCore.appStructura.TabStructura;
import basisFx.appCore.windows.WindowBridgeAbstraction;

public class AppStructuraFabric {


    public PanelsStructura leftSideIconMenuStructura(WindowBridgeAbstraction windowBridgeAbstraction){

        return new LeftSideIconMenu(windowBridgeAbstraction);

    }

    public PanelsStructura tabStructura(WindowBridgeAbstraction windowBridgeAbstraction){

        return new TabStructura(windowBridgeAbstraction);

    }
    public MenuBarStructura menuBarStructura(WindowBridgeAbstraction windowBridgeAbstraction){

        return new MenuBarStructura(windowBridgeAbstraction);

    }

}
