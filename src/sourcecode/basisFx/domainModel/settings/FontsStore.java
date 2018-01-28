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
public enum FontsStore {
    
    FAWESOME5REGULAR("/res/font/FontAwesome5Free-Regular-400.otf"),
    FAWESOME5SOLID("/res/font/FontAwesome5Free-Solid-900.otf"),
    WEBHOSTINGHUB("/res/font/webhostinghub-glyphs.ttf"),
    MARGOT("/res/font/Margot.ttf"),
    MATERIAL_ICONS("/res/font/MaterialIcons-Regular.ttf"),
    ROBOTO("/res/font/Roboto-Bold.ttf"),
    FIRA_BOLD("/res/font/FiraSans-Bold.ttf");
    

    
    private final String path;

    private FontsStore(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    
 
}
