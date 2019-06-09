package basisFx.appCore.chart;

import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.interfaces.AnalazedForChart;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChartDataHandler {


    private static  ObservableList<ActiveRecord>  getRecords( Class aClass ){
        ObservableList<ActiveRecord> activeRecords=null;

        try {
            activeRecords = ((ActiveRecord) aClass.newInstance()).getAll();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return activeRecords;
    }
    public static ObservableList<XYChart.Series<Number, Number>>  getData( Class aClass ){
        SeriesNumberNumber seriesNumberNumber = new SeriesNumberNumber();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));

        map.entrySet().stream().forEach(e -> {
            seriesNumberNumber.createSet(e.getKey());
            e.getValue().stream().peek(activeRecord ->{
                AnalazedForChart analazed=((AnalazedForChart) activeRecord);
                    seriesNumberNumber.add(analazed.getCalendar().getTime().getTime(), analazed.getValue());
            } ).count();

        });
        ObservableList<XYChart.Series<Number, Number>> allSets = seriesNumberNumber.getAllSets();
        return allSets;
    }


    public static ObservableList<XYChart.Series<Number, Number>>  getDataByPeriod( Class aClass, Calendar before, Calendar after ){
        SeriesNumberNumber seriesNumberNumber = new SeriesNumberNumber();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));

        map.entrySet().stream().forEach(e -> {
            seriesNumberNumber.createSet(e.getKey());
            e.getValue().stream().peek(activeRecord ->{
                AnalazedForChart analazed=((AnalazedForChart) activeRecord);
                if (analazed.getCalendar().after(after)&& analazed.getCalendar().before(before)) {
                    seriesNumberNumber.add(analazed.getCalendar().getTime().getTime(), analazed.getValue());
                }
            } ).count();

        });
        ObservableList<XYChart.Series<Number, Number>> allSets = seriesNumberNumber.getAllSets();
        return allSets;
    }
}
