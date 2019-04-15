package basisFx.presentation;

import basisFx.appCore.activeRecord.ActiveRecord;
import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.panelElements.TwoBindTableSet;
import basisFx.appCore.table.*;
import basisFx.appCore.utils.Range;
import basisFx.domain.*;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.utils.Coordinate;
import javafx.scene.control.ComboBox;

public class PaperPanel  extends DynamicContentPanel {

    @Override
    public void customDynamicElementsInit() {
        TwoBindTableSet.builder()
                .aClassLeft(Paper.class).aClassRight(PaperPrice.class)
                .bigTitle("Поставщики бумаги и цены")
                .littleTitleLeft("Бумага").littleTitleRight("Цены")
                .percentWidthLeft(70).percentWidthRight(30)
                .parentAnchor(dynamicContentAnchorHolder)
                .currentWindow(window)
                .leftCols(
                        ColumnFabric.comboBoxCol(
                                Counterparty.class,"Поставщик","counterparty",0.7d,true
                        ))
                .leftCols(
                        ColumnFabric.bindCol(
                                "Валюта", 0.3d,
                                r -> {
                                    Paper var = (Paper) r;
                                    if (!ActiveRecord.isNewDomane(var)) {
                                        return  var.counterpartyProperty();
                                    }
                                    else return null;
                                }
                        ))
                .rightCols(
                        ColumnFabric.doubleCol(
                                "Цена","price",0.4d,true
                        ))
                .rightCols(
                        ColumnFabric.dateCol(
                                "Действует с","startDate",0.6d,true
                        ))
                .build().configure();


    }

}
