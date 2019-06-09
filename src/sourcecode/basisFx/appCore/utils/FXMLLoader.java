package basisFx.appCore.utils;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FXMLLoader {
    public static AnchorPane loadAnchorPane(String fxmlName){

        Parent parent = getParent(fxmlName);
        if (parent == null) throw new NullPointerException();
        return (AnchorPane) parent;
    }
    public static Button loadButton(String fxmlName){

        Parent parent = getParent(fxmlName);
        return (Button) parent;
    }


    private static Parent getParent(String fxmlName) {
        if (!fxmlName.contains(".fxml")) fxmlName+=".fxml";
        String elementPath = System.getProperty("user.dir") + "/"+"/src/res/res/fxml/"+fxmlName;
        elementPath = elementPath.replace("\\","/");
        File f = new File(elementPath);
//
        boolean directory = f.isDirectory();
        boolean absolute = f.isAbsolute();
        boolean file1 = f.isFile();
        boolean hidden = f.isHidden();

        URL url=null;
        Parent parent=null;
        File file=new File(elementPath);


        try {
            url = file.toURI().toURL();
            parent = javafx.fxml.FXMLLoader.load(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }
}
