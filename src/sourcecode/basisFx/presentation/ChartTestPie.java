package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.chart.ChartBfxPie;
import basisFx.appCore.chart.SeriesToPie;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Side;

public class ChartTestPie extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {

        SeriesToPie sets = new SeriesToPie();

        sets.add("Китай",33);
        sets.add("Беларусь",25);
        sets.add("Россия",25);
        sets.add("Украина",47);
        sets.add("Норвегия",22);
        sets.add("Литва",32);
        sets.add("США",49);
        sets.add("Канада",42);

        ChartBfxPie.builder()
                .parent(dynamicContentAnchorHolder)
                .chartTitle("ChartBfxLineChart")
                .coordinate(new Coordinate(0d, 0d, 0d, 0d))
                .side(Side.LEFT)
                .data(sets.getAllSets())
                .build().configure();

    }

}
