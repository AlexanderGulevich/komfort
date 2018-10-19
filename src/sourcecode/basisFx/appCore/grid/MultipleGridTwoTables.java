package basisFx.appCore.grid;

public class MultipleGridTwoTables extends MultipleGridConfiguration {

    GridPaneWrapper leftGridWrapper;
    GridPaneWrapper rightGridWrapper;

    public void setLeftGridWrapper(GridPaneWrapper leftGridWrapper) {
        this.leftGridWrapper = leftGridWrapper;
    }

    public void setRightGridWrapper(GridPaneWrapper rightGridWrapper) {
        this.rightGridWrapper = rightGridWrapper;
    }

    @Override
    public void init() {





    }


    //        gridPaneWrapper.addSpanNode(
//                observedGrid.getGridPane(),
//                0,0,1,1, HPos.LEFT, VPos.TOP,insets);
//
//            gridPaneWrapper.addSpanNode(
//                observerGrid.getGridPane(),
//                1,0,1,1, HPos.LEFT, VPos.TOP,insets);
//
//
//
//        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//
//
//        observedGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//        observerGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//
//    });


}
