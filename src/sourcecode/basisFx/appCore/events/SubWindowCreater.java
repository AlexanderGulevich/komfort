package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import javafx.scene.Node;


public class SubWindowCreater extends AppEvent{
    protected Node  node;
    protected WindowBuilder windowBuilder;
    protected WindowAbstraction currentWindow;
    protected CallBack callBackSubWindowClosing;

    public SubWindowCreater(WindowAbstraction currentWindow, CallBack callBackSubWindowClosing, WindowBuilder windowBuilder ) {
        this.windowBuilder = windowBuilder;
        this.currentWindow = currentWindow;
        this.callBackSubWindowClosing = callBackSubWindowClosing;

    }

    @Override
    public void setEventToElement(AppNode appNode) {
        this.nodeWrapper =appNode;
        this.node= appNode.getElement();
        run();
    }
    @Override
    public void setEventToElement(Node node) {
        this.node= node;
        run();
    }
    @Override
    public void run() {
        node.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
                WindowAbstraction subWindow = Registry.windowFabric.customSubWindow(windowBuilder);
                currentWindow.getCrossWindowMediator().setSubWindow(subWindow);
                currentWindow.getCrossWindowMediator().setCallBackSubWindowClosing(callBackSubWindowClosing);
            }
        });
    }
}