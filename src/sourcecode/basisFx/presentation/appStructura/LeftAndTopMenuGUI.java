package basisFx.presentation.appStructura;

import basisFx.appCore.elements.AnchorWrapper;
import basisFx.appCore.elements.FlowPaneWrapper;
import basisFx.appCore.elements.TextWrapper;
import basisFx.appCore.events.StageDragging;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.layout.AnchorPane;

public class LeftAndTopMenuGUI extends GUIStructura {
    public  enum Structura {
        titleAnchor,
        companyNameText,
        verticalMenuAnchor,
        horisontalMenuFlowPane,
        textAnchor,
        leftCideMenuCommonText,
        iconAnchor
    }
    public void init(WindowAbstraction window){

        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setCoordinate(new Coordinate(128d, 10d, 0d, 65d))
                .setParentAnchor(window.getTopVisibleAnchor())
                .setCSSid(CSSID.MAIN_CONTENT_ANCHOR)
                .setMetaName(WindowAbstraction.DefaultPanelsNames.mainContentAnchor.name())
                .build();

        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setParentAnchor(window.getTopVisibleAnchor())
                .setHeight(70d)
                .setStage(window.getStage())
                .setCSSid(CSSID.TITLE_PANEL)
                .setEvents(new StageDragging())
                .setMetaName(Structura.titleAnchor.name())
                .build();

        TextWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setCssid(CSSID.PROGRAMM_NAME)
                .setParentAnchor(((AnchorPane) window.getNode("titleAnchor").getElement()))
                .setCoordinate(new Coordinate(10d, null, null, 70d))
                .setFont(FontsStore.ROBOTO_BOLD)
                .setFontSize(50)
                .setMetaName(Structura.companyNameText.name())
                .setText("KOMFORT")
                .build();

        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setParentAnchor(window.getTopVisibleAnchor())
                .setCoordinate(new Coordinate(0d, null, 0d, 0d))
                .setWidth(60d)
                .setMetaName(Structura.verticalMenuAnchor.name())
                .setCSSid(CSSID.LEFT_SIDE_MENU_VERTICAL_PANEL)
                .build();

       FlowPaneWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setParentAnchor(window.getTopVisibleAnchor())
                .setHeight(50d)
                .setCoordinate(new Coordinate(70d, 0d, null, 65d))
                .setCssid(CSSID.HORIZONTAL_FLOW_MENU_PANEL)
                .setMetaName(Structura.horisontalMenuFlowPane.name())
                .build();

        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setParentAnchor(((AnchorPane) window.getNode("titleAnchor").getElement()))
                .setCoordinate(new Coordinate(15d, 120d, 0d, null))
                .setHeight(35d)
                .setCSSid(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
                .setMetaName(Structura.textAnchor.name())
                .build();

        TextWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setCssid(CSSID.LEFT_SIDE_MENU_COMMON_TEXT)
                .setParentAnchor(((AnchorPane) window.getNode("textAnchor").getElement()))
                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(20)
                .setMetaName(Structura.leftCideMenuCommonText.name())
                .build();


        AnchorWrapper.newBuilder()
                .setWindowAbstraction(window)
                .setParentAnchor(((AnchorPane) window.getNode("verticalMenuAnchor").getElement()))
                .setCoordinate(new Coordinate(0d, 0d, null, 0d))
                .setHeight(35d)
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(20)
                .setCSSid(CSSID.IMG_ICON)
                .setMetaName(Structura.iconAnchor.name())
                .build();


    }


}
