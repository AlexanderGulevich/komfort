package basisFx.appCore.fabrics;

import basisFx.appCore.windows.SingleButton;
import basisFx.appCore.windows.ThreeButtons;
import basisFx.appCore.windows.WindowAbstraction;

public class WindowTopButtonsFabric {
    private static WindowTopButtonsFabric ourInstance = new WindowTopButtonsFabric();

    public static WindowTopButtonsFabric getInstance() {
        return ourInstance;
    }

    private WindowTopButtonsFabric() {
    }

    public ThreeButtons createThreeButtons(WindowAbstraction bridgeAbstraction){
        return new ThreeButtons(bridgeAbstraction);
    }

    public SingleButton createSingleButton(WindowAbstraction bridgeAbstraction){
        return new SingleButton(bridgeAbstraction);
    }

}
