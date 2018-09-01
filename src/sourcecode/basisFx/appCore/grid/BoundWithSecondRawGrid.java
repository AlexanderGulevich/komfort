//package basisFx.appCore.grid;
//
//import basisFx.appCore.controls.GridTable;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.appCore.elements.AppNode;
//import basisFx.appCore.elements.GridPaneWrapper;
//import basisFx.appCore.utils.Coordinate;
//import javafx.geometry.HPos;
//import javafx.geometry.VPos;
//import javafx.scene.control.ScrollBar;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.text.Text;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//public class BoundWithSecondRawGrid {
//
//    private GridPane boundTableGrid;
//    double firstRawPercentHeight;
//    double secondRawPercentHeight;
//    private AnchorPane parent;
//    private ArrayList<GridTable> secondRawTables=new ArrayList<>();
//    private GridPaneWrapper commonGridPaneWrapper;
//    private GridPane commonGridPane;
//    private GridPaneWrapper secondRowGridWrapper;
//
//    public void setBoundTableGrid(GridPane boundTableGrid) {
//        this.boundTableGrid = boundTableGrid;
//    }
//
//    public GridPane getBoundTableGrid() {
//        return boundTableGrid;
//    }
//
//    public void setRawPercentHeight(double firstRawPercentHeight, double secondRawPercentHeight) {
//        this.firstRawPercentHeight=firstRawPercentHeight;
//        this.secondRawPercentHeight=secondRawPercentHeight;
//    }
//
//    public void setParent(AnchorPane parent) {
//        this.parent = parent;
//    }
//
//    public AnchorPane getParent() {
//        return parent;
//    }
//
//    public void setSecondRawTables(GridTable secondRawTable) {
//        this.secondRawTables.add(secondRawTable);
//    }
//
//
//    public void init() {
//        commonGridPaneWrapper = AppNode.NodeBuilder.create()
//                .setCoordinate(new Coordinate(0d,0d,0d,0d))
//                .setParent(parent)
//                .createGridPaneWrapper();
//
//        commonGridPane = (GridPane) commonGridPaneWrapper.getElement();
//
//        commonGridPaneWrapper.setColumnVsPercent(100d);
//
//        commonGridPaneWrapper.setRowConstraints();
//        commonGridPaneWrapper.setRowConstraints();
//
//        commonGridPaneWrapper.addSpanNode(boundTableGrid,0,0,1,1, HPos.CENTER, VPos.BASELINE,null);
//
//
//        secondRowGridWrapper = AppNode.NodeBuilder.create().createGridPaneWrapper();
//        GridPane secondRowGridPane= (GridPane) secondRowGridWrapper.getElement();
//        commonGridPaneWrapper.addSpanNode(secondRowGridPane,0,1,1,1, HPos.CENTER, VPos.BASELINE,null);
//
//
//        int i=0;
//
//        for (GridTable secondRawTable : secondRawTables) {
//
//            organizeColumn(secondRawTable.getGridColWidth());
////
////            double v = secondRawTable.getGridPane().getColumnConstraints().get(i).percentWidthProperty().get();
////            TableView<DomainObject> tableView = secondRawTable.getTableView();
////
////            commonGridPane.widthProperty().addListener((obs, oldVal, newVal) -> {
////
////
////                double v1 = newVal.doubleValue();
////                double multiply = new BigDecimal(v1).multiply(new BigDecimal(v)).doubleValue();
////
////                secondRawTable.getTableView().setPrefWidth(
////                        multiply
////                );
////
////                    });
//
//
//
//            secondRowGridWrapper.addSpanNode(secondRawTable.getGridPane(),i,1,1,1,HPos.CENTER,VPos.TOP,null);
//
//            i++;
//        }
//
//
//        //установка высот по умолчанию
//        commonGridPane.getRowConstraints().get(0).setPrefHeight(
//                new BigDecimal(commonGridPane.getHeight()).multiply(new BigDecimal(firstRawPercentHeight)).doubleValue()
//        );
//
//
//        commonGridPane.getRowConstraints().get(1).setPrefHeight(
//                new BigDecimal(commonGridPane.getHeight()).multiply(new BigDecimal(secondRawPercentHeight)).doubleValue()
//        );
//
//
//        commonGridPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//
//            //установка высот при изменении высоты материнского commonGridPane
//            commonGridPane.getRowConstraints().get(0).setPrefHeight(
//                    new BigDecimal(commonGridPane.getHeight()).multiply(new BigDecimal(firstRawPercentHeight)).doubleValue()
//            );
//
//
//            commonGridPane.getRowConstraints().get(1).setPrefHeight(
//                    new BigDecimal(commonGridPane.getHeight()).multiply(new BigDecimal(secondRawPercentHeight)).doubleValue()
//            );
//
//        });
//
//
//
//    }
//
//
//
//    private void organizeColumn(GridColWidth setter) {
//
//
//        KindOfGridCol kind = setter.getKind();
//
//        switch (kind) {
//
//            case fixed:
//                secondRowGridWrapper.setColumnFixed(setter.getWidth());
//
//                break;
//
//            case computed:
//                secondRowGridWrapper.setColumnComputerWidth();
//                break;
//
//            case percent:
//                secondRowGridWrapper.setColumnVsPercent(setter.getWidth());
//                break;
//
//            case byChild:
//                secondRowGridWrapper.setColumn();
//                break;
//
//
//        }
//    }
//
//}
