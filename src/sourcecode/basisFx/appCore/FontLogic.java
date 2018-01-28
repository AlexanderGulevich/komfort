/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.appCustomLogic.settings.FontsStore;
import java.io.InputStream;
import javafx.scene.text.Font;

/**
 *
 * @author Alek
 */
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
        
    
  
    
    public  Font loadFont(FontsStore fs, double size){
        
        InputStream is=getClass().getResourceAsStream(fs.getPath());
        
        Font f=Font.loadFont(is, size);
        
        if(f!=null ){
         
                     return f;
                    
            
        }else{
        
             throw new NullPointerException("setFont()- null after loading  in FontLogic.loadFont()"); 
        
        }
        
      

    }
    
    

    
}
