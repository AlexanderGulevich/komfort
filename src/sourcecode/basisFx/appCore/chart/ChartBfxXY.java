package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import basisFx.service.ServiceChartPanels;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Builder
public class ChartBfxXY implements ChartBfx {

    private static SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat monthDateFormat = new SimpleDateFormat("MMM",new Locale("ru"));
    private static SimpleDateFormat monthYearDateFormat = new SimpleDateFormat("MMM.yyyy",new Locale("ru"));

    public enum KIND {AREA,LINE,STACKED};
    public enum DATEFORMAT {YEAR,MONTH,MONTHYEAR};

    @Setter private ServiceChartPanels service;

    private KIND kind;
    private ObservableList<XYChart.Series<Number, Number>>  data;
    @Getter private Class aClass;
    private DATEFORMAT dateformat;
    private XYChart chart;
    private String xLabel;
    private String yLabel;
    private String xPrefix;
    private String yPrefix;
    private boolean xAutoRanging;
    private boolean yAutoRanging;

    private boolean dateBasedChart;
    private boolean coordinateLabel;
    private boolean xLines;
    private boolean yLines;

    private double xLowerBound;
    private double yLowerBound;
    private double xUpperBound;
    private double yUpperBound;
    private double xTickUnit;
    private double yTickUnit;

    @Setter private AnchorPane parent;
    private Coordinate coordinate;


    @Override
    public void configure() {

        service.setChartBfx(this);

        if (dateBasedChart) {
            createDateBased();

        }else {
            createNumberBased();
        }

        toBondWithParent();

        if (coordinateLabel)   createCoordinateLabel();

        if (data != null) {
            chart.setData(data);
        }else {
            chart.setData(ChartDataHandler.getXYData(aClass));
        }

    }

    private void toBondWithParent() {
        coordinate.setChildNode(chart);
        coordinate.setParentAnchorPane(parent);
        coordinate.bonding();
    }

    private void createCoordinateLabel() {
        Label label = CoordinateLabel.executeLabel(chart);
        label.getStyleClass().add("coordinateLabel");

        new Coordinate(5d,null,null,20d)
                .setChildNode(label)
                .setParentAnchorPane(parent)
                .bonding();
    }

    private void createDateBased() {
        NumberAxis yAxis = new NumberAxis();
        DateAxis xAxis = new DateAxis();

        applyDATEFORMAT(xAxis);

        if (kind== KIND.AREA) chart = new AreaChart(xAxis, yAxis);
        if (kind== KIND.STACKED) chart = new StackedAreaChart(xAxis, yAxis);
        if (kind== KIND.LINE) chart = new LineChart(xAxis, yAxis);

        xAxis.setLabel(xLabel);
//        xAxis.setTickUnit(xTickUnit);
        xAxis.setAutoRanging(xAutoRanging);
//        xAxis.setLowerBound(xLowerBound);
//        xAxis.setUpperBound(xUpperBound);

        yAxis.setLabel(yLabel);
//        yAxis.setTickUnit(yTickUnit);
        yAxis.setAutoRanging(yAutoRanging);
//        yAxis.setLowerBound(yLowerBound);
//        yAxis.setUpperBound(yUpperBound);
    }

    private void applyDATEFORMAT(DateAxis xAxis) {
        xAxis.setTickLabelFormatter(new StringConverter<Long>() {
            @Override
            public String toString(Long object) {
                if(dateformat== DATEFORMAT.YEAR) return   yearDateFormat.format(new Date(object));
                if(dateformat== DATEFORMAT.MONTH) return  monthDateFormat.format(new Date(object));
                if(dateformat== DATEFORMAT.MONTHYEAR) return  monthYearDateFormat.format(new Date(object));
                else return null;
            }
            @Override
            public Long fromString(String string) {
                return null;
            }
        });
    }

    private void createNumberBased() {
        NumberAxis xAxis= new NumberAxis();
        NumberAxis yAxis= new NumberAxis();

        if (kind== KIND.AREA) chart = new AreaChart(xAxis, yAxis);
        if (kind== KIND.STACKED) chart = new StackedAreaChart(xAxis, yAxis);
        if (kind== KIND.LINE) chart = new LineChart<>(xAxis, yAxis);

        xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(xAxis, null, xPrefix));
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, yPrefix));
        chart.setHorizontalGridLinesVisible(xLines);
        chart.setVerticalGridLinesVisible(yLines);

        chart.setAlternativeColumnFillVisible(true);
        chart.setAlternativeRowFillVisible(true);


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
    }

    @Override
    public void setData(List data) {
        chart.setData((ObservableList<XYChart.Series>) data);

    }

    @Override
    public void applyPeriod(Calendar before, Calendar after) {
        ObservableList<XYChart.Series<Number, Number>> data = ChartDataHandler.getXYDataByPeriod(getAClass(), before, after);
        chart.setData(data);
    }

    @Override
    public void applyAllTime() {
        ObservableList<XYChart.Series<Number, Number>> data = ChartDataHandler.getXYData(getAClass());
        chart.setData(data);
    }
}
