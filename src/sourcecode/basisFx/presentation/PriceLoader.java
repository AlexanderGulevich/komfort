package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.chart.ChartBfxXY;
import basisFx.appCore.chart.ChartData_XY;
import basisFx.appCore.panelSets.ChartPanel;
import basisFx.appCore.panelSets.Panel;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.PACKETRESULTFULL;

import java.time.ZoneId;
import java.util.GregorianCalendar;


public class PriceLoader extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {


        Panel.builder()
                .commonLabelName("Загрузка и проверка прайса")
                .fxmlFileName("priceLoader")
                .parent(dynamicContentAnchorHolder)
                .build().configure();
    }

}
