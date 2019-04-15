package basisFx.appCore.chart;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CoordinateLabel {

    public static   Label createLabel(XYChart<Number,Number> chart) {
        final Axis<Number> xAxis = chart.getXAxis();
        final Axis<Number> yAxis = chart.getYAxis();

        final Label cursorCoords = new Label();

        final Node chartBackground = chart.lookup(".chart-plot-background");
        for (Node n: chartBackground.getParent().getChildrenUnmodifiable()) {
            if (n != chartBackground && n != xAxis && n != yAxis) {
                n.setMouseTransparent(true);
            }
        }

        chartBackground.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        chartBackground.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "(%.2f, %.2f)",
                                xAxis.getValueForDisplay(mouseEvent.getX()),
                                yAxis.getValueForDisplay(mouseEvent.getY())
                        )
                );
            }
        });

        chartBackground.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        xAxis.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        xAxis.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "x = %.2f",
                                xAxis.getValueForDisplay(mouseEvent.getX())
                        )
                );
            }
        });

        xAxis.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        yAxis.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        yAxis.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "y = %.2f",
                                yAxis.getValueForDisplay(mouseEvent.getY())
                        )
                );
            }
        });

        yAxis.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        return cursorCoords;
    }


}
