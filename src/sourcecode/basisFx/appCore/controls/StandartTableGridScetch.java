package basisFx.appCore.controls;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.MaximazingObserver;
import basisFx.appCore.obseverved.MaximazingManager;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javax.swing.text.TableView;


public class StandartTableGridScetch extends ScretchedTableGrid implements MaximazingObserver {
    
    private Insets insets=new Insets(3,3,3,3);



    @Override
    public void init() {

        MaximazingManager.setObserver(this);

        LabelWrapper label = textFabric.createLabel(title, FontsStore.ROBOTO_LIGHT, Pos.BASELINE_LEFT, 25d);

         tableWrapper= AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE)
                .setEditCreater(()-> {return editFabric.createDefaultEditCommit();})
                .createTableViewWrapper()
                .setDataMapper(dataMapper)
                .setEditable(true)
                .setColums(columnWrappers)
                .refresh();

         tableView= tableWrapper.getTable();




        Button buttonAdd = buttonFactory.addRowButton(tableWrapper, domainClass);
        Button buttonDel =buttonFactory.deleteRowButton(tableWrapper);
        Button buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper,domainClass );
        Button buttonDelLittle =buttonFactory.littleRowDeleteButton(tableWrapper ) ;

        gridPaneWrapper = AppNode.NodeBuilder.create()
                .setCoordinate(coordinate)
                .setParent(parentAnchorPane)
                .createGridPaneWrapper();


        gridPane= (GridPane) gridPaneWrapper.getElement();


        switch (tablesButtonKind){

            case Right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,1,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        2,2,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,2,2,HPos.CENTER, VPos.TOP,insets);
                break;

            case TOP_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,1,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,2,HPos.CENTER, VPos.TOP,insets);
                break;

            case Bottom_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,1,HPos.CENTER, VPos.TOP,insets);
                break;

            case Bottom_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1,2,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,1,HPos.CENTER, VPos.TOP,insets);
                break;

            case TOP_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,1,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1,0,1,1,HPos.RIGHT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,3,2,HPos.CENTER, VPos.TOP,insets);
                break;


            case Right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0,0,3,1, HPos.LEFT, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2,1,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        2,2,1,1,HPos.CENTER, VPos.TOP,insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0,1,2,2,HPos.CENTER, VPos.TOP,insets);
                break;

        }


    }

    @Override
    public void pervormMaximazing() {

        System.out.println("BEFORE  gridPane.getHeight()    -- "+  gridPane.getHeight());
        System.out.println("BEFORE  gridPane.getPrefHeight()  -- "+gridPane.getPrefHeight());

        System.out.println("BEFORE  tableView.getHeight()    -- "+  tableView.getHeight());
        System.out.println("BEFORE  tableView.getPrefHeight()  -- "+tableView.getPrefHeight());

        System.out.println("BEFORE  parentAnchorPane.getHeight()    -- "+  parentAnchorPane.getHeight());
        System.out.println("BEFORE  parentAnchorPane.getPrefHeight()  -- "+parentAnchorPane.getPrefHeight());



//        gridPane.setPrefHeight(parentAnchorPane.getHeight());



        tableView.setPrefHeight(parentAnchorPane.getHeight()+40d);




        System.out.println("AFTER  gridPane.getHeight()    -- "+  gridPane.getHeight());
        System.out.println("AFTER  gridPane.getPrefHeight()  -- "+gridPane.getPrefHeight());

        System.out.println("AFTER  tableView.getHeight()    -- "+  tableView.getHeight());
        System.out.println("AFTER  tableView.getPrefHeight()  -- "+tableView.getPrefHeight());

        System.out.println("AFTER  parentAnchorPane.getHeight()    -- "+  parentAnchorPane.getHeight());
        System.out.println("AFTER  parentAnchorPane.getPrefHeight()  -- "+parentAnchorPane.getPrefHeight());




    }
}
