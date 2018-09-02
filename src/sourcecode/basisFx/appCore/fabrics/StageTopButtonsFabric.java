package basisFx.appCore.fabrics;

import basisFx.presentation.windows.ThreeButtons;
import basisFx.presentation.windows.Window;

public class StageTopButtonsFabric {

    public static ThreeButtons createThreeButtons(Window bridgeAbstraction){
        return new ThreeButtons(bridgeAbstraction);
    }

//    public static  SingleButton createSingleButton(Window bridgeAbstraction){
//        return new SingleButton(bridgeAbstraction);
//    }

}
