/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 *
 * @author Alek
 */
public  class LabelWrapper extends AppNode{

    private Label label=new Label();


    public LabelWrapper(NodeBuilder builder) {
        element=label;
        init(builder);



        label.setAlignment(pos);
        label.setFont(font);
        label.setText(string);
        label.setId(id);


    }
}
