package basisFx.appCore.fabrics;

import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.*;
import javafx.stage.Stage;

public abstract class WindowFabric {
    public abstract WindowAbstraction mainWindow(Stage st,WindowBuilder builder);
    public abstract WindowAbstraction errorWindow(String message);
    public abstract WindowAbstraction dialogWindow(String message  );
    public abstract WindowAbstraction infoWindow( String message);
    public abstract WindowAbstraction customSubWindow(WindowBuilder builder);
    public abstract WindowAbstraction tooltipWindow(String message);



    public static WindowFabric WindowDecorated(){
        WindowDecoratedFabric windowFabric = new WindowDecoratedFabric();
        Registry.windowFabric=windowFabric;
        return windowFabric;
    }
    public static WindowFabric WindowUndecorated(){

        WindowUndecoratedFabric windowFabric = new WindowUndecoratedFabric();
        Registry.windowFabric=windowFabric;
        return windowFabric;
    }
}
