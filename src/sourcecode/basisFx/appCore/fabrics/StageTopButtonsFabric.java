package basisFx.appCore.fabrics;

import basisFx.appCore.windows.ThreeButtons;
import basisFx.appCore.windows.Window;

public class StageTopButtonsFabric {

    public static ThreeButtons createThreeButtons(Window bridgeAbstraction){
        return new ThreeButtons(bridgeAbstraction);
    }

//    public static  SingleButton createSingleButton(Window bridgeAbstraction){
//        return new SingleButton(bridgeAbstraction);
//    }

}
