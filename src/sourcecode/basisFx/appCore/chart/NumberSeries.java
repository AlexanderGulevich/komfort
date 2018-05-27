package basisFx.appCore.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class NumberSeries {

    private ObservableList<XYChart.Series<Number, Number>> data;

    public   NumberSeries() {

        data= FXCollections.<XYChart.Series<Number, Number>>observableArrayList();

    }


    public Series createSeries(String name){

        Series series = new Series(name);

        return series;

    }


    public ObservableList<XYChart.Series<Number, Number>> getData() {
        return data;
    }


    public class Series{
        XYChart.Series<Number, Number> series;

        public Series(String name) {
            series=new XYChart.Series<>();
            series.setName(name);
            data.add(series);

        }


       public void setAxisValue(NumberAxisValue axisValue){
           XYChart.Data<Number, Number> data = new XYChart.Data<>(axisValue.getxVal(), axisValue.getyYal());
           series.getData().add(data);
       }




    }
}
