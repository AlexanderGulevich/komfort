/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

/**
 *
 * @author Alek
 */
public class TitleFabric {
    public TextTitle createTextTitle(){
    
        return new TextTitle();
        
    }
    public ImageTitle createImageTitle(){
    
        return new ImageTitle();
        
    }
}
