package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.controls.TablesButtonKind;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridColWidth;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.KindOfGridCol;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;
import basisFx.domainModel.domaine.ExchangeRates;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class ExchangeRatesPanel extends Target{

    private TableWrapper currencyTable;
    private TableWrapper rateTable;
    private AnchorPane currencySide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {

        GridTablesBuilder observed=new GridTablesBuilder();
        observed.setTitle("Список валют");
        observed.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observed.setDomainClass(Currency.class);
        observed.setDataMapper(dataMapper.currencyDataMapper());
        observed.setColumn( columnFabric.stringColumn(KindOfColumn.STRING,"Наименование","name",1d,true,
                (obj,val)->((Currency)obj).setName((String)val))  );
        gridFabric.singleAnchorGridTable(observed);



        GridTablesBuilder observer=new GridTablesBuilder();
        observer.setTitle("Курсы валют");
        observer.setTablesButtonKind(TablesButtonKind.Bottom_right);
        observer.setDomainClass(ExchangeRates.class);
        observer.setDataMapper(dataMapper.exchangeRatesDataMapper());
        observer.setColumn(columnFabric.stringColumn(KindOfColumn.DOUBLE,"Курсы","exchangeRate",0.3d,true,
                        (obj,val)->{((ExchangeRates)obj).setExchangeRate( (String ) val);}    ));
        observer.setColumn( columnFabric.dateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
                (obj, val)->{((ExchangeRates)obj).setStartingDate((LocalDate) val); }  )  );
        gridFabric.singleAnchorGridTable(observer);




        gridFabric.boundTables(
                observed,
                observer,
                new GridColWidth(KindOfGridCol.percent,60d),
                new GridColWidth(KindOfGridCol.percent,40d),
                new Coordinate(10d,10d,10d,10d),
                panel
        );








    }

}
