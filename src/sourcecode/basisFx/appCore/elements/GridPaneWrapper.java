/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alek
 */
public abstract class GridPaneWrapper extends AppNode{


    public GridPaneWrapper(NodeBuilder builder) {
        element=new GridPane();
        GridPane gridPane=(GridPane) this.element;


        gridPane.addColumn(1,new AnchorPane());
        gridPane.setPrefWidth(width);
        gridPane.setGridLinesVisible(true);

        gridPane.getColumnConstraints().add(new ColumnConstraints(100));

        init(builder);






    }
    
}
