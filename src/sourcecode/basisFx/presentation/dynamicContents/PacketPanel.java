package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;

public class PacketPanel  extends DynamicContentPanel {
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable1 =new ServiceTwoLinkedTable();
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable2 =new ServiceTwoLinkedTable();
    boolean isGridVisibility=false;
    @Override
    public void customeInit() {

        TableWrapper t1 = TableWrapper.newBuilder()
                .setGridLinesVisibility(isGridVisibility)
                .setGridName("Пакеты ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(Packet.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable1)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("packetSize")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();

        TableWrapper t2 = TableWrapper.newBuilder()
                .setGridLinesVisibility(isGridVisibility)
                .setGridName("Реестр цен")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(PacketPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable1)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        TableWrapper t3 = TableWrapper.newBuilder()
                .setGridLinesVisibility(isGridVisibility)
                .setGridName("Размеры пакетов ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(PacketSize.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable2)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Размер пакета")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build()
                )
                .build();

        TableWrapper t4 = TableWrapper.newBuilder()
                .setGridLinesVisibility(isGridVisibility)
                .setGridName("Вместимость пакетов")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
                .setActiveRecordClass(PacketProductAccordance.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable2)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColumnWrapperInt.newBuilder()
                                .setColumnName("Вместимость")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("number")
                                .build()
                )
                .build();



        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(isGridVisibility)
                .setGridName("Управление информацией о пакетах")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setOrganization(
                        new TwoVerticaGrids(
                                new TwoBondGrids(t1.getGridPaneWrapper() ,t2.getGridPaneWrapper() ) ,
                                new TwoBondGrids(t3.getGridPaneWrapper() ,t4.getGridPaneWrapper() )
                        )
                 )
                .build();


        mediatorServiceTwoLinkedTable1.setAccessoryTableWrapper(t2);
        mediatorServiceTwoLinkedTable1.setPrimaryTableWrapper(t1);
        mediatorServiceTwoLinkedTable1.initElements();

        mediatorServiceTwoLinkedTable2.setAccessoryTableWrapper(t4);
        mediatorServiceTwoLinkedTable2.setPrimaryTableWrapper(t3);
        mediatorServiceTwoLinkedTable2.initElements();


    }


}