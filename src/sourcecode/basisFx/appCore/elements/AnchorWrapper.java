/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.MaximazingManager;
import basisFx.appCore.MaximazingObserver;
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
//
//            element.prefWidthProperty()
//                    .bind(parentAnchor.widthProperty().multiply(widthPerCent));



        }
// else {

            if (this.height != null) {
                element.setPrefHeight(this.height);
            }
            if (this.width != null) {
                element.setPrefWidth(this.width);
            }
//        }
        
        if(dropShadow!=null)element.setEffect(dropShadow);
        if(insects!=null)element.setPadding(insects);

        
    }

    @Override
    public void pervormMaximazingEventNotifier() {
        if (parentAnchor!=null && widthPerCent!=null) {
            System.err.println("AnchorWrapper.pervormMaximazingEventNotifier".toUpperCase());
            AnchorPane element=(AnchorPane) this.element;


            element.prefWidthProperty()
                    .bind(parentAnchor.widthProperty().multiply(widthPerCent));


//            BigDecimal parentWidth=BigDecimal.valueOf(parentAnchor.getPrefWidth());
//            BigDecimal divisor=BigDecimal.valueOf(widthPerCent);
//            element.prefWidth( parentWidth.divide(divisor,3).doubleValue());

            BigDecimal parentWidth=BigDecimal.valueOf(parentAnchor.widthProperty().doubleValue());


//
//
//            BigDecimal percent=BigDecimal.valueOf(widthPerCent);
////            element.setPrefWidth( parentWidth.divide(divisor,3).doubleValue());
//            element.setPrefWidth( parentWidth.multiply(percent).doubleValue());


            System.out.println("//////////////////////////////////////////// \n" +"//////////////////////////////////////////// \n" +
                            "parentAnchor---"+parentAnchor+"--widthPerCent---"+widthPerCent+ "\n"+
                    "parentAnchor.getWidth()----"+parentAnchor.getWidth()  + "\n"+
                    "parentAnchor.widthProperty().get()------"+parentAnchor.widthProperty().get() + "\n"+
                    "parentAnchor.getPrefWidth()------"+parentAnchor.getPrefWidth()
                    + "\n"+ "\n"+
                    "element.getWidth()-------- "+element.getWidth()       + "\n"+
                    "element.widthProperty().get()-------- "+element.widthProperty().get()    + "\n"+
                    "element.getPrefWidth()-------- "+element.getPrefWidth()      + "\n"+
                    "//////////////////////////////////////////// \n"+"//////////////////////////////////////////// \n"



            );

//            System.out.println("getPrefWidth----"+element.getPrefWidth());


        }
    }


}
