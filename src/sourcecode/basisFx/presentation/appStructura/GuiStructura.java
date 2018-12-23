package basisFx.presentation.appStructura;

import basisFx.appCore.windows.WindowAbstraction;
import javafx.stage.Stage;

public abstract class GuiStructura{

    protected WindowAbstraction windowAbstraction;
    private Stage stage;

    public void setWindowAbstraction(WindowAbstraction windowAbstraction) {
        this.windowAbstraction = windowAbstraction;
    }

    public abstract void init();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

}
