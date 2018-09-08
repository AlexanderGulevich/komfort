package basisFx.appCore.fabrics;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.appCore.windows.Window;
import basisFx.appCore.windows.WindowDecorated;
import basisFx.appCore.windows.WindowKind;
import javafx.stage.Stage;


public class WindowDecoratedFabric extends WindowFabric {

    @Override
    public Window mainWindow(GuiStructura structura,Stage stage) {
        WindowKind mainWindow = MainWindow.getInstance();
        Window decorated=new WindowDecorated(stage,mainWindow,structura);
        SystemRegistry.mainWindow=decorated;
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
