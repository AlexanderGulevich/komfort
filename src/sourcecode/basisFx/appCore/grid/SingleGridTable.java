package basisFx.appCore.grid;

import basisFx.appCore.elements.LabelWrapper;
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
        label =LabelWrapper.newBuilder()
                .setName(title)
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setAlignment(Pos.BASELINE_LEFT)
                .setFontSize(20d)
                .build();

        buttonAdd = buttonFactory.addRowButton(tableWrapper, domainClass);
        buttonDel = buttonFactory.deleteRowButton(tableWrapper);
        buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper, domainClass);
        buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);

        gridPane = (GridPane) gridPaneWrapper.getElement();

        tableHeightSwitchingByGrid();

        organize();


    }

    private void tableHeightSwitchingByGrid() {

        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {

            tableView.setPrefHeight(gridPane.getHeight());
        });

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
