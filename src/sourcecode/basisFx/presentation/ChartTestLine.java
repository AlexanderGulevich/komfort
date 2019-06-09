package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.chart.SeriesNumberNumber;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Cursor;

public class ChartTestLine extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {

        SeriesNumberNumber sets = new SeriesNumberNumber();



        sets.createSet("set111");
        sets.add(1,0);
        sets.add(2,5);
        sets.add(3,0);

        sets.createSet("set222");
        sets.add(3,0);
        sets.add(4,5);
        sets.add(5,0);


        sets.createSet("set333");
        sets.add(6,0);
        sets.add(7,5);
        sets.add(8,0);


        sets.createSet("set4444");
        sets.add(9,0);
        sets.add(10,5);
        sets.add(11,0);

        sets.createSet("set5555");
        sets.add(11,0);
        sets.add(12,5);
        sets.add(13,0);



        sets.createSet("set6666");
        sets.add(13,0);
        sets.add(14,5);
        sets.add(15,0);



        sets.createSet("set777");
        sets.add(15,0);
        sets.add(16,5);
        sets.add(17,0);


        sets.createSet("set888");
        sets.add(17,0);
        sets.add(18,5);
        sets.add(19,0);


//
//
//
//        ChartBfxLineChart.builder()
//                .parent(dynamicContentAnchorHolder)
//                .chartTitle("ChartBfxLineChart")
//                .xLabel("xxxxxxxxxx").yLabel("yyyyyyyyy")
//                .xPrefix("ServiceChartPanelRightControls").yPrefix("y")
//                .xLines(true).yLines(false)
//                .cursor(Cursor.DEFAULT)
//                .coordinate(new Coordinate(0d, 0d, 0d, 0d))
//                .data(sets.getAllSets())
//                .xAutoRanging(true).yAutoRanging(true)
//                .xLowerBound(1).yLowerBound(10)
//                .xUpperBound(1000).yUpperBound(2000)
//                .xTickUnit(1).yTickUnit(2)
//                .build().configure();

    }

}
