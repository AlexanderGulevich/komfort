package basisFx.appCore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathesResearch {
    public PathesResearch() {

        System.err.println("System.getProperty(\"user.dir\")-----"+System.getProperty("user.dir").toUpperCase());
        System.err.println("File.separator-----"+File.separator.toUpperCase());
        System.err.println("File.pathSeparator-----"+File.pathSeparator.toUpperCase());
        System.err.println("Paths.get(\"\")-----"+ Paths.get(""));
        System.err.println("Paths.get(\"res\")-----"+ Paths.get("res"));

        Path path = Paths.get("src", "res","res", "css", "custom_1", "windows.css");
        System.err.println(path);

        String str =null;
        try {
            str = path.toUri().toURL().toExternalForm();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            InputStream inputStream= new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(path);


    }
}
