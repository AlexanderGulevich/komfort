package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;
import basisFx.domainModel.domaine.ExchangeRates;
import basisFx.domainModel.domaine.RatePerHour;
import basisFx.domainModel.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class ExchangeRatesPanel extends Target{


    private TableViewWrapper currencyTable;
    private TableViewWrapper rateTable;
    private AnchorPane currencySide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {


        rateSide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,0d,0d,null));


        textFabric.createLabel("Курсы валют", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                rateSide, new Coordinate(10d,0d,null,0d));


        rateTable =tableFabric.createStandartTable(
                panel,0.45d,new Coordinate(50d, 0d, 70d, null),
                dataMapperFabric.getExchangeRatesDataMapper(),
                columnFabric.createStringColumn("Курсы","exchangeRate",0.3d,
                        (obj,val)->{((RatePerHour)obj).setRate((StringValueDomainObject) val);}
                ),
                columnFabric.createLocalDateColumn(ColumnWrapper.Bulder.create()
                        .setColumnName("Дата начала действия ") .setPropertyName("startingDate").setColumnSize(0.7d)
                        .setDomainChangeAction((obj,val)->{((ExchangeRates)obj).setStartingDate((LocalDate) val); } )
                )
        );




        buttonFactory.createStandartAddButton(
                rateSide,new Coordinate(null,0d, 10d, null), currencyTable,ExchangeRates.class);
        buttonFactory.createStandartDeleteButton(
                rateSide,new Coordinate(null,180d, 10d, null), currencyTable);




////////////////////////////////////////////////////////

        currencySide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,null,0d,0d));

        textFabric.createLabel("Список валют ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                currencySide, new Coordinate(10d,0d,null,0d));


        currencyTable =tableFabric.createBoundTable(
                rateTable, panel,
                0.45d, new Coordinate(50d, null, 70d, 0d),
                dataMapperFabric.getCurrencyDataMapper(),

                columnFabric.createStringColumn("Наименование","stringValue",1d,
                        (obj,val)->((Currency)obj).setStringValue((String)val))
        );

        buttonFactory.createStandartAddButton(
                currencySide,new Coordinate(null,0d, 10d, null), currencyTable,Currency.class);
        buttonFactory.createStandartDeleteButton(
                currencySide,new Coordinate(null,180d, 10d, null), currencyTable);


////////////////////////////////////////////////////












    }

}
