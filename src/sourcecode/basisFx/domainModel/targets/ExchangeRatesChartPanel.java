package basisFx.domainModel.targets;

import basisFx.appCore.chart.AreaChartBuilder;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;


public class ExchangeRatesChartPanel extends Target {

    @Override
    protected void configurate() {

        AreaChartBuilder chartBuilder = new AreaChartBuilder();
        chartBuilder.setCoordinate(new Coordinate(10d,10d,10d,10d));
        chartBuilder.setHeight(600d);
        chartBuilder.setWidth(700d);
        chartBuilder.setTitle("1111111111111111111111111");
        chartBuilder.setLowerBound(0);
        chartBuilder.setUpperBound(1500);
        chartBuilder.setTickUnit(1);
        chartBuilder.setPanel(panel);




        chartFabric.areaChart(chartBuilder);



    }
}
