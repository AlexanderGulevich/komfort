package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.KindOfColumn;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;
import basisFx.domainModel.domaine.ExchangeRates;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class ExchangeRatesPanel extends Target{

    private TableWrapper currencyTable;
    private TableWrapper rateTable;
    private AnchorPane currencySide;
    private AnchorPane rateSide;

    @Override
    protected void createElement() {

        rateSide=innerPanelsFabric.createInnerPanels(panel,0.53,new Coordinate(0d,0d,0d,null));

        textFabric.createLabel("Курсы валют", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                rateSide, new Coordinate(10d,0d,null,0d));

        rateTable =tableFabric.table(
                panel,0.53d,new Coordinate(50d, 0d, 70d, null),
                dataMapper.exchangeRatesDataMapper(),
                columnFabric.createColumn(KindOfColumn.DOUBLE,"Курсы","exchangeRate",0.3d,true,
                        (obj,val)->{((ExchangeRates)obj).setExchangeRate( (String ) val);}
                ),
                columnFabric.createDateColumn(KindOfColumn.DATE,"Дата начала действия ","startingDate",0.7d,true,
                        (obj, val)->{((ExchangeRates)obj).setStartingDate((LocalDate) val); }
                )
        );

        buttonFactory.addRowButton(
                rateSide,new Coordinate(null,0d, 10d, null), rateTable,ExchangeRates.class);
        buttonFactory.deleteRowButton(
                rateSide,new Coordinate(null,180d, 10d, null), rateTable);

////////////////////////////////////////////////////////

        currencySide=innerPanelsFabric.createInnerPanels(panel,0.45,new Coordinate(0d,null,0d,0d));

        textFabric.createLabel("Список валют ", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_CENTER,25d,
                currencySide, new Coordinate(10d,0d,null,0d));


        currencyTable =tableFabric.boundTable(
                rateTable, panel,
                0.45d, new Coordinate(50d, null, 70d, 0d),
                dataMapper.currencyDataMapper(),

                columnFabric.createColumn(KindOfColumn.STRING,"Наименование","name",1d,true,
                        (obj,val)->((Currency)obj).setName((String)val))
        );

        buttonFactory.addRowButton(
                currencySide,new Coordinate(null,0d, 10d, null), currencyTable,Currency.class);
        buttonFactory.deleteRowButton(
                currencySide,new Coordinate(null,180d, 10d, null), currencyTable);


////////////////////////////////////////////////////












    }

}
