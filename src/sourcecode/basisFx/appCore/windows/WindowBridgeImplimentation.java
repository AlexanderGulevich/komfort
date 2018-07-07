package basisFx.appCore.windows;

import basisFx.appCore.fabrics.WindowTopButtonsFabric;

public abstract class WindowBridgeImplimentation {

    private double width;
    private double height;
    protected WindowBridgeAbstraction window;
    protected WindowTopButtonsFabric topButtonsFabric=WindowTopButtonsFabric.getInstance();


    protected abstract void initUndecoratedTitle();
    protected abstract void initDecoratedTitle();
    public abstract void initUndecoratedStageButtons();


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWindow(WindowBridgeAbstraction window) {
        this.window = window;
    }

}
