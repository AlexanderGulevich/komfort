package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import lombok.Builder;

@Builder
public class VerticalBarChartBfx implements ChartBfx{

    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    private BarChart<String, Number> chart;
    private ObservableList<XYChart.Series<String, Number>> data;
    private String chartTitle;
    private String xLabel;
    private String yLabel;
    private String xPrefix;
    private String yPrefix;
    private boolean yAutoRanging;
    private boolean xAutoRanging;

    private boolean xLines;
    private boolean yLines;

    private double yLowerBound;
    private double yUpperBound;
    private double yTickUnit;

    private AnchorPane parent;
    private Coordinate coordinate;

    private Cursor cursor;
    @Override
    public void configure() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        chart = new BarChart<>(xAxis, yAxis);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, yPrefix));
        chart.setTitle(chartTitle);

        chart.setAlternativeColumnFillVisible(true);
        chart.setAlternativeRowFillVisible(true);
        chart.setHorizontalGridLinesVisible(xLines);
        chart.setVerticalGridLinesVisible(yLines);
        chart.setCursor(cursor);

        xAxis.setLabel(xLabel);
        xAxis.setAutoRanging(xAutoRanging);

        yAxis.setLabel(yLabel);
        yAxis.setTickUnit(yTickUnit);
        yAxis.setAutoRanging(yAutoRanging);
        yAxis.setLowerBound(yLowerBound);
        yAxis.setUpperBound(yUpperBound);

        chart.setData(data);

        coordinate.setChildNode(chart);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();

    }
}
