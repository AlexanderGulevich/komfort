package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.controlPolicy.ColumnWrapper;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.registry.TargetRegistry;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel extends Target{
    
    private TableViewWrapper tableViewWrapper;
    private Button but;
    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {
        
        TargetRegistry.targets.add(this);
        Layers.getContentLayer().getChildren().clear();
        
        
        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();

        tableViewWrapper = AppNode.NodeBuilder.create()
                .setId(CSSID.TABLE).setCoordinate(panel,0d, null, 0d, 0d)
                .<Equipment>createTableViewWrapper().setTablesSize(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getEquipmentDataMapper())
                .setDbTableName("Equipment").refresh()
                .setColums(columnFabric.<Equipment,String>createTextColumn(ColumnWrapper.Bulder.create()
                    .setColumnName("Наименование")
                    .setPropertyName("name")
                    .setValueChecking(check.createTextCheck())
                    .setEditPoliticy(editFabric.<Equipment,String>createEditCommitDefault())
                    .setColumnSize(0.7)
                    .setPojoChanging(
                         (obj,val)->{((Equipment)obj).setName((String)val);}
                 )),
                     columnFabric.<Equipment,Integer>createIntegerColumn(ColumnWrapper.Bulder.create()
                    .setColumnName("Ширина стержня")
                    .setPropertyName("rodWidth")
                    .setValueChecking(check.createNumCheck())
                    .setEditPoliticy(editFabric.<Equipment,Integer>createEditCommitDefault())
                    .setColumnSize(0.3)
                    .setPojoChanging(
                         (obj,val)->{((Equipment)obj).setRodWidth((Integer)val);} 
                 ))
                );
       
 
        but= (Button) AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BUTTON)
                 .setCoordinate(panel, 200d,150d, null, null)
                 .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 25)
                 .setEvent(AppEvent.
                         createRowAdd(
                                 tableViewWrapper, 
                                 (l)->{l.add(new Equipment());}))
                 .createNButton().getElement();
                 

    }

   
    


}
