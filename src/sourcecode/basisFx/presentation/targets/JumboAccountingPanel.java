package basisFx.presentation.targets;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceBlankContentTableAndCommonDate;

public class JumboAccountingPanel extends TargetPanel {
    ServiceBlankContentTableAndCommonDate mediator = new ServiceBlankContentTableAndCommonDate();

    @Override
    public void init() {
//        ButtonWrapper buttonWrapper = ButtonFactory.getInstance().submitButton(
//                innerAnchorPane,
//                new Coordinate(10d, 13d, null, null),
//                mediator
//        );


        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 8d))
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
                .setGridOrganization(new GridOrgTopButSingleTable(tableWrapper, new ButtonsForGridLittle()))
                .setName("Учет джамбо-ролей")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(50d, 10d, 10d, 0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
//        mediator.setButtonWrapper(buttonWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
