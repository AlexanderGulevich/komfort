package basisFx.presentation;

import basisFx.appCore.grid.*;
import basisFx.appCore.panelSets.SingleTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.appCore.DynamicContentPanel;

public class CounterpartyPanel extends DynamicContentPanel {

    @Override
    public void customDynamicElementsInit() {

        SingleTableSet.builder()
                .aClass(Counterparty.class)
                .isSortable(false)
                .currentWindow(window)
                .isEditable(true)
                .bigTitle(null)
                .littleTitle("Список контрагентов")
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_TOP)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_BIG)
                .addButEvent(null)
                .delButEvent(null)
                .column(
                        ColumnFabric.stringCol(
                                "Наименование","name",0.6d,true
                        )
                )
                .column(
                        ColumnFabric.comboBoxCol(
                                Currency.class,"Валюта ","currency",0.4d,true
                        )
                )
                .build().configure();

    }
}
