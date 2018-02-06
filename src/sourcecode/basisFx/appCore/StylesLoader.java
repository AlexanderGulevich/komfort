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
    
 
    
}
