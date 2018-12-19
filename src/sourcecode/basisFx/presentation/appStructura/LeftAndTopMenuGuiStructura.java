package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.FlowPaneWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;

public class LeftAndTopMenuGuiStructura extends GuiStructura {

    public void init(){

        AnchorWrapper contentAnchorWrapper = AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(128d, 10d, 0d, 65d))
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .setCSSid(CSSID.MAIN_CONTENT_ANCHOR)
                .setName("contentAnchorPane")
                .build();

        AnchorWrapper titleAnchorWrapper = AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .setHeight(70d)
                .setStage(getStage())
                .setCSSid(CSSID.TITLE_PANEL)
                .setEvents(new StageDragging())
                .setName("titleAnchorWrapper")
                .build();

        TextWrapper companyName = TextWrapper.newBuilder()
                .setCssid(CSSID.PROGRAMM_NAME)
                .setParentAnchor(titleAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(10d, null, null, 70d))
                .setFont(FontsStore.ROBOTO_BOLD)
                .setFontSize(50)
                .setText("KOMFORT")
                .build();

//        AnchorWrapper titleImageAnchorWrapper = AnchorWrapper.newBuilder()
//                .setParentAnchor(titleAnchorWrapper.getElement())
//                .setCoordinate(new Coordinate(10d, null, null, 70d))
//                .setCSSid(CSSID.TITLE_WINDOW_IMG)
//                .setName("titleImageAnchorWrapper")
//                .build();

        AnchorWrapper verticalMenuAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .setCoordinate(new Coordinate(0d, null, 0d, 0d))
                .setWidth(60d)
                .setName("verticalMenuAnchorWrapper")
                .setCSSid(CSSID.LEFT_SIDE_MENU_VERTICAL_PANEL)
                .build();

        FlowPaneWrapper horisontalMenuFlowPane = FlowPaneWrapper.newBuilder()
                .setParentAnchor(windowAbstraction.getTopVisibleAnchor())
                .setHeight(50d)
                .setCoordinate(new Coordinate(70d, 0d, null, 65d))
                .setCssid(CSSID.HORIZONTAL_FLOW_MENU_PANEL)
                .setName("horisontalMenuFlowPane")
                .build();

        AnchorWrapper textAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(titleAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(15d, 120d, 0d, null))
                .setHeight(35d)
                .setCSSid(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
                .setName("textAnchorWrapper")
                .build();

        TextWrapper leftCideMenuCommonText = TextWrapper.newBuilder()
                .setCssid(CSSID.LEFT_SIDE_MENU_COMMON_TEXT)
                .setParentAnchor(textAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(20)
                .setName("leftCideMenuCommonText")
                .build();


        AnchorWrapper iconAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(verticalMenuAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setHeight(35d)
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(20)
                .setCSSid(CSSID.IMG_ICON)
                .setName("iconAnchorWrapper")
                .build();

        nodes.add(contentAnchorWrapper);
        nodes.add(titleAnchorWrapper);
        nodes.add(verticalMenuAnchorWrapper);
        nodes.add(horisontalMenuFlowPane);
        nodes.add(textAnchorWrapper);
        nodes.add(iconAnchorWrapper);
        nodes.add(leftCideMenuCommonText);
//        nodes.add(titleImageAnchorWrapper);
        nodes.add(companyName);

        copyToElementsStore();

    }


}
