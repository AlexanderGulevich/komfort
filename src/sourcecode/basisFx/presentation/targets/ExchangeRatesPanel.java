package basisFx.presentation.targets;

import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrganizationButtonTopRightLittleSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.grid.GridOrganizationInnerTwoGridsTwoTables;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {

    private boolean gridVisibility=true;

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
                .setName("currencyTableWrapper")
                .setColumnComputerWidth()
                .setColumnFixed(50d)
                .setColumnFixed(50d)
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
                        ColumnWrapperString.newBuilder()
                                .setColumnName("huy,ui,ui,")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build()
                )
                .build();


        GridPaneWrapper exchangeRatesGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("exchangeRatesGridPaneWrapper")
                .setColumnComputerWidth()
                .setColumnFixed(50d)
                .setColumnFixed(50d)
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









//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setTitle("Курсы валют");
//        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observer.setDomainClass(ExchangeRates.class);
//        observer.setGridColWidth( new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setActiveRecord(dataMapperFabric.exchangeRatesMapper());
//        observer.setColumnWidthByContent(columnFabric.string(KindOfColumn.DOUBLE,"Курсы","exchangeRate",0.3d,true,
//                        (obj,val)->{((ExchangeRates)obj).setExchangeRate( (String ) val);}    ));
//        observer.setColumnWidthByContent( columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
//                (obj, val)->{((ExchangeRates)obj).setStartingDate((LocalDate) val); }  )  );
//
//
//        gridFabric.boundTables(
//                observed,
//                observer,
//                new Coordinate(10d,10d,10d,10d),
//                panel
//        );
//
//
//





    }

}
