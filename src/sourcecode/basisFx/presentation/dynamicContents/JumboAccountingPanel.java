package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesAutoCommitByDate;

public class JumboAccountingPanel extends DynamicContentPanel {
    private ServiceTablesAutoCommitByDate mediator;
    private DatePickerWrapper datePickerWrapper;
    private TableWrapper tableWrapper;

    @Override
    public void createServices() {
        mediator = new ServiceTablesAutoCommitByDate();
    }

    @Override
    public void customDynamicElementsInit() {

        datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 5d))
                .setParentAnchor(dynamicContentAnchorHolder)
                .setServiceTables(mediator)
                .build();


        tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(JumboAccounting.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Контрагент")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build(),
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Общий вес ролей")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("overallWeight")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new CtrlPosTop()))
                .setGridName("Учет джамбо-ролей")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(50d, 10d, 10d, 0d))
                .setGridLinesVisibility(false)
                .build();


    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(tableWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
