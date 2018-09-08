package basisFx.appCore.fabrics;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.appCore.windows.Window;
import basisFx.appCore.windows.WindowKind;
import basisFx.appCore.windows.WindowUndecorated;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    public WindowUndecoratedFabric() {
        SystemRegistry.windowFabric=this;
    }



    @Override
    public Window mainWindow(GuiStructura structura,Stage stage) {
        WindowKind mainWindow = MainWindow.getInstance();
        WindowUndecorated windowUndecorated=new WindowUndecorated(stage,mainWindow,structura);

        return windowUndecorated;
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
