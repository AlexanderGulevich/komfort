package basisFx.domainModel.targets;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.domaine.Country;
import basisFx.domainModel.domaine.Currency;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class CounterpartyPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .createTableViewWrapper()
                .setTablesWidthProperty(0.8, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCounterpartyDataMapper())
                .setDbTableName("CounterpartyPanel").refresh()
                .setColums(
////////////////////////////////
                        columnFabric.createStringColumn(
                                "Наименование контрагента","stringValue",0.5,
                                (obj,val)->((basisFx.domainModel.domaine.Counterparty)obj).setStringValue((String)val)),

////////////////////////////////
                        columnFabric.createColumnStringComboBox(
                                "Страна","country",0.3,
                                (obj,val)->{((basisFx.domainModel.domaine.Counterparty)obj).setCountry((Country) val);},
                                () -> dataMapperFabric.getCounterpartyDataMapper().getCountryList()
                        ),
////////////////////////////////////////////////////////////////
                        columnFabric.createColumnStringComboBox(
                                "Валюта","currency",0.2,
                                (obj,val)->{((basisFx.domainModel.domaine.Counterparty)obj).setCurrency((Currency) val);},
                                () -> dataMapperFabric.getCounterpartyDataMapper().getCurrencyList()
                        )
                );
////////////////////////////////








        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,0d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new basisFx.domainModel.domaine.Counterparty());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,0d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();





    }

   
    


}
