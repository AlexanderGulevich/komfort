package basisFx.appCore.utils;


import java.io.File;

public class PathToFile {
    public  static String getFilePath(String str){
        String path=null;
        switch (System.getProperty("os.name")) {
            case "Linux":  path = "file:" + System.getProperty("user.dir") + str;;
                break;
            case "Windows":  path = "file:/" + System.getProperty("user.dir") + str;;
                break;
        }
        path=path.replace("\\","/");
        return path;

    }
    public  static String getAbsolutePath(String str){
        String path=null;
        switch (System.getProperty("os.name")) {
            case "Linux":  path = System.getProperty("user.dir") + str;;
                break;
            case "Windows":  path =  System.getProperty("user.dir") + str;;
                break;
        }
        path=path.replace("\\","/");
        return path;

    }
}
