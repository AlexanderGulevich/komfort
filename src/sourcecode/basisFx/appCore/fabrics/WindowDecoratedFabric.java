package basisFx.appCore.fabrics;

import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowDecorated;
import basisFx.appCore.windows.WindowImplimentation;
import javafx.stage.Stage;

public class WindowDecoratedFabric implements WindowFabric {
    @Override
    public void createWindow() {

    }

    @Override
    public WindowAbstraction createWindow(WindowImplimentation impl) {
        return null;
    }

    @Override
    public WindowDecorated createWindow(Stage st, WindowImplimentation impl) {
            return new WindowDecorated(st,impl);
    }
}
