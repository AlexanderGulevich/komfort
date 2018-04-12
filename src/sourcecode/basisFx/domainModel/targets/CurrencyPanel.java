package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.Currency;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CurrencyPanel extends Target {


    private TableViewWrapper tableViewWrapper;
    @Override
    protected void createElement() {
        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Currency>createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCurrencyDataMapper())
                .setDbTableName("Currency").refresh()
                .setColums(
                        columnFabric.createStringColumn("Наименование","stringValue",1d,
                                (obj,val)->((Currency)obj).setStringValue((String)val))
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
