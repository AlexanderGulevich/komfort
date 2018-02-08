/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.settings;

/**
 *
 * @author Alek
 */
public enum CSSID {
    
    TOP_CONTROL_BUTTON("TOP_CONTROL_BUTTON"),
    MAIN_CONTENT_ANCHOR("MAIN_CONTENT_ANCHOR"),
    VISIBLE_ROOT("VISIBLE_ROOT"),
    MENUS("MENUS"),
    MAIN_MENU("MAIN_MENU"),
    TRANSPARENT_ROOT("TRANSPARENT_ROOT"),
    ROOT_TEXT_ICON("ROOT_TEXT_ICON"),
    TITLE_WINDOW_TEXT("TITLE_WINDOW_TEXT"),
    TITLE_WINDOW_IMG("TITLE_WINDOW_IMG"),
    TITLE_PANEL("TITLE_PANEL"),
    LEFT_SIDE_MENU_ROOT("LEFT_SIDE_MENU_ROOT"),
    LEFT_SIDE_MENU_TEXT("LEFT_SIDE_MENU_TEXT"),
    LEFT_SIDE_MENU_ICON_PANEL("LEFT_SIDE_MENU_ICON_PANEL"),
    LEFT_SIDE_MENU_ICON("LEFT_SIDE_MENU_ICON"),
    LEFT_SIDE_MENU_ICON_TEXT("LEFT_SIDE_MENU_ICON_TEXT"),
    LEFT_SIDE_MENU_ICON_TEXT_PANEL("LEFT_SIDE_MENU_ICON_TEXT_PANEL"),
    LEFT_SIDE_MENU_NAMES_PANEL("LEFT_SIDE_MENU_NAMES_PANEL"),
    TOP_ICON_PANEL("TOP_ICON_PANEL");
    
    
    
    

    private final String id;

    private CSSID(String id) {
        this.id = id;
    }

    public String get() {
        return id;
    }
    

    
}
