package basisFx.appCore.fabrics;

import basisFx.appCore.windows.SingleButton;
import basisFx.appCore.windows.ThreeButtons;
import basisFx.appCore.windows.Window;

public class StageTopButtonsFabric {
    private static StageTopButtonsFabric ourInstance = new StageTopButtonsFabric();

    public static StageTopButtonsFabric getInstance() {
        return ourInstance;
    }

    private StageTopButtonsFabric() {
    }

    public ThreeButtons createThreeButtons(Window bridgeAbstraction){
        return new ThreeButtons(bridgeAbstraction);
    }

    public SingleButton createSingleButton(Window bridgeAbstraction){
        return new SingleButton(bridgeAbstraction);
    }

}
