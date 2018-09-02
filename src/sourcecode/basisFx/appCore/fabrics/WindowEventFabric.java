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
        return new HideWindow();
    }
    public   AppEvent maximazingSwitcher(){
        return new MaximazingSwither();
    }
    public  AppEvent closingWindow(){
        return new CloseWindow();
    }
    public   AppEvent stageDragging(){
        return new StageDragging();

    }

}
