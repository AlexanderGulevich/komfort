package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;

public abstract class WindowImpl {

    private double width;
    private double height;
    protected WindowAbstraction windowAbstraction;
    protected String titleName;

    public WindowImpl(double width, double height, String titleName) {
        setHeight(height);
        setWidth(width);
        setTitleName(titleName);

    }

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

    public void setWindowAbstraction(WindowAbstraction windowAbstraction) {
        this.windowAbstraction = windowAbstraction;
    }

    public WindowAbstraction getWindowAbstraction() {
        return windowAbstraction;
    }


    public AppNode getWindowNode(String name) {
        return windowAbstraction.getNode(name);
    }



    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
