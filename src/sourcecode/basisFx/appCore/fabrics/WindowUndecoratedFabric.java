package basisFx.appCore.fabrics;

import basisFx.appCore.windows.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowAbstractionUndecorated;
import basisFx.presentation.appStructura.InfoWindowStructura;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    @Override
    public WindowAbstraction mainWindow( Stage stage,WindowBuilder builder) {
        WindowImpl mainWindow = WindowImplMain.getInstance(builder);
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(stage,mainWindow);
        Registry.mainWindow=windowUndecorated;
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction errorWindow(String message) {
        return null;
    }

    @Override
    public WindowAbstraction dialogWindow(String message) {
        return null;
    }

    @Override
    public WindowAbstraction infoWindow(String message) {

        WindowBuilder builder = WindowBuilder.newBuilder()
                .setButtonsForStage(new ButtonsForStageSingle(InfoWindowStructura.Structura.titleAnchor.name()))
                .setFxmlFileName(null)
                .setGUIStructura(new InfoWindowStructura())
                .setHeight(null)
                .setWidth(null)
                .setParentAnchorNameForFXML(null)
                .setTargetCreater(null)
                .setTitle("Внимание!")
                .build();

        WindowImplInfo windowImplInfo = new WindowImplInfo(builder,message) ;
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplInfo);
        Registry.infoWindow=windowUndecorated;
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction customSubWindow(WindowBuilder builder) {

        WindowImplSubWindow windowImplSubWindow=new WindowImplSubWindow( builder);
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplSubWindow);
        Registry.subWindow=windowUndecorated;
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction tooltipWindow(String message) {
        return null;
    }
}
