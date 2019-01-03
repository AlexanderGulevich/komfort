/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;

import basisFx.appCore.settings.FontsStore;
import javafx.scene.text.Font;

public class FontLogic {
    

    
    private static FontLogic instance;
    
    private FontLogic() {}
    
    public static FontLogic run() {
        
        if(instance==null) {
            instance=new FontLogic();
        }else{
             return instance;
        }
        return instance;
    }
        
    
  
    
    public static Font loadFont(FontsStore fs, double size){


        String path = "file:/" + System.getProperty("user.dir") + "/src/res/"+fs.getPath();
        path=path.replace("\\","/");
        Font f=Font.loadFont(path, size);
        
        if(f!=null ){
                     return f;
        }else{
        
             throw new NullPointerException("setFont()- null after loading  in FontLogic.loadFont()"); 
        
        }
        
      

    }
    
    

    
}
