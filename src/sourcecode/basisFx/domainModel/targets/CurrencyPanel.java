package basisFx.domainModel.targets;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.geometry.Pos;

/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CurrencyPanel extends Target {


    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {


        textFabric.createLabel("Список валют", FontsStore.ROBOTO_LIGHT,  Pos.BASELINE_LEFT,25d,
                panel, new Coordinate(10d,0d,null,0d));


        tableViewWrapper = tableFabric.createStandartTable(
                panel,0.7d,new Coordinate(50d, null, 0d, 0d),
                dataMapper.currencyDataMapper(),
                columnFabric.createColumn("Наименование","name",1d,true,
                                (obj,val)->((Currency)obj).setName((String)val))
                );


        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,50d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new Currency());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,50d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();


    }
}
