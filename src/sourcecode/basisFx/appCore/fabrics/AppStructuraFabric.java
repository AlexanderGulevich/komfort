package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.AppMainStructura;
import basisFx.appCore.appStructura.LeftSideIconMenuStructura;
import basisFx.appCore.appStructura.TabStructura;
import basisFx.appCore.windows.WindowFx;
import javafx.stage.Stage;

public class AppStructuraFabric {


    public AppMainStructura leftSideIconMenuStructura( WindowFx windowFx){

        return new LeftSideIconMenuStructura(windowFx);

    }

    public AppMainStructura tabStructura(WindowFx windowFx){

        return new TabStructura(windowFx);

    }

}
