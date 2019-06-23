package basisFx.presentation;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.panelSets.AutoCommitByDateTableSet;
import basisFx.appCore.table.ColumnFabric;
import basisFx.appCore.utils.DateViaPopup;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.domain.*;
import basisFx.appCore.DynamicContentPanel;

public class OutputPanel  extends DynamicContentPanel {

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

        AutoCommitByDateTableSet.builder()
                .aClass(OutputPerDay.class)
                .dateGetter(new DateViaPopup())
                .callBackForColumn(null)
                .isEditable(true).isSortable(false)
                .currentWindow(window)
                .bigTitle("Учет выходной продукции")
                .littleTitle(null)
                .cssClass("wrappedHeaderColumn")
                .parentAnchor(dynamicContentAnchorHolder)
                .ctrlPosEnum(CtrlPosEnum.CTRL_POS_BOTTON)
                .butSizeEnum(ButSizeEnum.BUT_SIZE_BIG)
                .addButEvent(null)
                .delButEvent(null)
                .column(ColumnFabric.comboBoxCol(
                                Equipment.class,
                                "Станок",
                                "equipment",
                                0.2d,
                                true
                        ))
                .column(ColumnFabric.comboBoxCol(
                                 Product.class,
                                "Продукт",
                                "product",
                                0.2d,
                                true
                        ))
                .column(ColumnFabric.intCol(
                          "Кол-во\nстержней",
                                "rodsNumber",
                                0.1d,
                                true
                        ))
                .column(ColumnFabric.popup(
                          "Пакет",
                                "packet",
                                0.15d,
                                windowBuilder
                        ))
                .column(ColumnFabric.comboBoxCol(
                                Jumbo.class,
                                "Ширина\n роля",
                                "jumbo",
                                0.15d,
                                true
                ))
                .column(ColumnFabric.comboBoxCol(
                                  Counterparty.class,
                            "Поставщик\n бумаги",
                                "paperCounterparty",
                                0.2d,
                                true
                ))
                .build().configure();

    }

}
