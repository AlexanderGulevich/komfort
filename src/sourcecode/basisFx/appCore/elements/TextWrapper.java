/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.Node;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class TextWrapper<T extends Node> extends AppNode{

    public TextWrapper(NodeBuilder builder) {
        
        this.element=new Text();
        
        Text text=(Text) this.element;

        
        init(builder);

        text.setFont(font);
        text.setText(string);
        text.setId(id);

     
       }

  

   
    
   
    
    
    
    
    
}
