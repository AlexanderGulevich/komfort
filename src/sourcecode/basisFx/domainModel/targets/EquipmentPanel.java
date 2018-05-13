package basisFx.domainModel.targets;

import basisFx.appCore.controls.GridTable;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.grid.GridTablesBuilder;
import basisFx.appCore.grid.TablesButtonKind;
import basisFx.appCore.panels.Target;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.domaine.Equipment;

/**
 *
 * @author Alek
 */
public class EquipmentPanel extends Target{
    
    private TableWrapper tableWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void configurate() {

        GridTablesBuilder tr=new GridTablesBuilder();
        tr.setTitle("Перечень станков ");
        tr.setTablesButtonKind(TablesButtonKind.Bottom_right);
        tr.setDomainClass(Equipment.class);
        tr.setDataMapper(dataMapperFabric.equipmentDataMapper());
        tr.setCoordinate(new Coordinate(10d, 10d, 10d, 10d));
        tr.setPanel(panel);
        tr.setColumn(columnFabric.stringColumn(KindOfColumn.STRING,"Наименование ","name",1d,true,
                (obj,val)->((Equipment)obj).setName((String)val))
        );



        GridTable gridTable = gridFabric.singleGridTable(tr);

    }

   
    


}
