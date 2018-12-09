package basisFx.presentation.targets;

import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridLittle;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.GridTwoBondGrids;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {

    private boolean gridVisibility=false;
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();

      @Override
    public void init() {

        TableWrapper leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Валюта ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setActiveRecordClass(Currency.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build())
                .build();


        TableWrapper rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Курсы ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
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

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление валютами и динамика курсов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(
                        new GridTwoBondGrids(
                                leftTableWrapper.getGridPaneWrapper(),
                                rightTableWrapper.getGridPaneWrapper()
                        )

                )
                .build();


        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();
    }



}
