package basisFx.appCore.fabrics;

import basisFx.appCore.appStructura.AppMainStructura;
import basisFx.appCore.appStructura.LeftSideIconMenuStructura;
import javafx.stage.Stage;

public class AppStructuraFabric {


    public AppMainStructura createLeftSideIconMenuStructura(Stage primaryStage){

        return new LeftSideIconMenuStructura(primaryStage);

    }

}
