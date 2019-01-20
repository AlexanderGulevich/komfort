package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;

public class PacketPanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable1;
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable2;
    private TableWrapper t1;
    private TableWrapper t2;
    private TableWrapper t3;
    private TableWrapper t4;

    @Override
    public void createServices() {
            mediatorServiceTwoLinkedTable1 =new ServiceTablesTwoLinked();
            mediatorServiceTwoLinkedTable2 =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

          t1 = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Пакеты ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Packet.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable1)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("packetSize")
                                .build(),
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();

          t2 = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Реестр цен")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(PacketPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable1)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();

          t3 = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Размеры пакетов ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(PacketSize.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable2)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Размер пакета")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build()
                )
                .build();

          t4 = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Вместимость пакетов")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(PacketProductAccordance.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable2)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColWrapperInt.newBuilder()
                                .setColumnName("Вместимость")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("number")
                                .build()
                )
                .build();



        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Управление информацией о пакетах")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setOrganization(
                        new TwoVerticaGrids(
                                new TwoHorisontalBondGrids(t1.getGridPaneWrapper() ,t2.getGridPaneWrapper() ) ,
                                new TwoHorisontalBondGrids(t3.getGridPaneWrapper() ,t4.getGridPaneWrapper() )
                        )
                 )
                .build();

    }

    @Override
    public void initServices() {
        mediatorServiceTwoLinkedTable1.setAccessoryTableWrapper(t2);
        mediatorServiceTwoLinkedTable1.setPrimaryTableWrapper(t1);
        mediatorServiceTwoLinkedTable1.initElements();

        mediatorServiceTwoLinkedTable2.setAccessoryTableWrapper(t4);
        mediatorServiceTwoLinkedTable2.setPrimaryTableWrapper(t3);
        mediatorServiceTwoLinkedTable2.initElements();
    }


}