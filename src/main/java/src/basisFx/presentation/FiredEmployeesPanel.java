package basisFx.presentation;

import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.events.YNWindowCreaterForTable;
import basisFx.appCore.grid.*;
import basisFx.appCore.panelSets.SingleTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.domain.Fired;
import basisFx.appCore.DynamicContentPanel;

public class FiredEmployeesPanel extends DynamicContentPanel {

    @Override
    public void customDynamicElementsInit() {


        SingleTableSet.builder()
                .aClass(Fired.class)
                .isSortable(false) .isEditable(true)
                .currentWindow(window)
                .cssClass(null)
                .bigTitle(null)
                .littleTitle("Уволенные сотрудники ")
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_DEL_BUT)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_BIG)
                .addButEvent(null)
                .delButEvent( new YNWindowCreaterForTable(
                        new RowDeleteFromTable(),
                        "Вы уверены, что хотите восстановить на работе сотрудника"
                ) )
                .column(
                        ColumnFabric.stringCol( "Фамилия / Имя / Отчество","name",1d,true))
                .build().configure();


    }





}
