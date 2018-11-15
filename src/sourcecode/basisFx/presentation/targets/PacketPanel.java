package basisFx.presentation.targets;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridOrgFourGrids;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.service.ServiceMediatorSingleTable;
import basisFx.service.ServiceMediatorTwoLinkedTable;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;

public class PacketPanel  extends TargetPanel {
    private boolean gridVisibility=false;
    private ServiceMediatorTwoLinkedTable mediatorTwoLinkedTable =new ServiceMediatorTwoLinkedTable();
    private ServiceMediatorSingleTable mediatorSingleTable1 =new ServiceMediatorSingleTable();
    private ServiceMediatorSingleTable mediatorSingleTable2 =new ServiceMediatorSingleTable();
    private GridOrgFourGrids gridOrganization =new GridOrgFourGrids();

    @Override
    public void init() {

        TableWrapper packetTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Packet.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.3d)
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
                .setServiceMediator(mediatorTwoLinkedTable)
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
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("packetSize")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Вместимость")
                                .setColumnSize(0.4d)
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
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление информацией о пакетах")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGrids(
                        packetGridPaneWrapper,packetPriceGridPaneWrapper,
                        packetSizeGridWrapper,packetSizeProductAccordanceGridWrapper
                 ))
                .build();


        mediatorTwoLinkedTable.setAccessoryTableWrapper(packetPriceTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(packetTableWrapper);
        mediatorTwoLinkedTable.initElements();


        mediatorSingleTable1.setTableWrapper(packetSizeProductAccordanceTableWrapper);
        mediatorSingleTable1.initElements();
        mediatorSingleTable2.setTableWrapper(packetSizeTableWrapper);
        mediatorSingleTable2.initElements();
    }


}