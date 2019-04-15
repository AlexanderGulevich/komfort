package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import lombok.Builder;

import java.math.BigDecimal;


@Builder
public class PieChartBfx implements ChartBfx {

    private PieChart chart ;
    private ObservableList<PieChart.Data> data;
    private String chartTitle;
    private Side side;
    private AnchorPane parent;
    private Coordinate coordinate;

    private Cursor cursor;

   static double ovetall;

    @Override
    public void configure() {
        ovetall=0;
        chart = new PieChart();
        chart.setTitle(chartTitle);
        chart.setLegendSide(side);
        chart.setData(data);

        coordinate.setChildNode(chart);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();
        addSliceTooltip(chart);

    }
    private void addSliceTooltip(PieChart chart) {

        chart.getData().forEach(d -> {
            ovetall = ovetall+d.getPieValue();
        });


        chart.getData().forEach(d -> {
            Tooltip tip = new Tooltip();
            double percent=
                    new BigDecimal(d.getPieValue())
                            .divide( new BigDecimal(ovetall))
                            .multiply(new BigDecimal(100))
                            .doubleValue();
            tip.setText(d.getName()+"-"+d.getPieValue() + " /  "+ percent+"%");
            Tooltip.install(d.getNode(), tip);
        });




    }
}
