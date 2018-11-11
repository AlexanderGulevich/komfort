package basisFx.presentation.targets;

import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.mediators.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.grid.GridOrgTwoBondGrids;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {

    private boolean gridVisibility=false;
    private MediatorTwoLinkedTable mediatorTwoLinkedTable =new MediatorTwoLinkedTable();
    private GridOrgTwoBondGrids gridOrganization =new GridOrgTwoBondGrids();

      @Override
    public void init() {

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
                .setGridOrganization(new GridOrgTopButSingleTable(currencyTableWrapper,new ButtonsForGridLittle()))
                .build();

        TableWrapper exchangeRatesTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Курс")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("exchangeRate")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper exchangeRatesGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Курсы")
                .setGridOrganization(new GridOrgTopButSingleTable(exchangeRatesTableWrapper,new ButtonsForGridLittle()))
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление валютами и динамика курсов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGridWrappers(currencyGridPaneWrapper,exchangeRatesGridPaneWrapper))
                .build();


        mediatorTwoLinkedTable.setAccessoryTableWrapper(exchangeRatesTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(currencyTableWrapper);
        mediatorTwoLinkedTable.initElements();
    }



}
