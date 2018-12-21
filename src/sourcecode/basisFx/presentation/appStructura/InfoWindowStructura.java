package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.TextAreaWrapper;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;

public class InfoWindowStructura extends GuiStructura {
    @Override
    public void init() {

//        TextAreaWrapper textAreaWrapper=TextAreaWrapper.newBuilder()
//                .setParentAnchor(windowAbstraction.getRoot())
//                .setCoordinate( new Coordinate(10d,80d,10d,10d))
//                .setFont(FontsStore.ROBOTO_LIGHT)
//                .setFontSize(25d)
//                .setText("messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagev")
//                .setCssid(CSSID.PopupTextArea)
//                .build();

        AnchorWrapper titleAnchor = AnchorWrapper.newBuilder()
                .setHeight(45d)
                .setParentAnchor(windowAbstraction.getRoot())
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setEvents(new StageDragging())
                .setStage(windowAbstraction.getStage())
                .build();

        AnchorWrapper contentAnchor = AnchorWrapper.newBuilder()
                .setHeight(45d)
                .setParentAnchor(windowAbstraction.getRoot())
                .setCoordinate(new Coordinate(45d, 5d, 5d, 5d))
                .build();
//
//        popupMessageTextPanel =  (AnchorPane) AppNode.NodeBuilder.create()
//                .setId(CSSID.popupMessageTextPanel)
//                .setCoordinate(new Coordinate(10d,40d,10d,10d))
//                .setHeight(height)
//                .setParent(popupContentPanel.getPanel())
//                .createAnchorPanelWrapper().getElement();
//
//        textFabric.createLabel(
//                title,CSSID.PopupTitleText,
//                FontsStore.ROBOTO_BOLD,  Pos.CENTER_LEFT,23d,
//                popupTitlePanel.getPanel(),
//                new Coordinate(10d,0d,null,10d)
//        );
//
//        // icon
//        textFabric.createText(
//                "  \uF06A ", CSSID.ALERT_ICON,
//                FontsStore.FAWESOME5SOLID,50d,
//                popupContentPanel.getPanel(),
//                new Coordinate(10d,-10d,null,null)
//        );





    }
}
