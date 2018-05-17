package basisFx.domainModel.targets;

import basisFx.appCore.controls.*;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Counterparty;
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
        tr.setTitle("Контрагенты");
        tr.setTablesButtonKind(TablesButtonKind.Bottom_right);
        tr.setDomainClass(Counterparty.class);
        tr.setDataMapper(dataMapperFabric.counterpartyMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(
                columnFabric.stringColumn(KindOfColumn.STRING, "Наименование", "name", 0.6d, true,
                (obj,val)->((Counterparty)obj).setName((String)val))
        );
        tr.setColumn(
                columnFabric.comboBoxColumn(KindOfColumn.COMBOBOX,"Валюта ","currency",0.4d,true,
                        (obj,val)->((Counterparty)obj).setCurrency((ComboBoxValue)val),
                        () -> dataMapperFabric.currencyMapper().toComboBoxValueList((val)->{return ((Currency)val).getName();})
                ));





        GridTable gridTable = gridFabric.singleGridTable(tr);

    }


    


}
