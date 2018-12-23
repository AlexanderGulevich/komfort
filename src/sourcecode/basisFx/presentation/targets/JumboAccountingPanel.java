package basisFx.presentation.targets;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridBig;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceAutoPushTableAndCommonDate;

public class JumboAccountingPanel extends TargetPanel {
    ServiceAutoPushTableAndCommonDate mediator = new ServiceAutoPushTableAndCommonDate();

    @Override
    public void init() {

        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 5d))
                .setParentAnchor(innerAnchorPane)
                .setServiceMediator(mediator)
                .build();


        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(JumboAccounting.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediator)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Контрагент")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build(),
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Общий вес ролей")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("overallWeight")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridSingleTable(tableWrapper,new ButtonsSizeForGridBig(),new ButPositionTop()))
                .setGridName("Учет джамбо-ролей")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(50d, 10d, 10d, 0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
