package basisFx.appCore.windows;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowUndecorated extends WindowBridgeAbstraction {

    public WindowUndecorated(Stage stage,WindowBridgeImplimentation implimentation) {
        super(implimentation);
        this.stage=stage;
        this.stage.initStyle(StageStyle.UNDECORATED);
    }

    public void windowShow(){

        scene.setFill( Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

     }

  
     
   
     

    
    
   
    
}

    