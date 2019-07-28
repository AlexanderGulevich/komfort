package basisFx.presentation;

import basisFx.appCore.DynamicContentPanel;
import basisFx.appCore.panelSets.Panel;


public class PriceWritter extends DynamicContentPanel {
    @Override
    protected void customDynamicElementsInit() {


        Panel.builder()
                .commonLabelName("Выгрузка прайса и настройка параметров")
                .fxmlFileName("priceWritter")
                .parent(dynamicContentAnchorHolder)
                .build().configure();
    }

}
