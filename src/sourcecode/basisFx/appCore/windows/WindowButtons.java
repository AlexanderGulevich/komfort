package basisFx.appCore.windows;

import basisFx.appCore.elements.ButtonWrapper;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class WindowButtons {

    protected ButtonWrapper hideButton;
    protected ButtonWrapper  maximazeButton;
    protected ButtonWrapper  closingButton;
    protected AnchorPane buttonsPanel;
    protected Stage stage;

    protected abstract void init();

}
