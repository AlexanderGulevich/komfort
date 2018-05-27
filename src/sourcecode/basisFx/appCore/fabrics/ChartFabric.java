package basisFx.appCore.fabrics;

import basisFx.appCore.chart.AreaChartBuilder;
import basisFx.appCore.chart.NumberAxisValue;
import basisFx.appCore.chart.NumberSeries;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.AreaChartWrapper;
import javafx.scene.chart.AreaChart;

//import org.apache.log4j.Logger;

public class ChartFabric {

//    private static final Logger log = Logger.getLogger(ChartFabric.class);

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
        NumberSeries.Series a = numberSeries.createSeries("AAAAAAAAAAAA");
        a.setAxisValue(new NumberAxisValue(1,2));
        a.setAxisValue(new NumberAxisValue(2,23));
        a.setAxisValue(new NumberAxisValue(3,56));
        a.setAxisValue(new NumberAxisValue(4,7));
        a.setAxisValue(new NumberAxisValue(5,569));
        a.setAxisValue(new NumberAxisValue(6,3));

        NumberSeries.Series b = numberSeries.createSeries("BBBBBBBBBBBBBBBBB");
        NumberSeries.Series c = numberSeries.createSeries("CCCCCCCCCCCCCCCC");
        NumberSeries.Series d = numberSeries.createSeries("DDDDDDDDDDDDDDD");


        AreaChart chart = (AreaChart) areaChartWrapper.getElement();

        chart.setData(numberSeries.getData());
//        log.info(" log.info");
//        log.error("  log.error");


        return chart;




    }

}


