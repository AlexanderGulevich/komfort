/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCustomLogic.settings.WindowsTitlesNames;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class NText <T extends Node> extends AppNode{

    public NText(NodeBuilder builder) {
        
        this.element=new Text();
        
        Text element=(Text) this.element;
        
        init(builder);
        
        element.setFont(font);
        element.setText(text);

     
       }

  

   
    
   
    
    
    
    
    
}
