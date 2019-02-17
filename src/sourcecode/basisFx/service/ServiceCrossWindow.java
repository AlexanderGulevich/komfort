package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.CallBackParametrized;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;

public abstract class ServiceCrossWindow <T extends Object> implements Mediator {

    protected WindowAbstraction currentWindow;
    protected AnchorPane dynamicContentAnchor;
    @Setter protected CallBack callBack;
    @Setter protected CallBackParametrized callBackParametrized;
    public void setCurrentWindow(WindowAbstraction currentWindow) {
        this.currentWindow = currentWindow;
    }
    public abstract void init();

    protected void informParentWindowAboutClosing() {
        CallBack callBackSubWindowClosing = currentWindow.getWindowImpl().getCallBackSubWindowClosing();
        if (callBackSubWindowClosing != null) {
            callBackSubWindowClosing.call();
        }
        if (callBack != null) {
            callBack.call();
        }

    }
    public void close(){
        Registry.crossWindowTransfer.clear();
        Registry.crossWindowMediators.values().remove(this);
    }
}
