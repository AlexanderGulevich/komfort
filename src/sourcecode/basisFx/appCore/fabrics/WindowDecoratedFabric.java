package basisFx.appCore.fabrics;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.interfaces.CallBackParametrized;
import basisFx.appCore.windows.*;
import javafx.stage.Stage;


public class WindowDecoratedFabric extends WindowFabric {


    @Override
    public WindowAbstraction mainWindow(Stage st, WindowBuilder builder) {
        return null;
    }

    @Override
    public WindowAbstraction dialogWindow(String message, CallBackParametrized<Boolean> callBackParametrized) {
        return null;
    }


    @Override
    public WindowAbstraction infoWindow(String message) {
        return null;
    }

    @Override
    public WindowAbstraction customSubWindow(WindowBuilder builder) {
        return null;
    }
}
