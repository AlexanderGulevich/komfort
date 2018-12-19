package basisFx.appCore.fabrics;

import basisFx.appCore.windows.*;
import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.utils.SystemRegistry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowAbstractionUndecorated;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    public WindowUndecoratedFabric() {
        SystemRegistry.windowFabric=this;
    }



    @Override
    public WindowAbstraction mainWindow(GuiStructura structura, Stage stage) {
        WindowImpl mainWindow = WindowImplMain.getInstance();
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(stage,mainWindow,structura);

        return windowUndecorated;
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
    public WindowAbstraction popupWindow(GuiStructura guiStructura) {
        return null;
    }

    @Override
    public WindowAbstraction tooltipWindow(GuiStructura guiStructura) {
        return null;
    }
}
