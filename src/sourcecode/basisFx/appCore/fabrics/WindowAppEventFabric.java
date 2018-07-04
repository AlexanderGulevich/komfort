package basisFx.appCore.fabrics;

import basisFx.appCore.events.*;

public class WindowAppEventFabric {

    public static  AppEvent hidingWindow(){
        return new HideWindow();
    }
    public static  AppEvent maximazingSwitcher(){
        return new MaximazingSwither();
    }
    public static AppEvent closingWindow(){
        return new CloseWindow();
    }

    public static  AppEvent stageDragging(){
        return new StageDragging();
    }

}
