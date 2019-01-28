package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public abstract class ServiceCrossWindow <T extends Object> implements Mediator {

    protected WindowAbstraction currentWindow;
    protected AnchorPane dynamicContentAnchor;
    public void setCurrentWindow(WindowAbstraction currentWindow) {
        this.currentWindow = currentWindow;
    }
    public abstract void init();

    protected void informParentWindowAboutClosing() {
        currentWindow.getWindowImpl().getCallBackSubWindowClosing().call();
    }
}
