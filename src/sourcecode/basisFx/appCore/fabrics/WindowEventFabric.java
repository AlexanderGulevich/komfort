package basisFx.appCore.fabrics;

import basisFx.appCore.events.*;

public class WindowEventFabric {
    private static WindowEventFabric ourInstance = new WindowEventFabric();

    public static WindowEventFabric getInstance() {
        return ourInstance;
    }

    private WindowEventFabric() {
    }

    public  AppEvent hidingWindow(){
//        return new HideWindow();
        return null;
    }
    public   AppEvent maximazingSwitcher(){
//        return new MaximazingSwither();
        return null;
    }
    public  AppEvent closingWindow(){
//        return new CloseWindow();
        return null;
    }
    public   AppEvent stageDragging(){
        return new StageDragging();

    }

}
