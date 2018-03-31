package basisFx.appCore.appStructura;

import javafx.stage.Stage;

public class AppStructuraFabric {


    public AppMainStructura  createLeftSideIconMenuStructura(Stage primaryStage){

        return new LeftSideIconMenuStructura(primaryStage);

    }

}
