package basisFx.appCore.windows;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

public class ThreeButtons extends WindowButtons {

    private String closeStr="";
    private String hideStr="";
    private String maximazeStr="";
    private double fontHeight= 17d;
    private double topMatgin=4d;
    private double height=25d;
    private double width=25d;
    private Insets padding=new Insets(0d, 0d, 0d, 0d);
    private FontsStore fs=FontsStore.FAWESOME5SOLID;

    public ThreeButtons(Window window) {
        super(window);
        init();
    }
    @Override
    protected void init() {
        //крестик
        closingButton=
                ButtonWrapper.newBuilder()
                        .setFont(fs)
                        .setFontSize(fontHeight)
                        .setWidth(width)
                        .setHeight(height)
                        .setInsects(padding)
                        .setCoordinate(new Coordinate(topMatgin, 0d, null, null))
                        .setCSSid(CSSID.TOP_CONTROL_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(window.getStage())
                        .setEvents(eventFabric.closingWindow())
                        .setName(closeStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

        hideButton =
                ButtonWrapper.newBuilder()
                        .setFont(fs)
                        .setFontSize(fontHeight)
                        .setEvents(eventFabric.hidingWindow())
                        .setWidth(width)
                        .setHeight(height)
                        .setInsects(padding)
                        .setCoordinate(new Coordinate(topMatgin, width + width, null, null))
                        .setCSSid(CSSID.TOP_CONTROL_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(window.getStage())
                        .setName(hideStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

        maximazeButton =
                ButtonWrapper.newBuilder()
                        .setFont(fs)
                        .setFontSize(fontHeight)
                        .setEvents(eventFabric.maximazingSwitcher())
                        .setWidth(width)
                        .setHeight(height)
                        .setInsects(padding)
                        .setCoordinate(new Coordinate(topMatgin, width, null, null))
                        .setCSSid(CSSID.TOP_CONTROL_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(window.getStage())
                        .setName(maximazeStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

    }
}
