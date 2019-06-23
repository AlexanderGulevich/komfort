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
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;


@Builder
public class ChartBfxPie implements ChartBfx {

    @Setter private ServiceChartPanels service;
    private PieChart chart ;
    @Getter private Class aClass;
    private ObservableList<PieChart.Data> data;
    private String chartTitle;
    private Side side;
    @Setter private AnchorPane parent;
    private Coordinate coordinate;
    private Cursor cursor;
   static double overall;

    @Override
    public void configure() {

        service.setChartBfx(this);
        overall =0;
        chart = new PieChart();
        chart.setTitle(chartTitle);
        chart.setLegendSide(side);
        data=ChartDataHandler.getPIEData(aClass);
        chart.setData(data);


        coordinate.setChildNode(chart);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();

        addSliceTooltip(chart);


    }
    private void addSliceTooltip(PieChart chart) {
        ObservableList<PieChart.Data> data = chart.getData();
        overall=0;
        data.forEach(d -> { overall = overall +d.getPieValue(); });

        data.forEach(d -> {
            Tooltip tip = new Tooltip();
            BigDecimal val = new BigDecimal(d.getPieValue())
                    .setScale(3,RoundingMode.HALF_UP);
            BigDecimal sum = new BigDecimal(overall)
                    .setScale(3,RoundingMode.HALF_UP);
            BigDecimal percent=val
                    .divide(sum,3,RoundingMode.HALF_UP)
                    .multiply(new BigDecimal(100));
            tip.setText(d.getName()+"-"+val.doubleValue() + " /  "+ percent.doubleValue()+"%");
            Tooltip.install(d.getNode(), tip);
        });




    }
    @Override
    public void setData(List data) {
        this.data = (ObservableList<PieChart.Data> ) data;
        addSliceTooltip(chart);
    }


    @Override
    public void applyPeriod(Calendar before, Calendar after) {
        ObservableList<PieChart.Data> data = ChartDataHandler.getPIEDataByPeriod(getAClass(), before, after);
        chart.setData(data);
        addSliceTooltip(chart);
    }

    @Override
    public void applyAllTime() {
        ObservableList<PieChart.Data> data = ChartDataHandler.getPIEData(getAClass());
        chart.setData(data);
        addSliceTooltip(chart);
    }
}
