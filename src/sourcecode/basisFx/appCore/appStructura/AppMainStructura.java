package basisFx.appCore.appStructura;

import basisFx.appCore.MenuTrigger;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.fabrics.PanelFabric;
import basisFx.appCore.windows.TitleFabric;
import basisFx.appCore.fabrics.WindowFabric;

public abstract class AppMainStructura {

    protected WindowFabric windowFabric=new WindowFabric();
    protected TitleFabric titleFabric =new TitleFabric();
    protected PanelFabric panelFabric =new PanelFabric();
    protected MenuTrigger menuTrigger =new MenuTrigger();
    protected MenuFabric menuFabric  =new MenuFabric();


}
