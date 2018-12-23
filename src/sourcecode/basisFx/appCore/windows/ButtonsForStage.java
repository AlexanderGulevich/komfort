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
    }


    protected abstract void init();

}
