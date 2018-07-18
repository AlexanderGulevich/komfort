package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

public class ThreeButtons extends WindowButtons {

    String closeStr="";
    String hideStr="";
    String maximazeStr="";
    double fontHeight= 17d;
    double topMatgin=4d;
    double height=25d;
    double width=25d;
    Insets padding=new Insets(0d, 0d, 0d, 0d);
    FontsStore fs=FontsStore.FAWESOME5SOLID;

    public ThreeButtons(Window window) {
        super(window);
    }
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
                setEvent(eventFabric.closingWindow()).
                createNButton().
                setString(closeStr, ContentDisplay.CENTER);

        hideButton = AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setEvent(eventFabric.hidingWindow()).
                setSize(width, height).
                setPadding(padding).
                setCoordinate(topMatgin, width + width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanel).
                setStage(stage).
                createNButton().
                setString(hideStr, ContentDisplay.CENTER);

        maximazeButton = AppNode.NodeBuilder.create().
                setFont(fs, fontHeight).
                setEvent(eventFabric.maximazingSwitcher()).
                setSize(width, height).
                setPadding(padding).
                setCoordinate(topMatgin, width, null, null).
                setId(CSSID.TOP_CONTROL_BUTTON).setParent(buttonsPanel).
                setStage(stage).
                createNButton().
                setString(maximazeStr, ContentDisplay.CENTER);
    }
}
