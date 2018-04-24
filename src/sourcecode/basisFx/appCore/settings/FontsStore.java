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
public enum FontsStore {


    FAWESOME5REGULAR("/res/font/Font-Awesome-5-Free-Regular-400.ttf"),
    FAWESOME5SOLID("/res/font/Font-Awesome-5-Free-Solid-900.ttf"),
    WEBHOSTINGHUB("/res/font/webhostinghub-glyphs.ttf"),
    FOUNDATION("/res/font/foundation-icons.ttf"),
    IONICONS("/res/font/ionicons.ttf"),
    THEMIFY("/res/font/themify.ttf"),
    BATCH("/res/font/batch-icons-webfont.ttf"),
    MATERIAL_ICONS("/res/font/MaterialIcons-Regular.ttf"),

    MARGOT("/res/font/Margot.ttf"),
    ROBOTO_BOLD("/res/font/Roboto-Bold.ttf"),
    ROBOTO_LIGHT("/res/font/Roboto-Light.ttf"),
    FIRA_BOLD("/res/font/FiraSans-Bold.ttf");
    

    
    private final String path;

    private FontsStore(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    
 
}
