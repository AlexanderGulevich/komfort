package basisFx.appCore.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class StringNumberSeries {


    private ObservableList<XYChart.Series<String, Number>> data;

    public   StringNumberSeries() {

        data= FXCollections.<XYChart.Series<String, Number>>observableArrayList();

    }


    public void setSeries(String name, NumberStringValue... numberStringValues){

        XYChart.Series<String, Number> series=new XYChart.Series<>();
        series.setName(name);

        for (NumberStringValue val : numberStringValues) {
            new XYChart.Data<>(val.getStringVal(), val.getNumberVal());
        }

        data.add(series);

    }


    public ObservableList<XYChart.Series<String, Number>> getData() {
        return data;
    }
}
