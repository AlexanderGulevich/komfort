package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NTableView;
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
    
    private NTableView nTableView;
    private Button but;
    
    @Override
    @SuppressWarnings("unchecked")
    public void createElement() {
        
        TargetRegistry.targets.add(this);
        
        
        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();

        nTableView = AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE).setCoordinate(panel,0d, null, 0d, 0d)
                 .<Equipment>createNTableView().setTablesSize(0.7, panel.widthProperty())
                .setDataMapper(this.dataMapperFabric.getEquipmentDataMapper())
                .setTableName("Equipment")
                .setColums(
                     colManeger.<Equipment,String>createTextColumn(
                             "Наименование","name", 
                             check.createTextCheck(),
                             (obj,val)->{((Equipment)obj).setName((String)val);} 
                 ),
                     colManeger.<Equipment>createIntegerColumn(
                             "Ширина стержня","rodWidth",
                             check.createNumCheck(),
                           (obj,val)->{((Equipment)obj).setRodWidth((Integer)val);}
                     )
                 )
                 .setColumsSize(0, 0.7).setColumsSize(1, 0.3)
                .refresh();
       
 
        but= (Button) AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BUTTON)
                 .setCoordinate(panel, 200d,150d, null, null)
                 .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 25)
                 .setEvent(AppEvent.
                         createRowAdd(
                                 nTableView, 
                                 (l)->{l.add(new Equipment());}))
                 .createNButton().getElement();
                 

    }

   
    


}
