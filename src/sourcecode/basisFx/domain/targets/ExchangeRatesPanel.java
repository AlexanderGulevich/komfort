//package basisFx.domain.targets;
//
//import basisFx.appCore.controls.KindOfColumn;
//import basisFx.appCore.grid.TablesButtonKind;
//import basisFx.appCore.elements.TableWrapper;
//import basisFx.appCore.grid.GridColWidth;
//import basisFx.appCore.grid.GridTablesBuilder;
//import basisFx.appCore.grid.KindOfGridCol;
//import basisFx.appCore.utils.Coordinate;
//import basisFx.domain.domaine.Currency;
//import basisFx.domain.domaine.ExchangeRates;
//import javafx.scene.layout.AnchorPane;
//
//import java.time.LocalDate;
//
//public class ExchangeRatesPanel extends Target{
//
//    private TableWrapper currencyTable;
//    private TableWrapper rateTable;
//    private AnchorPane currencySide;
//    private AnchorPane rateSide;
//
//    @Override
//    protected void configurate() {
//
//        GridTablesBuilder observed=new GridTablesBuilder();
//        observed.setTitle("Список валют");
//        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observed.setDomainClass(Currency.class);
//        observed.setGridColWidth(new GridColWidth(KindOfGridCol.percent,60d));
//        observed.setDataMapper(dataMapperFabric.currencyMapper());
//        observed.setColumn( columnFabric.string(KindOfColumn.STRING,"Наименование","name",1d,true,
//                (obj,val)->((Currency)obj).setName((String)val))  );
//
//
//        GridTablesBuilder observer=new GridTablesBuilder();
//        observer.setTitle("Курсы валют");
//        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
//        observer.setDomainClass(ExchangeRates.class);
//        observer.setGridColWidth( new GridColWidth(KindOfGridCol.percent,40d));
//        observer.setDataMapper(dataMapperFabric.exchangeRatesMapper());
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
//
//
//
//
//
//    }
//
//}
