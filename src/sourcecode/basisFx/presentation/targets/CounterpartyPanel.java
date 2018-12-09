package basisFx.presentation.targets;

import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridBig;
import basisFx.appCore.grid.ButtonsSizeForGridLittle;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.service.ServiceSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.presentation.TargetPanel;

public class CounterpartyPanel extends TargetPanel {
    @Override
    public void init() {
        ServiceSingleTable mediatorSingleTable = new ServiceSingleTable();

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Counterparty.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorSingleTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperComboBox.newBuilder(Currency.class)
                                .setColumnName("Валюта ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setPropertyName("currency")
                                .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridSingleTable(tableWrapper,new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setName("Список контрагентов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }






}
