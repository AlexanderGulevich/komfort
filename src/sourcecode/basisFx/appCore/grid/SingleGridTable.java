package basisFx.appCore.grid;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class SingleGridTable extends GridTable {

    private Button buttonAdd;
    private Button buttonDel;
    private Button buttonAddLittle;
    private Button buttonDelLittle;
    private Button submitButton;

    private Insets insets = new Insets(3, 3, 3, 3);
    private LabelWrapper label;


    @Override
    public void init() {
        label = textFabric.createLabel(title, FontsStore.ROBOTO_LIGHT, Pos.BASELINE_LEFT, 25d);

        typeOfTableInspection();

        buttonAdd = buttonFactory.addRowButton(tableWrapper, domainClass);
        buttonDel = buttonFactory.deleteRowButton(tableWrapper);
        buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper, domainClass);
        buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);


        anchorBasedInspection();

        gridPane = (GridPane) gridPaneWrapper.getElement();

        tableHeightSwitchingByGrid();

        organize();


    }

    private void tableHeightSwitchingByGrid() {

        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {

            tableView.setPrefHeight(gridPane.getHeight());

//            To listen to both width and height changes, the same listener can be used really simply:

//            ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) ->
//                    System.out.println("Height: " + stage.getHeight() + " Width: " + stage.getWidth());
//
//            stage.widthProperty().addListener(stageSizeListener);
//            stage.heightProperty().addListener(stageSizeListener);

        });

    }

    private void typeOfTableInspection() {

        System.err.println("1111111111"+kindOfTable);

          if (kindOfTable==KindOfTable.SUBMIT){
              System.err.println(kindOfTable.toString().toUpperCase());
            tableWrapper =AppNode.NodeBuilder.create()
                    .setId(CSSID.TABLE)
                    .setEditCreater(()-> {return editFabric.createMultipleSubmitEditCommit();})
                    .createTableViewWrapper()
                    .setDataMapper(dataMapper)
                    .setEditable(true)
                    .setColums(columnWrappers)
                    .refresh();


        } else if (kindOfTable==KindOfTable.OBSERVED){
              System.err.println(kindOfTable.toString().toUpperCase());
            tableWrapper = AppNode.NodeBuilder.create()
                    .setId(CSSID.TABLE)
                    .setEditCreater(() -> {
                        return editFabric.createDefaultEditCommit();
                    })
                    .createTableViewWrapper()
                    .setDataMapper(dataMapper)
                    .setEditable(true)
                    .setBoundTable(observers.get(0))
                    .setColums(columnWrappers)
                    .refresh();

        }else {

              tableWrapper = AppNode.NodeBuilder.create()
                      .setId(CSSID.TABLE)
                      .setEditCreater(() -> {
                          return editFabric.createDefaultEditCommit();
                      })
                      .createTableViewWrapper()
                      .setDataMapper(dataMapper)
                      .setEditable(true)
                      .setColums(columnWrappers)
                      .refresh();

          }

        tableView = tableWrapper.getTable();
    }

    private void anchorBasedInspection() {

        if (coordinate != null && parentAnchorPane != null) {
            gridPaneWrapper = AppNode.NodeBuilder.create()
                    .setCoordinate(coordinate)
                    .setParent(parentAnchorPane)
                    .createGridPaneWrapper();
        } else {
            gridPaneWrapper = AppNode.NodeBuilder.create()
                    .createGridPaneWrapper();
        }

    }

    private void organize() {


        switch (tablesButtonKind) {

            case Right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        2, 2, 1, 1, HPos.CENTER, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 2, 2, HPos.CENTER, VPos.TOP, insets);
                break;

            case TOP_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 3, 2, HPos.CENTER, VPos.TOP, insets);
                break;

            case Bottom_right_little:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAddLittle,
                        2, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDelLittle,
                        1, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);
                break;

            case Bottom_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);
                break;

            case TOP_right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        1, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 3, 2, HPos.CENTER, VPos.TOP, insets);
                break;


            case Right:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();
                gridPaneWrapper.setColumn();

                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonAdd,
                        2, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        buttonDel,
                        2, 2, 1, 1, HPos.CENTER, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 2, 2, HPos.CENTER, VPos.TOP, insets);
                break;

            case No_buttons:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);

                break;
            case Submit:
                gridPaneWrapper.setColumnComputerWidth();
                gridPaneWrapper.setColumn();


                gridPaneWrapper.addSpanNode(
                        label.getElement(),
                        0, 0, 2, 1, HPos.LEFT, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        submitButton,
                        1, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
                gridPaneWrapper.addSpanNode(
                        tableWrapper.getElement(),
                        0, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
                break;


        }


    }

}
