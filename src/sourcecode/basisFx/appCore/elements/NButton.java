/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class NButton <T extends Node>extends AppNode{
    
    public NButton(NodeBuilder builder) {
        element =new Button();
        Button element=(Button) this.element;
        init(builder);
        element.setPrefSize(width, height);
        if(insects!=null)element.setPadding(insects);
        if(font!=null)element.setFont(font);
        
    }

    public NButton setGraphics(Node n, ContentDisplay cd){
        
        Button element=(Button) this.element;
    
        element.setGraphic(n);
        element.setContentDisplay(cd);
        
        return this;
        
        
    }
    
    public NButton setGraphics(NText n, ContentDisplay cd){
        
        Button element=(Button) this.element;
    
        element.setGraphic((Text)n.getElement());
        element.setContentDisplay(cd);
        
        return this;
    }
    
    public NButton setString(String str, ContentDisplay cd){
        
        
        Button element=(Button) this.element;
    
        element.setText(str);
        element.setContentDisplay(cd);
        
        return this;
    }
  

    
   
    
    
    
    
    
}
