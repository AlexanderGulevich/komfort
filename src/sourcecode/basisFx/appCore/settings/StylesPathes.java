/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.settings;

/**
 *
 * @author Alek
 */
public enum StylesPathes {
    
    MAIN("/res/css/styles.css"),
    BUTTONS("/res/css/buttons.css"),
    PANELS("/res/css/panels.css"),
    TABLES("/res/css/tables.css"),
    SCROLLBAR("/res/css/scrollbar.css"),
    MENUS("/res/css/menus.css"),
    MENU_BAR("/res/css/menuBar.css"),
    LEFT_SIDE_MENU("/res/css/leftSideMenu.css"),
    COMBOBOX("/res/css/combobox.css"),
    DATAPICKER("/res/css/dataPicker.css"),
    WINDOWS("/res/css/windows.css"),
    POPUP("/res/css/popup.css");


    private final String path;

    private StylesPathes(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }
    
  
  
  
}
