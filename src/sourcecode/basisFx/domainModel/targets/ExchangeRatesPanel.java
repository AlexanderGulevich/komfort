package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;
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

////////////////////////////////////////////////////////


        currencySide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,null,0d,0d));

        textFabric.createLabel("Список валют ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                currencySide, new Coordinate(10d,0d,null,0d));


        currencyTable =tableFabric.createStandartTable(
                panel,0.45d,new Coordinate(50d, null, 70d, 0d),
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
