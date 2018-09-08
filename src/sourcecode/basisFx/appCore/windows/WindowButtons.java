package basisFx.appCore.windows;

import basisFx.appCore.elements.AnchorWrapper;
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
    protected AnchorPane buttonsAnchor;
    protected Stage stage;
    protected Window window;
    protected WindowEventFabric eventFabric= WindowEventFabric.getInstance();

    public WindowButtons(Window window) {
        this.window = window;
        createButtonsPanel();
    }

    protected void createButtonsPanel(){
        buttonsAnchor =
                AnchorWrapper.newBuilder()
                .setCSSid(CSSID.WindowButtonsPanel)
                .setCoordinate( new Coordinate(0d,0d,null,null))
                .setHeight(25d).setWidth(82d)
                .setParentAnchor(window.getTopVisibleAnchor())
                .build().getElement();

    }

    protected abstract void init();

}
