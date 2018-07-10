package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.appCore.windows.WindowImplimentation;

public class WindowImplimentationFabric {

    private static WindowImplimentationFabric ourInstance = new WindowImplimentationFabric();

    public static WindowImplimentationFabric getInstance() {
        return ourInstance;
    }

    private WindowImplimentationFabric() {
    }
    public WindowImplimentation mainWindow(GuiStructura guiStructura){
        MainWindow window = MainWindow.getInstance(guiStructura);
        SystemRegistry.mainWindow=window;
        return window;
    }

}
