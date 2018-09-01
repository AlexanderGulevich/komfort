package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.FlowPaneWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;

public class LeftAndTopMenuGuiStructura extends GuiStructura {

    public void init(){

        AnchorWrapper contentAnchorWrapper = AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(80d, 0d, 0d, 60d))
                .setParentAnchor(window.getTopVisibleAnchor())
                .setCssid(CSSID.MAIN_CONTENT_ANCHOR)
                .setName("contentAnchorWrapper")
                .build();

        AnchorWrapper titleAnchorWrapper = AnchorWrapper.newBuilder()
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setParentAnchor(window.getTopVisibleAnchor())
                .setHeight(70d)
                .setStage(getStage())
                .setCssid(CSSID.TITLE_PANEL)
                .setEvents(eventFabric.stageDragging())
                .setName("titleAnchorWrapper")
                .build();

        AnchorWrapper titleImageAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(titleAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(10d, null, null, 70d))
                .setCssid(CSSID.TITLE_WINDOW_IMG)
                .setName("titleImageAnchorWrapper")
                .build();

        AnchorWrapper verticalMenuAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(window.getTopVisibleAnchor())
                .setCoordinate(new Coordinate(0d, null, 0d, 0d))
                .setWidth(60d)
                .setName("verticalMenuAnchorWrapper")
                .setCssid(CSSID.LEFT_SIDE_MENU_VERTICAL_PANEL)
                .build();

        FlowPaneWrapper horisontalMenuFlowPane = FlowPaneWrapper.newBuilder()
                .setParentAnchor(window.getTopVisibleAnchor())
                .setHeight(35d)
                .setCoordinate(new Coordinate(49d, 0d, null, 60d))
                .setCssid(CSSID.HORIZONTAL_FLOW_MENU_PANEL)
                .setName("horisontalMenuFlowPane")
                .build();

        AnchorWrapper textAnchorWrapper = AnchorWrapper.newBuilder()
                .setParentAnchor(titleAnchorWrapper.getElement())
                .setCoordinate(new Coordinate(15d, 120d, 0d, null))
                .setHeight(35d)
                .setCssid(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
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
                .setCssid(CSSID.IMG_ICON)
                .setName("iconAnchorWrapper")
                .build();

        nodes.add(contentAnchorWrapper);
        nodes.add(titleAnchorWrapper);
        nodes.add(verticalMenuAnchorWrapper);
        nodes.add(horisontalMenuFlowPane);
        nodes.add(textAnchorWrapper);
        nodes.add(iconAnchorWrapper);
        nodes.add(leftCideMenuCommonText);
        nodes.add(titleImageAnchorWrapper);

    }


}
