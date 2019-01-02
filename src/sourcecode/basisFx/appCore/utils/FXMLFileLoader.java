package basisFx.appCore.utils;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FXMLFileLoader {
    public static AnchorPane load (String fxmlName){

        String stringPath = System.getProperty("user.dir") + "/"+"/src/res/res/fxml/"+fxmlName+".fxml";
        stringPath=stringPath.replace("\\","/");
        File f = new File(stringPath);
//
        boolean directory = f.isDirectory();
        boolean absolute = f.isAbsolute();
        boolean file1 = f.isFile();
        boolean hidden = f.isHidden();


        URL url=null;
        Parent parent=null;
        File file=new File(stringPath);


        try {
            url = file.toURI().toURL();
            parent = javafx.fxml.FXMLLoader.load(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return (AnchorPane) parent;
    }
}
