package basisFx.presentation;

import basisFx.appCore.elements.*;
import basisFx.appCore.grid.*;
import basisFx.appCore.panelElements.SingleTableSet;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.table.ColumnFabric;
import basisFx.appCore.utils.Range;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import javafx.scene.control.ComboBox;

public class SleevePanel  extends DynamicContentPanel {

    @Override
    public void customDynamicElementsInit() {

        SingleTableSet.builder()
                .aClass(SleevePrice.class)
                .isSortable(false) .isEditable(true)
                .currentWindow(window)
                .bigTitle(null)
                .littleTitle("Цена втулок")
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_BUT_AND_COMBOBOX)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_LITTLE)
                .addButEvent(null)
                .delButEvent(null)
                .column(
                        ColumnFabric.doubleCol(
                                "Цена","price",0.4d,true
                        )
                )
                .column(
                        ColumnFabric.dateCol(
                                "Действует с","startDate",0.6d,true
                        )
                )
                .build().configure();

    }



}
