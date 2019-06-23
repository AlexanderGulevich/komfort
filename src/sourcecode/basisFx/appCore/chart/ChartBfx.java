package basisFx.appCore.chart;

import basisFx.service.ServiceChartPanels;
import javafx.scene.layout.AnchorPane;

import java.util.Calendar;
import java.util.List;

public interface ChartBfx {
    void configure();
    void setParent(AnchorPane anchorPane);
    void setService(ServiceChartPanels service);
    void setData( List data) ;
    void applyPeriod(Calendar before, Calendar after) ;
    void applyAllTime() ;
    Class getAClass() ;



}
