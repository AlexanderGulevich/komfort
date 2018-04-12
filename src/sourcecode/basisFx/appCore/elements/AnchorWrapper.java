/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class AnchorWrapper<T extends Node> extends AppNode{
    


    public AnchorWrapper(NodeBuilder builder) {
        element=new AnchorPane();
        AnchorPane element=(AnchorPane) this.element;
        
        init(builder);


        if (parentAnchor!=null && widthPerCent!=null) {

            element.prefWidthProperty()
                    .bind(parentAnchor.widthProperty().multiply(widthPerCent));

        }else {

            if (this.height != null) {
                element.setPrefHeight(this.height);
            }
            if (this.width != null) {
                element.setPrefWidth(this.width);
            }
        }
        
        if(dropShadow!=null)element.setEffect(dropShadow);
        if(insects!=null)element.setPadding(insects);

        
    }

}
