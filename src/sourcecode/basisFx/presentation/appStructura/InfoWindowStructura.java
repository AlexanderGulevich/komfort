package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TextAreaWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Pos;
import org.scenicview.ScenicView;

public class InfoWindowStructura extends GuiStructura {
    @Override
    public void init() {

        AnchorWrapper titleAnchor = AnchorWrapper.newBuilder()
                .setMetaName("titleAnchor")
                .setHeight(45d)
                .setParentAnchor(windowAbstraction.getRoot())
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setEvents(new StageDragging())
                .setStage(windowAbstraction.getStage())
                .build();

        AnchorWrapper contentAnchor = AnchorWrapper.newBuilder()
                .setMetaName("contentAnchor")
                .setHeight(145d)
                .setParentAnchor(windowAbstraction.getRoot())
                .setCoordinate(new Coordinate(45d, 5d, 5d, 5d))
                .build();

        AnchorWrapper messageTextAnchor  = AnchorWrapper.newBuilder()
                .setMetaName("messageTextAnchor")
                .setCSSid(CSSID.popupMessageTextPanel)
                .setHeight(100d)
                .setParentAnchor(contentAnchor.getElement())
                .setCoordinate(new Coordinate(10d,80d,10d,10d))
                .build();

        TextAreaWrapper textArea=TextAreaWrapper.newBuilder()
                .setParentAnchor(messageTextAnchor.getElement())
                .setIsWrapText(true)
                .setCoordinate( new Coordinate(10d,10d,10d,10d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(25d)
                .setIsEditable(false)
                .setMetaName("textArea")
                .setCssid(CSSID.PopupTextArea)
                .build();

        LabelWrapper label=LabelWrapper.newBuilder()
                .setMetaName("label")
                .setCssid(CSSID.PopupTitleText)
                .setFontSize(30d)
                .setFont(FontsStore.ROBOTO_BOLD)
                .setAlignment(Pos.CENTER_LEFT)
                .setCoordinate(new Coordinate(10d,0d,null,10d))
                .setParentAnchor(titleAnchor.getElement())
                .build();

        TextWrapper iconText=TextWrapper.newBuilder()
                .setMetaName("iconText")
                .setText( "  \uF06A ")
                .setCssid(CSSID.ALERT_ICON)
                .setFont( FontsStore.FAWESOME5SOLID)
                .setFontSize(50d)
                .setCoordinate(new Coordinate(60d, 10d,null,null))
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .build();


        windowAbstraction.setNod(titleAnchor);
        windowAbstraction.setNod(contentAnchor);
        windowAbstraction.setNod(messageTextAnchor);
        windowAbstraction.setNod(textArea);
        windowAbstraction.setNod(label);
        windowAbstraction.setNod(iconText);


//        ScenicView.show(windowAbstraction.getScene());



    }
}
