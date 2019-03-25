package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;

public class PacketPanel  extends DynamicContentPanel {
    private ServiceTablesSingle serviceTablesSingle1;
    private ServiceTablesSingle serviceTablesSingle2;
    private TableWrapper packet;
    private TableWrapper capacity;

    @Override
    public void createServices() {
            serviceTablesSingle1 =new ServiceTablesSingle();
            serviceTablesSingle2 =new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

        WindowBuilder dateResearchWindowBuilder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setButtonsForStage(null)
                .setDynamicContentPanelCreator(PacketPricePanelPopup::new)
                .setTitle("Реестр цен")
                .setMessage(null)
                .setFxmlFileName("ByDateResearchWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(700d)
                .setHeight(600d)
                .setCallBack(
                        () -> {
                            TableWrapper tableWrapper =(TableWrapper)   Registry.mainWindow.getNodeFromMap("outer_table_wrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();

        WindowBuilder packetSize = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setDynamicContentPanelCreator(PacketSizePanel::new)
                .setTitle("Размеры пакетов")
                .setMessage(null)
                .setFxmlFileName("AddDellPopupWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(700d)
                .setHeight(600d)
                .setCallBack(
                        () -> {
                            TableWrapper tableWrapper = (TableWrapper) Registry.mainWindow.getNodeFromMap("outer_table_wrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();

        WindowBuilder counterparty = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setDynamicContentPanelCreator(CounterpartyPanelPopup::new)
                .setTitle("Список контрагентов")
                .setMessage(null)
                .setFxmlFileName("AddDellPopupWindow")
                .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
                .setWidth(700d)
                .setHeight(600d)
                .setCallBack(
                        () -> {
                            TableWrapper tableWrapper = (TableWrapper) Registry.mainWindow.getNodeFromMap("outer_table_wrapper");
                            tableWrapper.getMediator().refresh(tableWrapper);
                        })
                .build();

        packet = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Пакеты ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Packet.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(serviceTablesSingle1)
                .setColWrappers(
                        ColWrapperPopup.newBuilder()
                                .setColumnName("Размер")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setWindowBuilder(packetSize)
                                .setPropertyName("packetSize")
                                .build(),
                        ColWrapperPopup.newBuilder()
                                .setColumnName("Поставщик")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setWindowBuilder(counterparty)
                                .setPropertyName("counterparty")
                                .build(),
                        ColWrapperBind.newBuilder()
                                .setColumnName("Валюта")
                                .setColumnSize(0.2d)
                                .setCallBackTypedAndParametrized(
                                        r -> {
                                            Packet var = (Packet) r;
                                            if (!ActiveRecord.isNewDomane(var)) {
                                                return var.getCounterparty().currencyProperty();
                                            }
                                            else return null;
                                        }
                                )
                                .build(),
                        ColWrapperPopupViaBtn.newBuilder()
                                .setBtnName("Архив цен")
                                .setColumnName("Архив цен")
                                .setColumnSize(0.2d)
                                .setWindowBuilder(dateResearchWindowBuilder)
                                .build()
                )
                .build();


        Registry.mainWindow.setNodeToMap(packet,"outer_table_wrapper");



          capacity = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Вместимость пакетов")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(PacketProductAccordance.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(serviceTablesSingle2)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукция")
                                .setColumnSize(0.5d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColWrapperComboBox.newBuilder(PacketSize.class)
                                .setColumnName("Размер")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("packetSize")
                                .build(),
                        ColWrapperInt.newBuilder()
                                .setColumnName("Кол-во")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("number")
                                .build()
                )
                .build();



        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(false)
                .setColumnVsPercent(100)
                .setGridName("Управление информацией о пакетах")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setOrganization(
                        new TwoVerticaGrids(
                                new SingleTable(packet,new ButSizeBig(),new CtrlPosTop())  , "Пакеты",
                                new SingleTable(capacity,new ButSizeBig(),new CtrlPosTop()), "Вместимость пакетов"
                 )
                )
                .build();

    }

    @Override
    public void initServices() {
        serviceTablesSingle1.setTableWrapper(packet);
        serviceTablesSingle1.initElements();

        serviceTablesSingle2.setTableWrapper(capacity);
        serviceTablesSingle2.initElements();
    }


}