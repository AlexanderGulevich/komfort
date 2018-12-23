package basisFx.appCore.fabrics;

import basisFx.appCore.windows.*;
import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowAbstractionUndecorated;
import basisFx.presentation.appStructura.InfoWindowStructura;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    public WindowUndecoratedFabric() {
        Registry.windowFabric=this;
    }



    @Override
    public WindowAbstraction mainWindow(GuiStructura structura, Stage stage) {
        WindowImpl mainWindow = WindowImplMain.getInstance();
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(stage,mainWindow,structura);
        new ButtonsForStageThreeEntity(windowUndecorated);
        Registry.mainWindow=windowUndecorated;
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
    public WindowAbstraction infoWindow(String message) {
        WindowImplInfo windowImplInfo = new WindowImplInfo(message) ;
        InfoWindowStructura infoWindowStructura = new InfoWindowStructura();
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplInfo, infoWindowStructura);
        new ButtonsForStageSingle(windowUndecorated);
        Registry.infoWindow=windowUndecorated;
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction tooltipWindow(GuiStructura guiStructura) {
        return null;
    }
}
