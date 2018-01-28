/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCustomLogic.settings;

import java.util.logging.Logger;

/**
 *
 * @author Alek
 */
public enum CSSID {
    
    TOP_CONTROL_BUTTON("TOP_CONTROL_BUTTON"),
    MAIN_CONTENT_ANCHOR("MAIN_CONTENT_ANCHOR"),
    INNER_ROOT("INNER_ROOT"),
    MENUS("MENUS"),
    MAIN_MENU("MAIN_MENU"),
    TRANSPARENT_ROOT("TRANSPARENT_ROOT"),
    ROOT_TEXT_ICON("ROOT_TEXT_ICON"),
    TITLE_WINDOW_TEXT("TITLE_WINDOW_TEXT");

    private final String id;

    private CSSID(String id) {
        this.id = id;
    }

    public String get() {
        return id;
    }
    

    
}
