package basisFx.appCore.windows;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class ButtonsForStage {

    protected ButtonWrapper hideButton;
    protected ButtonWrapper  maximazeButton;
    protected ButtonWrapper  closingButton;
    protected AnchorPane buttonsAnchor;
    protected Stage stage;
    protected WindowAbstraction windowAbstraction;


    public ButtonsForStage(WindowAbstraction windowAbstraction) {
        this.windowAbstraction = windowAbstraction;
        createButtonsPanel();
    }

    protected void createButtonsPanel(){
        buttonsAnchor =
                AnchorWrapper.newBuilder()
                .setCSSid(CSSID.WindowButtonsPanel)
                .setCoordinate( new Coordinate(0d,0d,null,null))
                .setHeight(25d).setWidth(82d)
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .build().getElement();

    }

    protected abstract void init();

}
