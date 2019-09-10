package basisFx.appCore.utils;

import java.io.File;

public class FileUtils {


    public static void fileChecking(File file){

        boolean directory = file.isDirectory();
        boolean absolute = file.isAbsolute();
        boolean isfile = file.isFile();
        boolean hidden = file.isHidden();

    }
}
