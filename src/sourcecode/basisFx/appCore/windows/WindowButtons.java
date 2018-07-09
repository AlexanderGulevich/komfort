package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.fabrics.WindowEventFabric;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class WindowButtons {

    protected ButtonWrapper hideButton;
    protected ButtonWrapper  maximazeButton;
    protected ButtonWrapper  closingButton;
    protected AnchorPane buttonsPanel;
    protected Stage stage;
    protected WindowAbstraction windowAbstraction;
    protected WindowEventFabric eventFabric= WindowEventFabric.getInstance();

    public WindowButtons(WindowAbstraction windowAbstraction) {
        this.windowAbstraction = windowAbstraction;
        createButtonsPanel();
    }

    protected void createButtonsPanel(){
        buttonsPanel =  (AnchorPane) AppNode.NodeBuilder.create()
                .setId(CSSID.WindowButtonsPanel)
                .setCoordinate( new Coordinate(0d,0d,null,null))
                .setHeight(25d).setWidth(82d)
                .setParent(windowAbstraction.getTopVisiblePanel())
                .createAnchorPanelWrapper().getElement();

    }

    protected abstract void init();

}
