package basisFx.appCore.fabrics;

import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowImplimentation;
import javafx.stage.Stage;

public class WindowUndecoratedFabric  implements WindowFabric{
    @Override
    public void createWindow() {

    }

    @Override
    public WindowAbstraction createWindow(WindowImplimentation impl) {
        return null;
    }

    @Override
    public WindowAbstraction createWindow(Stage st, WindowImplimentation impl) {
        return null;
    }
}
