package basisFx.appCore.appStructura;

import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.windows.Panel;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.Window;

public class LeftAndTopMenuUndecorated extends GuiStructura {

    private Panel contentPanel;
    private Panel titlePanel;
    private Panel windowButtonsPanel;
    private Panel verticalMenuPanel;
    private Panel horisontalMenuPanel;
    private Panel textAnchorPanel;
    private Panel iconAnchorPanel;
    private Panel titleImage;


    public void init(){

        contentPanel= Panel.PanelBuilder.create()
                .setCoordinate(new Coordinate(80d,0d,0d,60d))
                .setParent(window.getTopVisiblePanel())
                .setCssid(CSSID.MAIN_CONTENT_ANCHOR)
                .setName("contentPanel")
                .build();


        titlePanel=Panel.PanelBuilder.create()
                .setCoordinate(new Coordinate(0d,0d,null,0d))
                .setParent(window.getTopVisiblePanel())
                .setHeight(70d)
                .setCssid(CSSID.TITLE_PANEL)
                .setEvent(eventFabric.stageDragging())
                .setName("titlePanel")
                .build();


        titleImage=Panel.PanelBuilder.create()
                .setParent(titlePanel.getPanel())
//                .setCoordinate(new Coordinate(0d, 0d, 0d, 0d))
                .setCoordinate(new Coordinate(10d, null, null, 70d))
                .setCssid(CSSID.TITLE_WINDOW_IMG)
                .setName("titleImage")
                .build();


        verticalMenuPanel=Panel.PanelBuilder.create()
                .setParent(window.getTopVisiblePanel())
                .setCoordinate(new Coordinate(0d,null,0d,0d))
                .setWidth(60d)
                .setName("verticalMenuPanel")
                .setCssid(CSSID.LEFT_SIDE_MENU_VERTICAL_PANEL)
                .build();

        horisontalMenuPanel=Panel.PanelBuilder.create()
                .setParent(window.getTopVisiblePanel())
                .setHeight(35d)
                .setCoordinate(new Coordinate(49d,0d,null,60d))
                .setCssid(CSSID.HORIZONTAL_FLOW_MENU_PANEL)
                .setName("horisontalMenuPanel")
                .build();

        textAnchorPanel=Panel.PanelBuilder.create()
                .setParent(titlePanel.getPanel())
                .setCoordinate( new Coordinate(15d, 120d, 0d, null))
                .setHeight(35d)
                .setCssid(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
                .setName("textAnchorPanel")
                .build()
                .createInsideTextLayer(FontsStore.ROBOTO_LIGHT, 20);

        iconAnchorPanel=Panel.PanelBuilder.create()
                .setParent(verticalMenuPanel.getPanel())
                .setCoordinate(  new Coordinate(0d, 0d, null, 0d))
                .setHeight(35d)
                .setFont(FontsStore.ROBOTO_LIGHT, 20)
                .setCssid(CSSID.IMG_ICON)
                .setName("iconAnchorPanel")
                .build();

        panels.add(contentPanel);
        panels.add(titlePanel);
        panels.add(windowButtonsPanel);
        panels.add(verticalMenuPanel);
        panels.add(horisontalMenuPanel);
        panels.add(textAnchorPanel);
        panels.add(iconAnchorPanel);
        panels.add(titleImage);

    }


}
