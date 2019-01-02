package basisFx.appCore.windows;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.CloseMainWindow;
import basisFx.appCore.events.HideWindow;
import basisFx.appCore.events.MaximazingSwither;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

public class    ButtonsForStageThreeEntity extends ButtonsForStage {

    private String closeStr="";
    private String hideStr="";
    private String maximazeStr="";
    private double fontHeight= 17d;
    private double topMatgin=4d;
    private double height=25d;
    private double width=25d;
    private Insets padding=new Insets(0d, 0d, 0d, 0d);
    private FontsStore fs=FontsStore.FAWESOME5SOLID;

    public ButtonsForStageThreeEntity(WindowAbstraction windowAbstraction) {
        super(windowAbstraction);
        init();
    }
    @Override
    protected void init() {

        buttonsAnchor =
                AnchorWrapper.newBuilder()
                        .setCSSid(CSSID.WindowButtonsPanel)
                        .setCoordinate( new Coordinate(0d,0d,null,null))
                        .setHeight(25d).setWidth(82d)
                        .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                        .setMetaName("buttonsAnchor")
                        .build().getElement();

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
                        .setStage(windowAbstraction.getPrimaryStage())
                        .setEvents(new CloseMainWindow())
                        .setText(closeStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

        hideButton =
                ButtonWrapper.newBuilder()
                        .setFont(fs)
                        .setFontSize(fontHeight)
                        .setEvents(new HideWindow())
                        .setWidth(width)
                        .setHeight(height)
                        .setInsects(padding)
                        .setCoordinate(new Coordinate(topMatgin, width + width, null, null))
                        .setCSSid(CSSID.TOP_CONTROL_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(windowAbstraction.getPrimaryStage())
                        .setText(hideStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

        maximazeButton =
                ButtonWrapper.newBuilder()
                        .setFont(fs)
                        .setFontSize(fontHeight)
                        .setEvents(new MaximazingSwither())
                        .setWidth(width)
                        .setHeight(height)
                        .setInsects(padding)
                        .setCoordinate(new Coordinate(topMatgin, width, null, null))
                        .setCSSid(CSSID.TOP_CONTROL_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(windowAbstraction.getPrimaryStage())
                        .setText(maximazeStr)
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();

    }
}
