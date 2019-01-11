package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceAutoCommitTableByCommonDate;

public class JumboAccountingPanel extends DynamicContentPanel {
    ServiceAutoCommitTableByCommonDate mediator = new ServiceAutoCommitTableByCommonDate();

    @Override
    public void customeInit() {

        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 5d))
                .setParentAnchor(dynamicContentAnchorHolder)
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
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new ButPosTop()))
                .setGridName("Учет джамбо-ролей")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(50d, 10d, 10d, 0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
