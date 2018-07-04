package basisFx.appCore.windows;

public abstract class WindowBridgeImplimentation {



    private double width;
    private double height;
    private WindowBridgeAbstraction window;

    protected abstract void initTitle();
    protected abstract void initIcon();



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
