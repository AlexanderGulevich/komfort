/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.domainModel.settings.StylesPathes;
import javafx.scene.Scene;

/**
 *
 * @author Alek
 */
public class StylesLodingStore {

    public StylesLodingStore(Scene scene) {
        
        
      StylesLoader.load(scene, StylesPathes.MAIN);
      StylesLoader.load(scene, StylesPathes.BUTTONS);
      StylesLoader.load(scene, StylesPathes.PANES);
      StylesLoader.load(scene, StylesPathes.TABLES);
      StylesLoader.load(scene, StylesPathes.MENUS);
      StylesLoader.load(scene, StylesPathes.WINDOWS);
      StylesLoader.load(scene, StylesPathes.MENU_BAR);
      StylesLoader.load(scene, StylesPathes.LEFT_SIDE_MENU);
        
        
    }
    
}
