package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import basisFx.service.ServiceChartPanels;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Builder
public class ChartBfxPie implements ChartBfx {

    @Setter private ServiceChartPanels service;
    private PieChart chart ;
    private ObservableList<PieChart.Data> data;
    private String chartTitle;
    private Side side;
    @Setter
    private AnchorPane parent;
    private Coordinate coordinate;

    @Getter
    private Class aClass;
    private Cursor cursor;

   static double overall;

    @Override
    public void configure() {
        overall =0;
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
        ObservableList<PieChart.Data> data = chart.getData();
        data.forEach(d -> { overall = overall +d.getPieValue(); });

        data.forEach(d -> {
            Tooltip tip = new Tooltip();
            double percent=
                    new BigDecimal(d.getPieValue())
                            .divide( new BigDecimal(overall))
                            .multiply(new BigDecimal(100))
                            .doubleValue();
            tip.setText(d.getName()+"-"+d.getPieValue() + " /  "+ percent+"%");
            Tooltip.install(d.getNode(), tip);
        });




    }
    @Override
    public void setData(List data) {
        this.data = (ObservableList<PieChart.Data> ) data;
    }
}
