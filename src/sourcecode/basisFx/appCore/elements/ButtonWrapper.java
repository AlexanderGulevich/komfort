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
public class ButtonWrapper <T extends Node>extends AppNode{
    
//    private boolean isActive;
 
    
    
    
    public ButtonWrapper(NodeBuilder builder) {
       
        element =new Button();
        Button but=(Button) this.element;
        
        
        
        
        init(builder);
        
        
       
        if(this.height!=null) {
            but.setPrefHeight(this.height);
        }
        if(this.width!=null) {
            but.setPrefWidth(this.width);
        }
        

        if(insects!=null){
            but.setPadding(insects);
        }
        if(font!=null) {
            but.setFont(font);
        }
        if(this.text!=null) {
            but.setText(this.text);
        }
   
        
//        
        if(this.maxHeight!=null)but.setMaxHeight(this.maxHeight);
//        
        if(this.maxWidth!=null)but.setMaxWidth(this.maxWidth);
        
        if(this.minHeight!=null)but.setMinHeight(this.minHeight);
//        
        if(this.minWidth!=null)but.setMinWidth(this.minWidth);
   
        
    }

    public ButtonWrapper setGraphics(Node n, ContentDisplay cd){
        
        Button element=(Button) this.element;
    
        element.setGraphic(n);
        element.setContentDisplay(cd);
        
        return this;
        
        
    }
    
    public ButtonWrapper setGraphics(NText n, ContentDisplay cd){
        
        Button element=(Button) this.element;
    
        element.setGraphic((Text)n.getElement());
        element.setContentDisplay(cd);
        
        return this;
    }
    
    public ButtonWrapper setString(String str, ContentDisplay cd){
        
        
        Button element=(Button) this.element;
        
       
        element.setText(str);
        element.setContentDisplay(cd);
        
        return this;
    }
//
//    public NButton setIsActive(boolean isActive) {
//        this.isActive = isActive;
//        return this;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }
//    
//    
//    
    

   

    
   
    
    
    
    
    
}
