package basisFx.appCore.chart;

import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;

public class AreaChartBuilder {

    private AnchorPane panel;
    private double width;
    private double height;
    private Coordinate coordinate;
    private String title;
    private double lowerBound;
    private double upperBound;
    private double tickUnit;

    public AnchorPane getPanel() {
        return panel;
    }

    public void setPanel(AnchorPane panel) {
        this.panel = panel;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public double getTickUnit() {
        return tickUnit;
    }

    public void setTickUnit(double tickUnit) {
        this.tickUnit = tickUnit;
    }
}
