package basisFx.appCore.grid;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BoundTablesGrid    {

    private GridPaneWrapper gridPaneWrapper;
    private GridPane gridPane;
    private Insets insets=new Insets(3,3,3,3);
    private SingleGridTable observerGrid;
    private SingleGridTable observedGrid;
    private GridColWidth colWh_1;
    private GridColWidth colWh_2;
    private Coordinate coordinate;
    private AnchorPane parent;

    public void setObserverGrid(SingleGridTable observerGrid) {
        this.observerGrid = observerGrid;
    }

    public void setObservedGrid(SingleGridTable observedGrid) {
        this.observedGrid = observedGrid;
    }

    public void setColWh_1(GridColWidth colWh_1) {
        this.colWh_1 = colWh_1;
    }

    public void setColWh_2(GridColWidth colWh_2) {
        this.colWh_2 = colWh_2;
    }

    public void init() {
        gridPaneWrapper = AppNode.NodeBuilder.create().setCoordinate(coordinate).setParent(parent).createGridPaneWrapper();
        gridPane= (GridPane) gridPaneWrapper.getElement();

        organizeColumn(colWh_1);
        organizeColumn(colWh_2);


        gridPaneWrapper.addSpanNode(
                observedGrid.getGridPane(),
                0,0,1,1, HPos.LEFT, VPos.TOP,insets);

        gridPaneWrapper.addSpanNode(
                observerGrid.getGridPane(),
                1,0,1,1, HPos.LEFT, VPos.TOP,insets);



        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {


            observedGrid.getGridPane().setPrefHeight(gridPane.getHeight());
            observerGrid.getGridPane().setPrefHeight(gridPane.getHeight());

        });
    }

    private void organizeColumn(GridColWidth setter) {


        KindOfGridCol kind = setter.getKind();

        switch (kind) {

            case fixed:
                gridPaneWrapper.setColumnFixed(setter.getWidth());
                break;

            case computed:
                gridPaneWrapper.setColumnComputerWidth();
                break;

            case percent:
                gridPaneWrapper.setColumnVsPercent(setter.getWidth());
                break;

            case byChild:
                gridPaneWrapper.setColumn();
                break;


        }
    }


    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setParent(AnchorPane parent) {
        this.parent = parent;
    }

    public GridPaneWrapper getGridPaneWrapper() {
        return gridPaneWrapper;
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
