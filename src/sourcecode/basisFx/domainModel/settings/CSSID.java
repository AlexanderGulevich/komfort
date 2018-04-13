package basisFx.domainModel.settings;

public enum CSSID {
    
    TOP_CONTROL_BUTTON("TOP_CONTROL_BUTTON"),
    MAIN_CONTENT_ANCHOR("MAIN_CONTENT_ANCHOR"),
    VISIBLE_ROOT("VISIBLE_ROOT"),
    PRELOADER_VISIBLE_ROOT("PRELOADER_VISIBLE_ROOT"),
    MENUS("MENUS"),
    TABLE("TABLE"),
    COMBOBOX("COMBOBOX"),
    PANELS_BUTTON("PANELS_BUTTON"),
    TARGET_PANEL("TARGET_PANEL"),
    MAIN_MENU("MAIN_MENU"),
    TRANSPARENT_ROOT("TRANSPARENT_ROOT"),
    PRELOADER_TRANSPARENT_ROOT("PRELOADER_TRANSPARENT_ROOT"),
    TEXT_ICON_ANCHOR("TEXT_ICON_ANCHOR"),
    TITLE_WINDOW_TEXT("TITLE_WINDOW_TEXT"),
    TITLE_WINDOW_IMG("TITLE_WINDOW_IMG"),
    TITLE_PANEL("TITLE_PANEL"),
    TILE_PANE("TILE_PANE"),
    TILE_PANE_ANCHOR("TILE_PANE_ANCHOR"),

    LABEL_TEXT("LABEL_TEXT"),
    INNER_PANE("INNER_PANE"),

    LEFT_SIDE_MENU_ROOT("LEFT_SIDE_MENU_ROOT"),
    LEFT_SIDE_MENU_TEXT("LEFT_SIDE_MENU_TEXT"),
    LEFT_SIDE_MENU_VERTICAL_PANEL("LEFT_SIDE_MENU_VERTICAL_PANEL"),
    LEFT_SIDE_MENU_HORIZONTAL_BUTTONS("LEFT_SIDE_MENU_HORIZONTAL_BUTTONS"),
    LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED("LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED"),
    LEFT_SIDE_MENU_VERTICAL_BUTTONS("LEFT_SIDE_MENU_VERTICAL_BUTTONS"),
    LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED("LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED"),
    LEFT_SIDE_MENU_COMMON_TEXT("LEFT_SIDE_MENU_COMMON_TEXT"),
    LEFT_SIDE_MENU_TEXT_PANEL("LEFT_SIDE_MENU_TEXT_PANEL"),
    HORIZONTAL_FLOW_MENU_PANEL("HORIZONTAL_FLOW_MENU_PANEL"),
    
    IMG_ICON("IMG_ICON"),
    HEAD_PANEL("HEAD_PANEL");
    
    
    
    

    private final String id;

    private CSSID(String id) {
        this.id = id;
    }

    public String get() {
        return id;
    }
    

    
}
