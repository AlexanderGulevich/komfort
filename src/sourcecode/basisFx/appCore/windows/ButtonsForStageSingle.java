package basisFx.appCore.windows;


import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.CloseWindow;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

public class ButtonsForStageSingle extends ButtonsForStage {

    private String closeStr="";
    private double fontHeight= 17d;
    private double topMatgin=4d;
    private double height=25d;
    private double width=25d;
    private Insets padding=new Insets(0d, 0d, 0d, 0d);
    private FontsStore fs=FontsStore.FAWESOME5SOLID;

    public ButtonsForStageSingle(WindowAbstraction windowAbstraction) {
        super(windowAbstraction);
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
                        .setStage(windowAbstraction.getStage())
                        .setEvents(new CloseWindow())
                        .setName(closeStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();
    }
}
