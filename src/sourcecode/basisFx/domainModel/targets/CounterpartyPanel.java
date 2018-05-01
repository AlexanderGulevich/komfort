package basisFx.domainModel.targets;

import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Currency;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class CounterpartyPanel extends Target{
    
    private TableWrapper tableWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {

        tableWrapper = tableFabric.table(panel,0.8d,new Coordinate(50d, null, 0d, 0d),
                dataMapper.counterpartyDataMapper(),
                        columnFabric.createColumn(KindOfColumn.STRING,
                                "Наименование контрагента","name",0.5,true,
                                (obj,val)->((basisFx.domainModel.domaine.Counterparty)obj).setName((String)val)),
                        columnFabric.createColumnComboBox(KindOfColumn.COMBOBOX,
                                "Валюта","currency",0.2,true,
                                (obj,val)->{((Counterparty)obj).setCurrency((Currency) val);},
                                () -> dataMapper.counterpartyDataMapper().getCurrencyList()
                        )
                );







        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 80d,0d, null, null)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{l.add(new basisFx.domainModel.domaine.Counterparty());}))
                .createNButton();

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, 120d,0d, null, null)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton();





    }


    


}
