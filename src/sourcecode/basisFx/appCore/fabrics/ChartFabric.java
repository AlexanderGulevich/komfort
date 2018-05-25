package basisFx.appCore.fabrics;

import basisFx.appCore.chart.AreaChartBuilder;
import basisFx.appCore.chart.NumberAxisValue;
import basisFx.appCore.chart.NumberSeries;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.AreaChartWrapper;
import javafx.scene.chart.AreaChart;

public class ChartFabric {

    public AreaChart areaChart(AreaChartBuilder builder){

        AreaChartWrapper areaChartWrapper = AppNode.NodeBuilder.create()
                .setParent(builder.getPanel())
                .setCoordinate(builder.getCoordinate())
                .setWidth(builder.getWidth())
                .setHeight(builder.getHeight())
                .setText(builder.getTitle())
                .createAreaChartWrapper()
                .setXLoverBond(builder.getLowerBound())
                .setXUpperBond(builder.getUpperBound())
                .setXtickUnit(builder.getTickUnit());


        NumberSeries numberSeries = new NumberSeries();
        numberSeries.setSeries("",new NumberAxisValue(4,5));

        areaChartWrapper.setData();

        AreaChart chart = (AreaChart) areaChartWrapper.getElement();




        return chart;




    }

}


