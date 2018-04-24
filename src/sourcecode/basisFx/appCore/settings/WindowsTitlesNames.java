/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.settings;

/**
 *
 * @author 62
 */
public enum WindowsTitlesNames {
    
        
    MAIN_WINDOW_NAME("KOMFORT");

    private final String name;

    private WindowsTitlesNames(String id) {
        this.name = id;
    }

    public String get() {
        return name;
    }
    
    
    
}
