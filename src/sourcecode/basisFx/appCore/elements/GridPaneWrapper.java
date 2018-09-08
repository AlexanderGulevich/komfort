/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.util.ArrayList;

public  class GridPaneWrapper extends AppNode{
   protected GridPane element;
    protected boolean gridLinesVisibility=false;

//    element=new GridPane();
//        element.setGridLinesVisible(gridLinesVisibility);



    public void setRowConstraints(){
        RowConstraints rc = new RowConstraints();
        element.getRowConstraints().add(rc);

    }



    public void setColumnVsPercent(double percentWidth){
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(percentWidth);
        element.getColumnConstraints().add(column);

    }

    public void setColumnFixed( double width ){
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(width);
        element.getColumnConstraints().add(column);


    }
    public void setColumn ( ){
        ColumnConstraints column = new ColumnConstraints();
        element.getColumnConstraints().add(column);


    }


    public void setColumnComputerWidth(  ){
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow( Priority.ALWAYS );
        element.getColumnConstraints().add(column);



    }

    //добавляет элемент, который будет для нескольких колонок
    public void addSpanNode(Node child,int columnIndex,int rowIndex,int colspan,int rowspan,HPos halignment, VPos valignment,Insets insets){


        element.add( child, columnIndex, rowIndex, colspan, rowspan);
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


    @Override
    public GridPane getElement() {
        return element;
    }

}
