package basisFx.presentation.targets;

import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrganizationButtonTopRightLittleSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.grid.GridOrganizationInnerTwoGridsTwoTables;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {

    private boolean gridVisibility=false;

    @Override
    public void init() {
        MediatorTwoLinkedTable mediatorTwoLinkedTable =
                new MediatorTwoLinkedTable();
        GridOrganizationInnerTwoGridsTwoTables gridOrganization =
                new GridOrganizationInnerTwoGridsTwoTables();

        TableWrapper currencyTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Currency.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build())
                .build();

        GridPaneWrapper currencyGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Валюта")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(currencyTableWrapper))
                .build();

        TableWrapper exchangeRatesTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("exchangeRate")
                                .build()
                )
                .build();


        GridPaneWrapper exchangeRatesGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Курсы")
                .setColumnComputerWidth()
                .setColumnFixed(40d)
                .setColumnFixed(40d)
                .setGridOrganization(new GridOrganizationButtonTopRightLittleSingleTable(exchangeRatesTableWrapper))
                .build();

        mediatorTwoLinkedTable.setAccessoryTableWrapper(exchangeRatesTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(currencyTableWrapper);

        gridOrganization.setLeftGridWrapper(currencyGridPaneWrapper);
        gridOrganization.setRightGridWrapper(exchangeRatesGridPaneWrapper);

        GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление валютами и динамика курсов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization)
                .build();

    }

}
