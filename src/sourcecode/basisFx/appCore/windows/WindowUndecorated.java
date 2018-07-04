package basisFx.appCore.windows;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.elements.AppNode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowUndecorated extends WindowBridgeAbstraction {

    public WindowUndecorated(Stage stage,WindowBridgeImplimentation implimentation) {
        super(implimentation);
        this.stage=stage;
        this.stage.initStyle(StageStyle.UNDECORATED);
    }

    public WindowUndecorated setTextIcon(AnchorPane parent, Coordinate c, FontsStore f, Double fHeight, String tIcn){
        AppNode.NodeBuilder.create()
                 .setCoordinate(c)
                 .setParent(parent)
                 .setFont(f, fHeight)
                 .setId(CSSID.TEXT_ICON_ANCHOR)
                 .setText(tIcn)
                 .createText();

        return this;
    }



    public void windowShow(){

            scene.setFill( Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            initControlTopButton();
            stage.show();

     }

  
     
   
     

    
    
   
    
}

    