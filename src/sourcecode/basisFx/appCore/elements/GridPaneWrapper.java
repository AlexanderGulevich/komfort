/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.awt.*;

/**
 *
 * @author Alek
 */
public  class GridPaneWrapper extends AppNode{
    GridPane gridPane;

    public GridPaneWrapper(NodeBuilder builder) {
        element=new GridPane();
        gridPane=(GridPane) this.element;
        gridPane.setGridLinesVisible(false);


//        if (widthPerCent != null) {
//            gridPane.prefWidthProperty().bind(parentAnchor.prefWidthProperty().multiply(this.widthPerCent));
//
//        }

        init(builder);


    }


    public void setColumnVsPercent(double percentWidth){
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(percentWidth);
        gridPane.getColumnConstraints().add(column);

    }

    public void setColumnFixed( double width ){
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(width);
        gridPane.getColumnConstraints().add(column);


    }
    public void setColumn ( ){
        ColumnConstraints column = new ColumnConstraints();
        gridPane.getColumnConstraints().add(column);

    }


    public void setColumnComputerWidth(  ){
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow( Priority.ALWAYS );
        gridPane.getColumnConstraints().add(column);



    }
    //добавляет элемент, который будет для нескольких колонок
    public void addSpanNode(Node child,int columnIndex,int rowIndex,int colspan,int rowspan,HPos halignment, VPos valignment,Insets insets){

        gridPane.add( child, columnIndex, rowIndex, colspan, rowspan);
        setConstraints(child, halignment,  valignment);
        setMargin(child,insets);

    }


    private void setConstraints(Node child,HPos halignment, VPos valignment){
        GridPane.setValignment(child,valignment);
        GridPane.setHalignment(child,halignment);
    }

    private void setMargin(Node child, Insets in){
        GridPane.setMargin(child,in);

    }




}
