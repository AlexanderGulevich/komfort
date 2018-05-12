package basisFx.domainModel.targets;

import basisFx.appCore.controls.*;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Currency;

/**
 *
 * @author Alek
 */
public class CounterpartyPanel extends Target{
    
    private TableWrapper tableWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void configurate() {

        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Наименование yаименование  name name");
        tr.setTablesButtonKind(TablesButtonKind.Bottom_right);
        tr.setDomainClass(Currency.class);
        tr.setDataMapper(dataMapper.currencyDataMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.STRING, "Наименование", "name", 0.5d, true,
                        (obj, val) -> ((Currency) obj).setName((String) val))   );
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.STRING, "222222", "name", 0.5d, true,
                (obj, val) -> ((Currency) obj).setName((String) val))   );




        GridTable gridTable = gridFabric.singleGridTable(tr);





//        gridTable.getGridPane().setStyle("-fx-background-color:red");






//
//        tableWrapper = tableFabric.table(panel,0.8d,new Coordinate(50d, null, 0d, 0d),
//                dataMapper.counterpartyDataMapper(),
//                        columnFabric.stringColumn(KindOfGridCol.STRING,
//                                "Наименование контрагента","name",0.5,true,
//                                (obj,val)->((basisFx.domainModel.domaine.Counterparty)obj).setName((String)val)),
//                        columnFabric.comboBoxColumn(KindOfGridCol.COMBOBOX,
//                                "Валюта","currency",0.2,true,
//                                (obj,val)->{((Counterparty)obj).setCurrency((Currency) val);},
//                                () -> dataMapper.counterpartyDataMapper().getCurrencyList()
//                        )
//                );
//
//
//
//
//
//
//
//        AppNode.NodeBuilder.create()
//                .setId(CSSID.PANELS_BUTTON)
//                .setCoordinate(panel, 80d,0d, null, null)
//                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
//                .setWidth(170d).setHeight(20d)
//                .setEvent(eventFactory.
//                        rowAdd(
//                                tableWrapper,
//                                (l)->{l.add(new basisFx.domainModel.domaine.Counterparty());}))
//                .createNButton();
//
//        AppNode.NodeBuilder.create()
//                .setId(CSSID.PANELS_BUTTON)
//                .setCoordinate(panel, 120d,0d, null, null)
//                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
//                .setWidth(170d).setHeight(20d)
//                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
//                .createNButton();





    }


    


}
