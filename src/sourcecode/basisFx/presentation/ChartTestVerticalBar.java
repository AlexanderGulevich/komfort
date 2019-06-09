package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.chart.*;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.Cursor;

public class ChartTestVerticalBar extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {

        SeriesStringNumber sets = new SeriesStringNumber();

        sets.createSet("1950");
        sets.add("Китай",5);
        sets.add("Беларусь",3);
        sets.add("Россия",24);
        sets.add("Украина",65);

        sets.createSet("2000");
        sets.add("Китай",88);
        sets.add("Беларусь",7);
        sets.add("Россия",67);
        sets.add("Украина",4);

        sets.createSet("2017");
        sets.add("Китай",55);
        sets.add("Беларусь",4);
        sets.add("Россия",7);
        sets.add("Украина",88);

        sets.createSet("2018");
        sets.add("Китай",33);
        sets.add("Беларусь",45);
        sets.add("Россия",73);
        sets.add("Украина",65);

        sets.createSet("2019");
        sets.add("Китай",44);
        sets.add("Беларусь",66);
        sets.add("Россия",74);
        sets.add("Украина",46);

        sets.createSet("2019");
        sets.add("Китай",44);
        sets.add("Беларусь",66);
        sets.add("Россия",74);
        sets.add("Украина",46);

        sets.createSet("2019");
        sets.add("Китай",44);
        sets.add("Беларусь",66);
        sets.add("Россия",74);
        sets.add("Украина",46);

        sets.createSet("2019");
        sets.add("Китай",44);
        sets.add("Беларусь",66);
        sets.add("Россия",74);
        sets.add("Украина",46);

//
//        ChartBfxVerticalBar.builder()
//                .parent(dynamicContentAnchorHolder)
//                .chartTitle("ChartBfxLineChart")
//                .xLabel("xxxxxxxxxx").yLabel("yyyyyyyyy")
//                .xPrefix("ServiceChartPanelRightControls").yPrefix("y")
//                .xLines(true).yLines(false)
//                .cursor(Cursor.DEFAULT)
//                .coordinate(new Coordinate(0d, 0d, 0d, 0d))
//                .data(sets.getAllSets())
//                .xAutoRanging(true).yAutoRanging(true)
//                .yLowerBound(10).yUpperBound(2000).yTickUnit(2)
//                .build().configure();

    }

}
