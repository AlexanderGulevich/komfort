/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;

import basisFx.appCore.settings.StylesPathes;
import javafx.scene.Scene;
import java.io.File;
import java.net.URI;

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

        URI uri=null;
        File folder=null;
        File[] listOfFiles=null;

        String path = System.getProperty("user.dir") + "/"+stylesPathe.getPath();
        path = path.replace("\\","/");
        folder = new File(path);
        listOfFiles = folder.listFiles();
//
            boolean directory = folder.isDirectory();
            boolean absolute = folder.isAbsolute();
            boolean file = folder.isFile();
            boolean hidden = folder.isHidden();


        addtStylesheetsToSceen(scene, listOfFiles);


    }

    private void addtStylesheetsToSceen(Scene scene, File[] listOfFiles) {
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                String fileName = listOfFile.getName();
                File parentFolder = listOfFile.getParentFile();

                scene.getStylesheets().addAll(PathToFile.getPath("/src/res/res/css/"+parentFolder.getName()+"/"+fileName));

            }
        }
    }


}
