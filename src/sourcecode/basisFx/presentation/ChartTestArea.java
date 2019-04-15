package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.chart.AreaChartBfx;
import basisFx.appCore.chart.XYNumberSets;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Cursor;

public class ChartTestArea extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {

        XYNumberSets sets = new XYNumberSets();

        sets.createSet("set111");
        sets.add(2,5);
        sets.add(1,3);
        sets.add(1,24);
        sets.add(1,65);

        sets.createSet("set222");
        sets.add(4,88);
        sets.add(2,7);
        sets.add(6,67);
        sets.add(3,4);


        AreaChartBfx.builder()
                .parent(dynamicContentAnchorHolder)
                .chartTitle("AreaChartBfx")
                .xLabel("xxxxxxxxxx").yLabel("yyyyyyyyy")
                .xPrefix("d").yPrefix("y")
                .xLines(true).yLines(false)
                .cursor(Cursor.DEFAULT)
                .coordinate(new Coordinate(40d, 0d, 0d, 0d))
                .data(sets.getAllSets())
                .xAutoRanging(true).yAutoRanging(true)
                .xLowerBound(1).yLowerBound(10)
                .xUpperBound(1000).yUpperBound(2000)
                .xTickUnit(1).yTickUnit(2)
                .build().configure();

    }

}
