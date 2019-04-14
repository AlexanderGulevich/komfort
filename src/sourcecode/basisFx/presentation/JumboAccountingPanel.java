package basisFx.presentation;

import basisFx.appCore.grid.*;
import basisFx.appCore.panelElements.AutoCommitByDateTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.domain.*;
import basisFx.appCore.DynamicContentPanel;

public class JumboAccountingPanel extends DynamicContentPanel {
    @Override
    public void customDynamicElementsInit() {

        AutoCommitByDateTableSet.builder()
                .aClass(JumboAccounting.class)
                .callBackForColumn(null)
                .isEditable(true).isSortable(false)
                .currentWindow(window)
                .bigTitle("Учет джамбо-ролей за день")
                .littleTitle(null)
                .cssClass(null)
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_BOTTON)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_BIG)
                .addButEvent(null)
                .delButEvent(null)
                .column(
                        ColumnFabric.comboBoxCol(
                                Counterparty.class,
                                "Контрагент",
                                "counterparty",
                                0.7d,
                                false
                        ))
                .column(
                        ColumnFabric.doubleCol(
                                "Общий вес ролей",
                                "overallWeight",
                                0.3d,
                                true
                        ))
                .build().configure();


    }

}
