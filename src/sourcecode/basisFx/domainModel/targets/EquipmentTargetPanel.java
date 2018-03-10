package basisFx.domainModel.targets;

import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;

/**
 *
 * @author Alek
 */
public class EquipmentTargetPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;

    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {
        
      
        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,50d, null, 0d, 0d)
                .<Equipment>createTableViewWrapper().setTablesSize(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getEquipmentDataMapper())
                .setDbTableName("Equipment").refresh()
                .setColums(
                     columnFabric.<Equipment,String>createTextColumn(ColumnWrapper.Bulder.create()
                    .setColumnName("Наименование")
                    .setPropertyName("name")
                    .setValueChecking(check.createTextCheck())
                    .setEditPoliticy(editFabric.<Equipment,String>createEditCommitDefault())
                    .setColumnSize(0.6)
                    .setPojoChanging(
                         (obj,val)->{((Equipment)obj).setName((String)val);}
                 )),
                     columnFabric.<Equipment,Integer>createIntegerColumn(ColumnWrapper.Bulder.create()
                    .setColumnName("Ширина стержня")
                    .setPropertyName("rodWidth")
                    .setValueChecking(check.createNumCheck())
                    .setEditPoliticy(editFabric.<Equipment,Integer>createEditCommitDefault())
                    .setColumnSize(0.4)
                    .setPojoChanging(
                         (obj,val)->{((Equipment)obj).setRodWidth((Integer)val);} 
                 ))
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
                 .setEvent(eventFactory.
                         createRowAdd(
                                 tableViewWrapper, 
                                 (l)->{l.add(new Equipment());}))
                 .createNButton();
                 

    }

   
    


}
