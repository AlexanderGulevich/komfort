package basisFx.appCore.windows;

import basisFx.appCore.interfaces.CallBackParametrized;
import javafx.stage.Stage;


public class WindowUndecoratedFabric  extends WindowFabric{

    @Override
    public WindowAbstraction mainWindow( Stage stage,WindowBuilder builder) {

        if (WindowAbstraction.isWindowNotExist(builder)) {
            WindowImpl mainWindow = WindowImplMain.getInstance(builder);
            WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(stage,mainWindow);
            return windowUndecorated;
        }
       return null;
    }

    @Override
    public WindowAbstraction dialogWindow(String message, CallBackParametrized<Boolean> callBackParametrized) {

        WindowBuilder builder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setPanelCreator(null)
                .setTitle(null)
                .setMessage(message)
                .setFxmlFileName("YN")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setHeight(280d)
                .setWidth(500d)
                .setCallBack(null)
                .setCallBackParametrized(callBackParametrized)
                .build();

        WindowImplDialog windowImplInfo = new WindowImplDialog(builder) ;
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplInfo);
        return windowUndecorated;
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
                .setPanelCreator(null)
                .setTitle(null)
                .setMessage(message)
                .build();

        WindowImplInfo windowImplInfo = new WindowImplInfo(builder) ;
        WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplInfo);
        return windowUndecorated;
    }

    @Override
    public WindowAbstraction customSubWindow(WindowBuilder builder) {
        boolean exist = WindowAbstraction.isWindowNotExist(builder);
        if (exist) {
            WindowImplSubWindow windowImplSubWindow=new WindowImplSubWindow( builder);
            WindowAbstractionUndecorated windowUndecorated=new WindowAbstractionUndecorated(windowImplSubWindow);
            return windowUndecorated;
        }
        return null;
    }

}
