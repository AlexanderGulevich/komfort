package basisFx.presentation.targets;

import basisFx.appCore.MdiatorSingleTable;
import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBoxVal;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {


    @Override
    public void init() {
        MediatorTwoLinkedTable mediatorTwoLinkedTable = new MediatorTwoLinkedTable();

        TableWrapper currencyTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Currency.class)
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
                                .build())
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
                                .build())
                .build();

        mediatorTwoLinkedTable.setAccessoryTableWrapper(exchangeRatesTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(currencyTableWrapper);

        GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление валютами и динамика курсов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();





//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setTitle("Курсы валют");
//        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observer.setDomainClass(ExchangeRates.class);
//        observer.setGridColWidth( new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setActiveRecord(dataMapperFabric.exchangeRatesMapper());
//        observer.setColumn(columnFabric.string(KindOfColumn.DOUBLE,"Курсы","exchangeRate",0.3d,true,
//                        (obj,val)->{((ExchangeRates)obj).setExchangeRate( (String ) val);}    ));
//        observer.setColumn( columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
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
