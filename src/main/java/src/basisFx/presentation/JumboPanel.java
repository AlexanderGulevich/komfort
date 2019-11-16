package basisFx.presentation;

import basisFx.appCore.grid.*;
import basisFx.appCore.panelSets.SingleTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.domain.Jumbo;
import basisFx.appCore.DynamicContentPanel;

public class JumboPanel extends DynamicContentPanel {
    @Override
    public void customDynamicElementsInit() {

        SingleTableSet.builder()
                .aClass(Jumbo.class)
                .isSortable(false) .isEditable(true)
                .currentWindow(window)
                .bigTitle(null)
                .littleTitle("Ширины джамбо ролей и выход продукции по ширине")
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_TOP)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_BIG)
                .addButEvent(null)
                .delButEvent(null)
                .column(
                        ColumnFabric.intCol(
                                "Ширина","width",0.6d,true
                        )
                )
                .column(
                        ColumnFabric.intCol(
                                "Кол-во продукции на выходе ","numberOfProduct",0.4d,true
                        )
                )
                .build().configure();




    }

}
