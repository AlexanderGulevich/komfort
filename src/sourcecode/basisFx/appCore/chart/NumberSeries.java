package basisFx.appCore.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class NumberSeries {

    private ObservableList<XYChart.Series<Number, Number>> data;

    public   NumberSeries() {

        data= FXCollections.<XYChart.Series<Number, Number>>observableArrayList();

    }


    public void setSeries(String name, NumberAxisValue...axisValues){

        XYChart.Series<Number, Number> series=new XYChart.Series<>();
        series.setName(name);

        for (NumberAxisValue axisValue : axisValues) {
            new XYChart.Data<>(axisValue.getxVal(), axisValue.getyYal());
        }

        data.add(series);

    }


    public ObservableList<XYChart.Series<Number, Number>> getData() {
        return data;
    }
}
