/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;


import basisFx.appCore.settings.StylesPathes;
import javafx.scene.Scene;

/**
 *
 * @author Alek
 */
public class CSSHandler {


    //todo переделать в комманду или стратегию
        private static CSSHandler instanse;
        private static Scene scene;
        private static StylesPathes stylesPathes;

    private static CSSHandler getInstanse(){
        
        if(instanse==null) {
            instanse=new CSSHandler();
        }else{
             return instanse;
        }
        return instanse;
    }

    public static void setScene(Scene scene) {
        CSSHandler.scene = scene;
    }

    public static void init(StylesPathes pathes) {
        stylesPathes=pathes;
    }


    private void load(Scene scene, StylesPathes st){
    
        scene.getStylesheets().add(getClass().getResource(
              st.get()
      ).toExternalForm());
    }
    

    public static void loadAll(Scene scene) {

        StylesPathes[] values = StylesPathes.values();

        for (StylesPathes value : values) {
            getInstanse().load(scene, value);
        }



    }
    
    
 
    
}
