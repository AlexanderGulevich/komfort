/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.MaximazingManager;
import basisFx.appCore.interfaces.MaximazingObserver;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;

/**
 *
 * @author Alek
 */
public class AnchorWrapper<T extends Node> extends AppNode implements MaximazingObserver  {
    


    public AnchorWrapper(NodeBuilder builder) {
        element=new AnchorPane();
        AnchorPane element=(AnchorPane) this.element;
        
        init(builder);


        MaximazingManager.setObserver(this);


        if (parentAnchor!=null && widthPerCent!=null) {


            pervormMaximazingEventNotifier();



        }

            if (this.height != null) {
                element.setPrefHeight(this.height);
            }
            if (this.width != null) {
                element.setPrefWidth(this.width);
            }

        
        if(dropShadow!=null)element.setEffect(dropShadow);
        if(insects!=null)element.setPadding(insects);

        
    }

    @Override
    public void pervormMaximazingEventNotifier() {
        if (parentAnchor!=null && widthPerCent!=null) {

            AnchorPane element=(AnchorPane) this.element;


            element.prefWidthProperty()
                    .bind(parentAnchor.widthProperty().multiply(widthPerCent));



            BigDecimal parentWidth=BigDecimal.valueOf(parentAnchor.widthProperty().doubleValue());



        }
    }


}
