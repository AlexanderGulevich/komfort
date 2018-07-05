/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;

import basisFx.appCore.settings.StylesPathes;
import javafx.scene.Scene;
import java.io.File;

public class CSSHandler {

        private static CSSHandler instanse;
        private static Scene scene;
        private static StylesPathes stylesPathe;

    public static CSSHandler getInstanse(){

        if(instanse==null) {
            instanse=new CSSHandler();
        }else{
             return instanse;
        }
        return instanse;
    }

    public static void init(StylesPathes pathes) {
        stylesPathe =pathes;
    }

    public void loadStylesToScene(Scene scene){

        File folder = new File(stylesPathe.getPath());
        File[] listOfFiles = folder.listFiles();


        for (File listOfFile : listOfFiles) {

                scene.getStylesheets().add(getClass().getResource(
                        listOfFile.getPath()
                ).toExternalForm());

        }


    }
    

    
 
    
}
