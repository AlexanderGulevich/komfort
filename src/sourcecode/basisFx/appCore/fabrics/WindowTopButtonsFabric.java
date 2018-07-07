package basisFx.appCore.fabrics;

import basisFx.appCore.windows.SingleButton;
import basisFx.appCore.windows.ThreeButtons;
import basisFx.appCore.windows.WindowBridgeAbstraction;

public class WindowTopButtonsFabric {
    private static WindowTopButtonsFabric ourInstance = new WindowTopButtonsFabric();

    public static WindowTopButtonsFabric getInstance() {
        return ourInstance;
    }

    private WindowTopButtonsFabric() {
    }

    public ThreeButtons createThreeButtons(WindowBridgeAbstraction bridgeAbstraction){
        return new ThreeButtons(bridgeAbstraction);
    }

    public SingleButton createSingleButton(WindowBridgeAbstraction bridgeAbstraction){
        return new SingleButton(bridgeAbstraction);
    }

}
