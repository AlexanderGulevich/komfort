package basisFx.appCore.windows;

public abstract class WindowBridgeImplimentation {

    private double width;
    private double height;
    protected WindowBridgeAbstraction window;

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
