package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TextAreaWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

public class InfoWindowStructura extends GUIStructura {
    public  enum Structura {
        titleAnchor,
        contentAnchor,
        messageTextAnchor,
        textArea,
        label,
        iconText
    }
    @Override
    public void init(WindowAbstraction window) {

        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setMetaName(Structura.titleAnchor.name())
                .setHeight(45d)
                .setParentAnchor(window.getRoot())
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setEvents(new StageDragging())
                .setStage(window.getStage())
                .build();

         AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                 .setMetaName(Structura.contentAnchor.name())
                .setHeight(145d)
                .setParentAnchor(window.getRoot())
                .setCoordinate(new Coordinate(45d, 5d, 5d, 5d))
                .build();

         AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setMetaName(Structura.messageTextAnchor.name())
                .setCSSid(CSSid.popupMessageTextPanel)
                .setHeight(100d)
                .setParentAnchor(((AnchorPane) window.getAppNode("contentAnchor").getElement()))
                .setCoordinate(new Coordinate(10d,80d,10d,10d))
                .build();

         TextAreaWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setParentAnchor(((AnchorPane) window.getAppNode("messageTextAnchor").getElement()))
                .setIsWrapText(true)
                .setCoordinate( new Coordinate(10d,10d,10d,10d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(25d)
                .setIsEditable(false)
                .setMetaName(Structura.textArea.name())
                .setCSSid(CSSid.PopupTextArea)
                .build();

         LabelWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setMetaName(Structura.label.name())
                .setCSSid(CSSid.PopupTitleText)
                .setFontSize(30d)
                .setFont(FontsStore.ROBOTO_BOLD)
                .setAlignment(Pos.CENTER_LEFT)
                .setCoordinate(new Coordinate(10d,0d,null,10d))
                 .setParentAnchor(((AnchorPane) window.getAppNode("titleAnchor").getElement()))
                .build();

         TextWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setMetaName(Structura.iconText.name())
                .setText( "  \uF06A ")
                .setCSSid(CSSid.ALERT_ICON)
                .setFont( FontsStore.FAWESOME5SOLID)
                .setFontSize(50d)
                .setCoordinate(new Coordinate(60d, 4d,null,null))
                .setParentAnchor(window.getTopVisibleAnchor())
                .build();

    }
}
