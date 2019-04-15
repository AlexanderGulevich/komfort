package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.chart.PieChartBfx;
import basisFx.appCore.chart.PieSets;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Side;

public class ChartTestPie extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {

        PieSets sets = new PieSets();

        sets.add("Китай",3);
        sets.add("Беларусь",25);
        sets.add("Россия",25);
        sets.add("Украина",47);

        PieChartBfx.builder()
                .parent(dynamicContentAnchorHolder)
                .chartTitle("LineChartBfx")
                .coordinate(new Coordinate(0d, 0d, 0d, 0d))
                .side(Side.LEFT)
                .data(sets.getAllSets())
                .build().configure();

    }

}
