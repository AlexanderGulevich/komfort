package basisFx.appCore.chart;

import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.interfaces.AnalazedForChart;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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
    public static ObservableList<XYChart.Series<Number, Number>> getXYData(Class aClass ){
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
    public static ObservableList<XYChart.Series<Number, Number>> getXYDataByPeriod(Class aClass, Calendar before, Calendar after ){
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
    public static ObservableList<PieChart.Data> getPIEData(Class aClass ){
        SeriesToPie series = new SeriesToPie();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));

        map.entrySet().stream().forEach(e -> {

            String name = e.getKey();
            double sum = e.getValue().stream()
                    .flatMapToDouble(activeRecord -> DoubleStream.of(((AnalazedForChart) activeRecord).getValue()))
                    .reduce((acc, val) -> acc + val).getAsDouble();

            series.add(name,sum);

        });
        ObservableList<PieChart.Data> allSets = series.getAllSets();
        return allSets;
    }
    public static ObservableList<PieChart.Data> getPIEDataByPeriod(Class aClass, Calendar before, Calendar after ){
        SeriesToPie series = new SeriesToPie();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));

        map.entrySet().stream().forEach(e -> {
            String name = e.getKey();
            double sum = e.getValue().stream()
                    .filter(activeRecord ->((AnalazedForChart) activeRecord).getCalendar().after(after) )
                    .filter(activeRecord ->((AnalazedForChart) activeRecord).getCalendar().before(before) )
                    .flatMapToDouble(activeRecord -> DoubleStream.of(((AnalazedForChart) activeRecord).getValue()))
                    .reduce((acc, val) -> acc + val)
                    .getAsDouble();
            series.add(name,sum);
        });

        return     series.getAllSets();
    }
    public static ObservableList<XYChart.Series<String, Number>> getVBarData(Class aClass ){

        SeriesStringNumber series = new SeriesStringNumber();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));

        map.entrySet().stream().forEach(e -> {
            String name = e.getKey();
            series.createSet(name);
            e.getValue().stream()
                    .collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getVBarXAxisNames()))
                    .forEach((string, list) -> {
                        double asDouble = list.stream()
                                .flatMapToDouble(
                                        activeRecord -> DoubleStream.of(((AnalazedForChart) activeRecord).getValue()))
                                .reduce((acc, val) -> acc + val).getAsDouble();

                        series.add(string, asDouble);

                    });
        });
        ObservableList<XYChart.Series<String, Number>> allSets = series.getAllSets();
        return allSets;
    }

    public static ObservableList<XYChart.Series<String, Number>> getVBarDataByPeriod(Class aClass, Calendar before, Calendar after ){
        SeriesStringNumber series = new SeriesStringNumber();
        ObservableList<ActiveRecord> activeRecords=getRecords(aClass);
        Map<String, List<ActiveRecord>> map =
                activeRecords.stream().collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getSeriesName()));


        map.entrySet().stream().forEach(e -> {
            String name = e.getKey();
            series.createSet(name);
            e.getValue().stream()
                    .filter(activeRecord ->((AnalazedForChart) activeRecord).getCalendar().after(after) )
                    .filter(activeRecord ->((AnalazedForChart) activeRecord).getCalendar().before(before) )
                    .collect(Collectors.groupingBy(o -> ((AnalazedForChart) o).getVBarXAxisNames()))
                    .forEach((string, list) -> {
                                double asDouble = list.stream()
                                        .flatMapToDouble(
                                                activeRecord -> DoubleStream.of(((AnalazedForChart) activeRecord).getValue()))
                                        .reduce((acc, val) -> acc + val).getAsDouble();

                                series.add(string, asDouble);

                                }
                        );}
                    );

        return     series.getAllSets();
    }

}
