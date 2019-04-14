package basisFx.presentation;

import basisFx.appCore.grid.*;
import basisFx.appCore.interfaces.DataStoreCallBack;
import basisFx.appCore.panelElements.AutoCommitByDateTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.appCore.utils.Registry;
import basisFx.dataSource.BFxPreparedStatement;
import basisFx.domain.*;
import basisFx.appCore.DynamicContentPanel;
import java.sql.Date;
import java.time.LocalDate;

public class TimeRecordingPanel extends DynamicContentPanel {

    @Override
    public void customDynamicElementsInit() {

        DataStoreCallBack callBackForColumn = activeRecord -> {
            TimeRecordingForEmployers entry = (TimeRecordingForEmployers) activeRecord;
            LocalDate date = entry.getDate();
            Integer employerId = entry.getEmployer().getId();
            boolean filled =BFxPreparedStatement
                    .create("SELECT * FROM EmployeesRatePerHour " + "WHERE EMPLOYERID=?" + " and " +" STARTDATE<=?")
                    .setInt(1, employerId)
                    .setDate(2, Date.valueOf(date))
                    .executeAndCheckFilling();
                if (!filled) {
                    Registry.windowFabric.infoWindow("К сожалению, для данной даты не установлен тариф для следующего сотрудника: \n"
                    + entry.getEmployer().getName().toUpperCase().trim()) ;
                    return false;
                }
            return true;
        };

        AutoCommitByDateTableSet.builder()
                .aClass(TimeRecordingForEmployers.class)
                .callBackForColumn(callBackForColumn)
                .isEditable(true).isSortable(false)
                .currentWindow(window)
                .bigTitle("Учет рабочего времени")
                .littleTitle(null)
                .cssClass(null)
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_N_O_N)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_NON)
                .addButEvent(null)
                .delButEvent(null)
                .column(
                        ColumnFabric.comboBoxCol(
                                Employer.class,
                                "Работник",
                                "employer",
                                0.7d,
                                false
                        ))
                .column(
                        ColumnFabric.doubleCol(
                                "Отработанные часы",
                                "hours",
                                0.3d,
                                true
                        )
                )
                .build().configure();

    }

}
