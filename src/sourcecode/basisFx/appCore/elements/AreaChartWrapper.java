//package basisFx.appCore.elements;
//
//import basisFx.appCore.chart.NumberSeries;
//import javafx.scene.chart.AreaChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//
//public class AreaChartWrapper extends AppNode{
//
//    private AreaChart areaChart=null;
//    private final NumberAxis xAxis = new NumberAxis();
//    private final NumberAxis yAxis = new NumberAxis();
//
//    public AreaChartWrapper(NodeBuilder builder) {
//
//        areaChart =new AreaChart<Number,Number>(xAxis,yAxis);
//        element=areaChart;
//        organize(builder);
//        areaChart.setTitle(string);
//    }
//    /**
//     * Вставка значения нижней границы по оси Х
//     * @param lowerBound
//     */
//    public AreaChartWrapper setXLoverBond(double lowerBound){
//        xAxis.setLowerBound(lowerBound);
//        return this;
//    }
//    /**
//     * Вставка значения верхней границы по оси Х
//     * @param upperBound
//     */
//    public AreaChartWrapper setXUpperBond(double upperBound){
//        xAxis.setUpperBound(upperBound);
//        return this;
//    }
//    /**
//     * Вставка шага значения по оси Х
//     * @param tickUnit
//     */
//    public AreaChartWrapper setXtickUnit(double tickUnit){
//        xAxis.setTickUnit(tickUnit);
//        return this;
//    }
//
//    public void setData(NumberSeries numberSeries){
//
//        this.areaChart.setData(numberSeries.getData());
//    }
//
//
//}
