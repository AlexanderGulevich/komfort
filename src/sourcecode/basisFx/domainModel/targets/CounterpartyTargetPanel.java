package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.panels.Target;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.pojo.Currency;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class CounterpartyTargetPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Counterparty>createTableViewWrapper()
                .setTablesWidthProperty(0.8, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getCounterpartyDataMapper())
                .setDbTableName("Counterparty").refresh()
                .setColums(
////////////////////////////////
                        columnFabric.createStringColumn(ColumnWrapper.Bulder.create()
                                .setColumnName("Наименование контрагента").setPropertyName("stringValue")
                                .setValueChecking(check.createTextCheck())
                                .setColumnSize(0.5)
                                .setDomainChangeAction(
                                        (obj,val)->{((Counterparty)obj).setStringValue((String)val);}
                                )
                        ),
////////////////////////////////
                        columnFabric.createColumnStringComboBox(ColumnWrapper.Bulder.create()
                                .setColumnName("Страна").setColumnSize(0.3).setPropertyName("country")
                                .setDomainObjectListGetter(() -> dataMapperFabric.getCounterpartyDataMapper().getCountryList())
                                .setDomainChangeAction(
                                        (obj,val)->{((Counterparty)obj).setCountry((Country) val);}
                                )
                        ),
////////////////////////////////////////////////////////////////
                        columnFabric.createColumnStringComboBox(ColumnWrapper.Bulder.create()
                                .setColumnName("Валюта").setColumnSize(0.2).setPropertyName("currency")
                                .setDomainObjectListGetter(() -> dataMapperFabric.getCounterpartyDataMapper().getCurrencyList())
                                .setDomainChangeAction(
                                        (obj,val)->{((Counterparty)obj).setCurrency((Currency) val);}
                                )
                        )
////////////////////////////////




                );



        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,0d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{l.add(new Counterparty());}))
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
