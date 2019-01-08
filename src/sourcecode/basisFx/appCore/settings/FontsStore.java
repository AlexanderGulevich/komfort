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


    FAWESOME5REGULAR("/res/fonts/Font-Awesome-5-Free-Regular-400.ttf"),
    FAWESOME5SOLID("/res/fonts/Font-Awesome-5-Free-Solid-900.ttf"),
    WEBHOSTINGHUB("/res/fonts/webhostinghub-glyphs.ttf"),
    fontcustom("/res/fonts/foundation-icons.ttf"),
    IONICONS("/res/fonts/ionicons.ttf"),
    THEMIFY("/res/fonts/themify.ttf"),
    BATCH("/res/fonts/batch-icons-webfont.ttf"),
    MATERIAL_ICONS("/res/fonts/MaterialIcons-Regular.ttf"),

    MARGOT("/res/fonts/Margot.ttf"),
    ROBOTO_BOLD("/res/fonts/Roboto-Bold.ttf"),
    ROBOTO_LIGHT("/res/fonts/Roboto-Light.ttf"),
    FIRA_BOLD("/res/fonts/FiraSans-Bold.ttf");
    

    
    private final String path;

    private FontsStore(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    
 
}
