package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lombok.Builder;

@Builder
public class StackedAreaChartBfx implements ChartBfx {

    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private StackedAreaChart<Number,Number> chart;
    private ObservableList<XYChart.Series<Number, Number>> data;
    private String chartTitle;
    private String xLabel;
    private String yLabel;
    private String xPrefix;
    private String yPrefix;
    private boolean xAutoRanging;
    private boolean yAutoRanging;

    private boolean xLines;
    private boolean yLines;

    private double xLowerBound;
    private double yLowerBound;
    private double xUpperBound;
    private double yUpperBound;
    private double xTickUnit;
    private double yTickUnit;

    private AnchorPane parent;
    private Coordinate coordinate;

    private Cursor cursor;




    @Override
    public void configure() {
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        chart = new StackedAreaChart(xAxis, yAxis);
        xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(xAxis, null, xPrefix));
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, yPrefix));
        chart.setTitle(chartTitle);
        chart.setCursor(cursor);
        chart.setAlternativeColumnFillVisible(true);
        chart.setAlternativeRowFillVisible(true);

        chart.setHorizontalGridLinesVisible(xLines);
        chart.setVerticalGridLinesVisible(yLines);

        xAxis.setLabel(xLabel);
        xAxis.setTickUnit(xTickUnit);
        xAxis.setAutoRanging(xAutoRanging);
        xAxis.setLowerBound(xLowerBound);
        xAxis.setUpperBound(xUpperBound);

        yAxis.setLabel(yLabel);
        yAxis.setTickUnit(yTickUnit);
        yAxis.setAutoRanging(yAutoRanging);
        yAxis.setLowerBound(yLowerBound);
        yAxis.setUpperBound(yUpperBound);

        chart.setData(data);

        coordinate.setChildNode(chart);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();

        Label label = CoordinateLabel.createLabel(chart);

        Coordinate coordinateLabel =new Coordinate(0d,null,null,0d);
        coordinateLabel.setChildNode(label);
        coordinateLabel.setParentAnchorPane(parent);
        coordinateLabel.bonding();



    }
}
