/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Alek
 * @param <T>
 */
public class NFlowPane <T extends Node> extends AppNode{

    public NFlowPane(NodeBuilder builder) {
        
        element=new FlowPane();
        FlowPane element=(FlowPane) this.element;
        
        init(builder);
        

        element.setPrefSize(width, height);
        if(dropShadow!=null)element.setEffect(dropShadow);
        if(insects!=null)element.setPadding(insects);

    }


    

}
