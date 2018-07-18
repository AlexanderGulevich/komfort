package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.appCore.windows.Window;
import basisFx.appCore.windows.WindowDecorated;
import javafx.stage.Stage;


public class WindowDecoratedFabric extends WindowFabric {

    @Override
    public Window mainWindow(GuiStructura guiStructura,Stage st) {
        MainWindow mainWindow = MainWindow.getInstance(guiStructura);
        Window decorated=new WindowDecorated(st,mainWindow);
        guiStructura.setWindow(decorated);
        guiStructura.init();
        SystemRegistry.mainWindow=mainWindow;
        return decorated;
    }

    @Override
    public Window errorWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public Window dialogWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public Window popupWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public Window tooltipWindow(GuiStructura guiStructura) {
        return null;
    }
}
