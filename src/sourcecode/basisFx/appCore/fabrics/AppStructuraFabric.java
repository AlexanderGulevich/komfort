package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.PanelsStructura;
import basisFx.appCore.appStructura.LeftSideIconMenu;
import basisFx.appCore.appStructura.MenuBarStructura;
import basisFx.appCore.appStructura.TabStructura;
import basisFx.appCore.windows.WindowAbstraction;

public class AppStructuraFabric {


    public PanelsStructura leftSideIconMenuStructura(WindowAbstraction windowAbstraction){

        return new LeftSideIconMenu(windowAbstraction);

    }

    public PanelsStructura tabStructura(WindowAbstraction windowAbstraction){

        return new TabStructura(windowAbstraction);

    }
    public MenuBarStructura menuBarStructura(WindowAbstraction windowAbstraction){

        return new MenuBarStructura(windowAbstraction);

    }

}
