package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.MainWindow;
import basisFx.appCore.windows.Window;
import basisFx.appCore.windows.WindowUndecorated;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    @Override
    public Window mainWindow(GuiStructura guiStructura,Stage st) {
        MainWindow kindOfWindow = MainWindow.getInstance(guiStructura);
        WindowUndecorated windowUndecorated=new WindowUndecorated(st,kindOfWindow);
        SystemRegistry.mainWindow=kindOfWindow;
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
