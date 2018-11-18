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
//        File folder = new File(stylesPathe.getPath());
//        try {
            Path path = Paths.get(stylesPathe.getPath());
            path.getRoot();
//            uri = getClass().getResource(stylesPathe.getPath()).toURI();
//            uri = getClass().getResource("").toURI();
            URL resource = getClass().getResource(stylesPathe.getPath());
        try {
            URI uri1 = resource.toURI();
            System.err.println("1111111111111111---"+uri1.toString().toUpperCase());
            folder = new File(uri1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//            folder = new File(resource);
//            folder = new File(uri);
            listOfFiles = folder.listFiles();
//
            boolean directory = folder.isDirectory();
            boolean absolute = folder.isAbsolute();
            boolean file = folder.isFile();
            boolean hidden = folder.isHidden();


//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        ArrayList <String>stylePathes=new ArrayList<>();


        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                String fileName = listOfFile.getName();
                File parentFolder = listOfFile.getParentFile();

//                scene.getStylesheets().add(getClass().getResource(
//                        listOfFile.getPath()
//                ).toExternalForm());


                scene.getStylesheets().addAll("/res/css/"+parentFolder.getName()+"/"+fileName);

            }
        }


    }
    

    
 
    
}
