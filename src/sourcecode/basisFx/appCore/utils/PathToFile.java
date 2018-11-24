package basisFx.appCore.utils;

public class PathToFile {
    public  static String getPath(String str){
        String path = "file:/" + System.getProperty("user.dir") + str;
        path=path.replace("\\","/");
        return path;

    }
}
