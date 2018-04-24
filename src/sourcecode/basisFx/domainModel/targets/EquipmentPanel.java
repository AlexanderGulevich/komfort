package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.panels.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.domainModel.domaine.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class EquipmentPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {
        
      
        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .createTableViewWrapper().setTablesWidthProperty(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapper.equipmentDataMapper())
                .setDbTableName("Equipment").refresh()
                .setColums(
                     columnFabric.createColumn("Наименование","stringValue",0.6,true,
                         (obj,val)->((Equipment)obj).setStringValue((String)val)),

                     columnFabric.createColumn("Ширина стержня","rodWidth",0.4,true,
                         (obj,val)->{((Equipment)obj).setRodWidth((String)val);}
                     )
                );
       
 
        AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BUTTON)
                 .setCoordinate(panel, 80d,50d, null, null)
                 .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                 .setWidth(170d).setHeight(20d)
                 .setEvent(eventFactory.
                         createRowAdd(
                                 tableViewWrapper, 
                                 (l)->{l.add(new Equipment());}))
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
