package basisFx.presentation.targets;

import basisFx.appCore.MdiatorSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.table.ColumnWrapperComboBoxVal;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.domain.Counterparty;
import basisFx.domain.Currency;
import basisFx.presentation.TargetPanel;

public class ExchangeRatesPanel extends TargetPanel {

    @Override
    public void init() {

    }
    protected void inift() {
        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Counterparty.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new MdiatorSingleTable())
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperComboBoxVal.newBuilder()
                                .setColumnName("Валюта ")
                                .setIsEditeble(true)
                                .setColumnSize(0.4d)
                                .setColumnName("currency")
                                .build()

                )
                .build();
//        GridTablesBuilder observed=new GridTablesBuilder();
//        observed.setTitle("Список валют");
//        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observed.setDomainClass(Currency.class);
//        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        observed.setActiveRecord(dataMapperFabric.currencyMapper());
//        observed.setColumn( columnFabric.string(KindOfColumn.STRING,"Наименование","name",1d,true,
//                (obj,val)->((Currency)obj).setName((String)val))  );
//
//
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
