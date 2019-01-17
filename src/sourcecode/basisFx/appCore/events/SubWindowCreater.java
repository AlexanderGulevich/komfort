package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.service.ServiceCrossWindow;
import javafx.scene.Node;


public class SubWindowCreater extends AppEvent{
    protected Node node;
    protected WindowBuilder windowBuilder;

    public SubWindowCreater( WindowBuilder windowBuilder ) {
        this.windowBuilder = windowBuilder;
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
            if (event.isPrimaryButtonDown() && event.getClickCount() == 1 ||  event.getClickCount() ==2 ) {
                Registry.windowFabric.customSubWindow(windowBuilder);
            }
        });
    }
}