package basisFx.appCore.grid;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BoundWithSecondRawGrid {

    private GridPane boundTableGrid;
    double firstRawPercentHeight;
    double secondRawPercentHeight;
    private AnchorPane parent;
    private ArrayList<GridTable> secondRawTables=new ArrayList<>();
    private GridPaneWrapper gridPaneWrapper;
    private GridPane gridPane;
    private GridPaneWrapper secondRowGrid;

    public void setBoundTableGrid(GridPane boundTableGrid) {
        this.boundTableGrid = boundTableGrid;
    }

    public GridPane getBoundTableGrid() {
        return boundTableGrid;
    }

    public void setRawPercentHeight(double firstRawPercentHeight, double secondRawPercentHeight) {
        this.firstRawPercentHeight=firstRawPercentHeight;
        this.secondRawPercentHeight=secondRawPercentHeight;
    }

    public void setParent(AnchorPane parent) {
        this.parent = parent;
    }

    public AnchorPane getParent() {
        return parent;
    }

    public void setSecondRawTables(GridTable secondRawTable) {
        this.secondRawTables.add(secondRawTable);
    }


    public void init() {
        gridPaneWrapper = AppNode.NodeBuilder.create()
                .setCoordinate(new Coordinate(0d,0d,0d,0d))
                .setParent(parent)
                .createGridPaneWrapper();

        gridPane= (GridPane) gridPaneWrapper.getElement();

        gridPaneWrapper.setColumnComputerWidth();

        gridPaneWrapper.setRowConstraints();
        gridPaneWrapper.setRowConstraints();

        gridPaneWrapper.addSpanNode(boundTableGrid,0,0,2,1, HPos.CENTER, VPos.BASELINE,null);


         secondRowGrid = AppNode.NodeBuilder.create().createGridPaneWrapper();
        GridPane secondRowGridPane= (GridPane)secondRowGrid.getElement();

        secondRowGrid.setColumnComputerWidth();

        int i=0;

        for (GridTable secondRawTable : secondRawTables) {
            organizeColumn(secondRawTable.getGridColWidth());

            secondRowGrid.addSpanNode(secondRawTable.getGridPane(),i++,1,1,1,HPos.CENTER,VPos.TOP,null);

        }


        //установка высот по умолчанию
        gridPane.getRowConstraints().get(0).setPrefHeight(
                new BigDecimal(gridPane.getHeight()).multiply(new BigDecimal(firstRawPercentHeight)).doubleValue()
        );


        gridPane.getRowConstraints().get(1).setPrefHeight(
                new BigDecimal(gridPane.getHeight()).multiply(new BigDecimal(secondRawPercentHeight)).doubleValue()
        );


        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {

            //установка высот при изменении высоты материнского gridPane
            gridPane.getRowConstraints().get(0).setPrefHeight(
                    new BigDecimal(gridPane.getHeight()).multiply(new BigDecimal(firstRawPercentHeight)).doubleValue()
            );


            gridPane.getRowConstraints().get(1).setPrefHeight(
                    new BigDecimal(gridPane.getHeight()).multiply(new BigDecimal(secondRawPercentHeight)).doubleValue()
            );

        });


        gridPaneWrapper.addSpanNode(secondRowGridPane,0,1,2,1, HPos.CENTER, VPos.BASELINE,null);



    }



    private void organizeColumn(GridColWidth setter) {


        KindOfGridCol kind = setter.getKind();

        switch (kind) {

            case fixed:
                secondRowGrid.setColumnFixed(setter.getWidth());
                break;

            case computed:
                secondRowGrid.setColumnComputerWidth();
                break;

            case percent:
                secondRowGrid.setColumnVsPercent(setter.getWidth());
                break;

            case byChild:
                secondRowGrid.setColumn();
                break;


        }
    }

}
