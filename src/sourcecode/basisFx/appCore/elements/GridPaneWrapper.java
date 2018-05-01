/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alek
 */
public  class GridPaneWrapper extends AppNode{
    GridPane gridPane;

    public GridPaneWrapper(NodeBuilder builder) {
        element=new GridPane();
        gridPane=(GridPane) this.element;


        gridPane.addColumn(1,new AnchorPane());

        if (width != null) {
            gridPane.setPrefWidth(width);
        }

        gridPane.setGridLinesVisible(true);

        gridPane.getColumnConstraints().add(new ColumnConstraints(100));

        if (widthPerCent != null) {
            gridPane.prefWidthProperty().bind(parentAnchor.prefWidthProperty().multiply(this.widthPerCent));

        }



        init(builder);




    }


    public void setColumnAndPercentWidth(double percentWidth){
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(percentWidth);
        gridPane.getColumnConstraints().addAll(column);

    }

    public void setColumnAndWidth( double width ){
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(width);
        gridPane.getColumnConstraints().addAll(column);

    }

    public void setColumn(  ){
        ColumnConstraints column = new ColumnConstraints();
        gridPane.getColumnConstraints().addAll(column);

    }
    //добавляет элемент, который будет для нескольких колонок
    public void addSpanNode(Node child,int columnIndex,int rowIndex,int colspan,int rowspan){

        gridPane.add( child, columnIndex, rowIndex, colspan, rowspan);
    }
    public void  addNode(Node child,int columnIndex,int rowIndex){

        gridPane.add( child, columnIndex,rowIndex);
    }
    
}
