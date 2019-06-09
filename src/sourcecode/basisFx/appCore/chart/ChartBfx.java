package basisFx.appCore.chart;

import basisFx.service.ServiceChartPanels;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public interface ChartBfx {
    void configure();
    void setParent(AnchorPane anchorPane);
    void setService(ServiceChartPanels service);
    void setData( List data) ;
    Class getAClass() ;



}
