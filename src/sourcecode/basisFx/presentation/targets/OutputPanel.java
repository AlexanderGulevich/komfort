package basisFx.presentation.targets;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import basisFx.appCore.grid.ButtonsForGridBig;
import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceBlankContentTableAndCommonDate;

public class OutputPanel  extends TargetPanel {

    ServiceBlankContentTableAndCommonDate mediator = new ServiceBlankContentTableAndCommonDate();
    @Override
    public void init() {
        ButtonWrapper buttonWrapper = ButtonFactory.getInstance().submitButton(
                innerAnchorPane,
                new Coordinate(10d, 13d, null, null),
                mediator
        );


        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 8d))
                .setParentAnchor(innerAnchorPane)
                .setServiceMediator(mediator)
                .build();


        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(OutputPerDay.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediator)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Equipment.class)
                                .setColumnName("Станок")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("equipment")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Кол-во стержней")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("numberOfRods")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Packet.class)
                                .setColumnName("Пакет")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("packet")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridOrgTopButSingleTable(tableWrapper,new ButtonsForGridLittle()))
                .setName("Учет выходной продукции")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(50d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
        mediator.setButtonWrapper(buttonWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
