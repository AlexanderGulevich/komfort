package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.TableListener;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.registry.TargetRegistry;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel <T extends Node> extends Target{
    
    private ObservableList<Equipment>  list=FXCollections.<Equipment> observableArrayList();
    
    private AnchorPane panel;
    
    private TableView<Equipment> table;
    private Button but;
    
    @Override
    public void createElement() {
        
        TargetRegistry.targets.add(this);
        
        
        list.addListener(new TableListener<Equipment>());
        
        
        panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();


        table = (TableView<Equipment>) AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE).setCoordinate(panel,0d, null, 0d, 0d)
                 .<Equipment>createNTableView()
                 .setList(list)
                 .setTablesSize(0.7,panel.widthProperty())
                 .setColums(
                     colManeger.<Equipment>createTextColumn("Наименование","name"),
                     colManeger.<Equipment>createIntegerColumn("Ширина стержня","rodWidth")
                 )
                 .setColumsSize(0, 0.8)
                 .setColumsSize(1, 0.2)
                 .getElement();
             //    

        but= (Button) AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BUTTON)
                 .setCoordinate(panel, 200d,150d, null, null)
                 .setText("ДОБАВИТЬ")
                 .setFont(FontsStore.ROBOTO_LIGHT, 25)
                 .setEvent(
                         new RowAddToTable(
                         table,
                         list,
                         (l)->{
                             l.add(new Equipment());
                                 }
                 ))
                 .createNButton()
                 .getElement();
                 

    }

    @Override
    public T getTargetElement() {
       return (T) this.panel;
    }
    


}
