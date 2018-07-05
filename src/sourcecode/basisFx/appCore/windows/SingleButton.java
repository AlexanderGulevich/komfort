package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.fabrics.WindowAppEventFabric;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

public class SingleButton extends WindowButtons {

    String closeStr="";
    double fontHeight= 17d;
    double topMatgin=4d;
    double height=25d;
    double width=25d;
    Insets padding=new Insets(0d, 0d, 0d, 0d);
    FontsStore fs=FontsStore.FAWESOME5SOLID;

    @Override
    protected void init() {


        //крестик
        closingButton= AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setSize(width,height).
                setPadding(padding).
                setCoordinate(topMatgin, 0d, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanel).
                setStage(stage).
                setEvent(WindowAppEventFabric.closingWindow()).
                createNButton().
                setString(closeStr, ContentDisplay.CENTER);


    }
}
