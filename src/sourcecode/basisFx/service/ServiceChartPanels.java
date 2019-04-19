package basisFx.service;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.CallBackParametrized;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;

public class ServiceChartPanels implements Mediator {

    protected WindowAbstraction currentWindow;
    protected AnchorPane dynamicContentAnchor;
    @Setter protected CallBack callBack;
    @Setter protected CallBackParametrized callBackParametrized;
    public void setCurrentWindow(WindowAbstraction currentWindow) {
        this.currentWindow = currentWindow;
    }



    @Override
    public void inform(Object node) {

    }
}