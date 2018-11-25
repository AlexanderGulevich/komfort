package basisFx.presentation.targets;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridOrgFourGrids;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.service.ServiceSingleTable;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;

public class PacketPanel  extends TargetPanel {
    private boolean gridVisibility=false;
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();
    private ServiceSingleTable mediatorSingleTable1 =new ServiceSingleTable();
    private ServiceSingleTable mediatorSingleTable2 =new ServiceSingleTable();
    private GridOrgFourGrids gridOrganization =new GridOrgFourGrids();

    @Override
    public void init() {

        TableWrapper packetTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Packet.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();

        GridPaneWrapper packetGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Пакеты ")
                .setGridOrganization(new GridOrgTopButSingleTable(packetTableWrapper,new ButtonsForGridLittle()))
                .build();

        TableWrapper packetPriceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(PacketPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("rate")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper packetPriceGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Реестр цен")
                .setGridOrganization(new GridOrgTopButSingleTable(packetPriceTableWrapper,new ButtonsForGridLittle()))
                .build();

        TableWrapper packetSizeTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(PacketSize.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorSingleTable1)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Размер")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build()
                )
                .build();

        GridPaneWrapper packetSizeGridWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Размеры пакетов ")
                .setGridOrganization(new GridOrgTopButSingleTable(packetSizeTableWrapper,new ButtonsForGridLittle()))
                .build();


        TableWrapper packetSizeProductAccordanceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(PacketProductAccordance.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorSingleTable2)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("packetSize")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Вместимость")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("number")
                                .build()
                )
                .build();

        GridPaneWrapper packetSizeProductAccordanceGridWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Вместимость пакетов")
                .setGridOrganization(new GridOrgTopButSingleTable(packetSizeProductAccordanceTableWrapper,new ButtonsForGridLittle()))
                .build();


        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(40)
                .setColumnVsPercent(60)
                .setName("Управление информацией о пакетах")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGrids(
                        packetGridPaneWrapper,packetPriceGridPaneWrapper,
                        packetSizeGridWrapper,packetSizeProductAccordanceGridWrapper
                 ))
                .build();


        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(packetPriceTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(packetTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();


        mediatorSingleTable1.setTableWrapper(packetSizeProductAccordanceTableWrapper);
        mediatorSingleTable1.initElements();
        mediatorSingleTable2.setTableWrapper(packetSizeTableWrapper);
        mediatorSingleTable2.initElements();
    }


}