package basisFx.presentation;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperInt;
import basisFx.appCore.table.ColWrapperPopup;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.*;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesAutoCommitByDate;
import javafx.geometry.Pos;

public class OutputPanel  extends DynamicContentPanel {

    private ServiceTablesAutoCommitByDate mediator;
    private DatePickerWrapper datePickerWrapper;
    private TableWrapper tableWrapper ;
    private LabelWrapper label;
    private ButSizeBig butSizeBig;

    @Override
    public void createServices() {
        mediator = new ServiceTablesAutoCommitByDate();
    }

    @Override
    public void customDynamicElementsInit() {
        WindowBuilder windowBuilder = WindowBuilder.newBuilder()
                .setGUIStructura(null)
                .setPanelCreator(PacketForPopup::new)
                .setTitle("Пакет")
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

        datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, 15d, null, null))
                .setParentAnchor(dynamicContentAnchorHolder)
                .setServiceTables(mediator)
                .build();


        label = LabelWrapper.newBuilder()
                .setCssClasses(CSSclasses.LABEL_COMMON)
                .setText("Учет выходной продукции")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 300d, null, 10d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setAlignment(Pos.TOP_LEFT)
                .setFontSize(30d)
                .build();


          tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(OutputPerDay.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setClass("wrappedHeaderColumn")
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Equipment.class)
                                .setColumnName("Станок")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("equipment")
                                .build(),
                        ColWrapperComboBox.newBuilder(Product.class)
                                .setColumnName("Продукт")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("product")
                                .build(),
                        ColWrapperInt.newBuilder()
                                .setColumnName("Кол-во\nстержней")
                                .setColumnSize(0.1d)
                                .setIsEditeble(true)
                                .setPropertyName("rodsNumber")
                                .build(),
                        ColWrapperPopup.newBuilder()
                                .setColumnName("Пакет")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setWindowBuilder(windowBuilder)
                                .setPropertyName("packet")
                                .build(),
                        ColWrapperComboBox.newBuilder(Jumbo.class)
                                .setColumnName("Ширина\n роля")
                                .setColumnSize(0.15d)
                                .setIsEditeble(true)
                                .setPropertyName("jumbo")
                                .build(),
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик\n бумаги")
                                .setColumnSize(0.2d)
                                .setIsEditeble(true)
                                .setPropertyName("paperCounterparty")
                                .build()
                )
                .build();

        butSizeBig = new ButSizeBig();
        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper, butSizeBig,new CtrlPosBotton()))
                .setGridName(null)
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(50d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(tableWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.setButtonWrapper(butSizeBig.getButtonWrapperAdd());
        mediator.initElements();
    }
}
