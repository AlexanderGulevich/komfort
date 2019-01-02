package basisFx.appCore.windows;


import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.ClosePopupAndSubWindow;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;

public class ButtonsForStageSingle extends ButtonsForStage {

    private String closeStr="";
    private double fontHeight= 20d;
    private double topMatgin=4d;
    private double height=30d;
    private double width=30d;
    private Insets padding=new Insets(0d, 0d, 0d, 0d);
    private FontsStore fs=FontsStore.FAWESOME5SOLID;

    public ButtonsForStageSingle(WindowAbstraction windowAbstraction) {
        super(windowAbstraction);
        init();
    }

    @Override
    protected void init() {
        AnchorPane parentAnchor;
        AppNode titleNode = windowAbstraction.getNode("titleAnchor");
        if (titleNode != null) {
            parentAnchor = (AnchorPane) titleNode.getElement();
        }else {
            parentAnchor=(AnchorPane) windowAbstraction.getTopVisibleAnchor();
        }



        buttonsAnchor =
                AnchorWrapper.newBuilder()
                        .setCSSid(CSSID.WindowButtonsPanel)
                        .setCoordinate( new Coordinate(0d,5d,null,null))
                        .setHeight(25d).setWidth(82d)
                        .setParentAnchor(parentAnchor)
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
                        .setCSSid(CSSID.TOP_CONTROL_SINGLE_BUTTON)
                        .setParentAnchor(buttonsAnchor)
                        .setStage(windowAbstraction.getPrimaryStage())
                        .setEvents(new ClosePopupAndSubWindow())
                        .setText(closeStr)
                        .setMetaName("closingButton")
                        .setContentDisplay(ContentDisplay.CENTER)
                        .build();
    }
}
