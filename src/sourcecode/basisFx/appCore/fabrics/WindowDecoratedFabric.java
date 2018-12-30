package basisFx.appCore.fabrics;

import basisFx.appCore.windows.WindowAbstraction;
import basisFx.presentation.TargetPanel;
import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowImplMain;
import basisFx.appCore.windows.WindowAbstractionDecorated;
import basisFx.appCore.windows.WindowImpl;
import javafx.stage.Stage;


public class WindowDecoratedFabric extends WindowFabric {

    @Override
    public WindowAbstraction mainWindow(GuiStructura structura, Stage stage) {
        WindowImpl mainWindow = WindowImplMain.getInstance();
        WindowAbstraction decorated=new WindowAbstractionDecorated(stage,mainWindow,structura);
        Registry.mainWindow =decorated;
        return decorated;
    }

    @Override
    public WindowAbstraction errorWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public WindowAbstraction dialogWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public WindowAbstraction infoWindow(String message) {
        return null;
    }

    @Override
    public WindowAbstraction subWindow(TargetPanel target, double width, double height) {
        return null;
    }

    @Override
    public WindowAbstraction tooltipWindow(GuiStructura guiStructura) {
        return null;
    }
}
