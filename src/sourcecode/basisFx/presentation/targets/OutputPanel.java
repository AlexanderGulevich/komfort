package basisFx.presentation.targets;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperInt;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceAutoPushTableAndCommonDate;

public class OutputPanel  extends TargetPanel {

    ServiceAutoPushTableAndCommonDate mediator = new ServiceAutoPushTableAndCommonDate();
    @Override
    public void init() {

        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 5d))
                .setParentAnchor(innerAnchorPane)
                .setServiceMediator(mediator)
                .build();


        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(OutputPerDay.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediator)
                .setClass("wrappedHeaderColumn")
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Equipment.class)
                                .setColumnName("Станок")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("equipment")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукт")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Кол-во\nстержней")
                                .setColumnSize(0.1d)
                                .setIsEditeble(true)
                                .setPropertyName("rodsNumber")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Packet.class)
                                .setColumnName("Размер пакета")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("packet")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик \nпакета")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Packet.class)
                                .setColumnName("Ширина\n роля")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("packet")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик\n бумаги")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridSingleTable(tableWrapper,new ButtonsSizeForGridBig(),new ButPositionTop()))
                .setName("Учет выходной продукции")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(50d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
//        mediator.setButtonWrapper(buttonWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
