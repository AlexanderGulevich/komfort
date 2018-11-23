/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;

import basisFx.appCore.settings.StylesPathes;
import javafx.scene.Scene;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

        String stringPath = System.getProperty("user.dir") + "/"+stylesPathe.getPath();
        stringPath=stringPath.replace("\\","/");
        folder = new File(stringPath);
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

                String path = "file:/" + System.getProperty("user.dir") + "/src/res/res/css/"+parentFolder.getName()+"/"+fileName;
                path=path.replace("\\","/");
                scene.getStylesheets().addAll(path);

            }
        }
    }


}
