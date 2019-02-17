package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowBuilder;
import javafx.scene.Node;
import lombok.Setter;


public class SubWindowCreaterByBut extends AppEvent{
    protected Node node;
    @Setter protected WindowBuilder windowBuilder;

    public SubWindowCreaterByBut() {
    }

    public SubWindowCreaterByBut(WindowBuilder windowBuilder) {
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

                if (mediator != null) {
                    mediator.inform(this);
                }

                Registry.windowFabric.customSubWindow(windowBuilder);
            }
        });
    }
}