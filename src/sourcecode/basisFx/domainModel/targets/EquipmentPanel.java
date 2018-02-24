package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.registry.TargetRegistry;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel extends Target{
    
    private TableView<Equipment> table;
    private Button but;
    
    @Override
    public void createElement() {
        
        TargetRegistry.targets.add(this);
        
        
        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();


        table = (TableView<Equipment>) AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE).setCoordinate(panel,0d, null, 0d, 0d)
                 .<Equipment>createNTableView().setTablesSize(0.7,panel.widthProperty())
                 .setColums(
                     colManeger.<Equipment>createTextColumn("Наименование","name"),
                     colManeger.<Equipment>createIntegerColumn("Ширина стержня","rodWidth")
                 )
                 .setColumsSize(0, 0.7).setColumsSize(1, 0.3)
                 .getElement();

        but= (Button) AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BUTTON)
                 .setCoordinate(panel, 200d,150d, null, null)
                 .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 25)
                 .setEvent(new RowAddToTable(table,(l)->{l.add(new Equipment());}))
                 .createNButton().getElement();
                 

    }

   
    


}
