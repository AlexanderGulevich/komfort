package basisFx.presentation.windows;

//import basisFx.appCore.fabrics.StageTopButtonsFabric;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import javafx.scene.layout.AnchorPane;

public abstract class WindowKind {

    private double width;
    private double height;
    protected Window window;
    protected String titleName;
//    protected StageTopButtonsFabric topButtonsFabric= StageTopButtonsFabric.getInstance();


    public WindowKind(double width,double height,String titleName) {
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

    public void setWindow(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }


    public AppNode getWindowNode(String name) {
        return window.getNode(name);
    }



    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
