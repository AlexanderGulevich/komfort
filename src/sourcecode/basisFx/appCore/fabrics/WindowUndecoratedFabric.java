package basisFx.appCore.fabrics;

import basisFx.appCore.windows.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowAbstractionUndecorated;
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
    public WindowAbstraction dialogWindow(WindowBuilder builder) {
        return null;
    }

    @Override
    public WindowAbstraction infoWindow(String message) {

        WindowBuilder builder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setFxmlFileName("Info")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setHeight(280d)
                .setWidth(500d)
                .setDynamicContentPanelCreator(null)
                .setTitle(null)
                .setMessage(message)
                .build();

        WindowImplInfo windowImplInfo = new WindowImplInfo(builder) ;
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplInfo);
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction customSubWindow(WindowBuilder builder) {

        WindowImplSubWindow windowImplSubWindow=new WindowImplSubWindow( builder);
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplSubWindow);
        return windowUndecorated;
    }

}
