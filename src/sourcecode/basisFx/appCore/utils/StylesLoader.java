/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;


import basisFx.domainModel.settings.StylesPathes;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author Alek
 */
public class StylesLoader {
    
    private static StylesLoader instanse;
    
    private static StylesLoader getInstanse(){
        
        if(instanse==null) {
            instanse=new StylesLoader();
        }else{
             return instanse;
        }
        return instanse;
    }
    
    
    private void loadNonStatic(Scene scene,StylesPathes st){
    
        scene.getStylesheets().add(getClass().getResource(
              st.get()
      ).toExternalForm());
    }
    
    public static void load(Scene scene,StylesPathes st){
    
      getInstanse().loadNonStatic(scene, st);
        
    }
    
    public static void loadAll(Scene scene) {

//        List<Enum> enumValues =
//                new ArrayList<Enum>(EnumSet.allOf(StylesPathes.class));


        StylesPathes[] values = StylesPathes.values();

        for (StylesPathes value : values) {
            StylesLoader.load(scene, value);
        }


//
//        StylesLoader.load(scene, StylesPathes.MAIN);
//        StylesLoader.load(scene, StylesPathes.BUTTONS);
//        StylesLoader.load(scene, StylesPathes.PANELS);
//        StylesLoader.load(scene, StylesPathes.TABLES);
//        StylesLoader.load(scene, StylesPathes.MENUS);
//        StylesLoader.load(scene, StylesPathes.WINDOWS);
//        StylesLoader.load(scene, StylesPathes.MENU_BAR);
//        StylesLoader.load(scene, StylesPathes.SCROLLBAR);
//        StylesLoader.load(scene, StylesPathes.COMBOBOX);
//        StylesLoader.load(scene, StylesPathes.LEFT_SIDE_MENU);


    }
    
    
 
    
}
