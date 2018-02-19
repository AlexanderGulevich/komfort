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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel <T extends Node> extends Target{
    
    private ObservableList<Equipment>  tablesPojo=FXCollections.<Equipment> observableArrayList();
    
    private AnchorPane panel;
    
    private TableView<Equipment> table;
    private Button but;
    
    @Override
    public void createElement() {
        Equipment equipment = new Equipment(); 
        equipment.setName("ghndndgndg");
        equipment.setRodWidth(232d);
       tablesPojo.add(equipment);
        
         TargetRegistry.targets.add(this);
//        
         panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();
         
         

         table = (TableView<Equipment>) AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE)
                 .setCoordinate(0d, null, 0d, 0d)
                 .setParent((AnchorPane) panel)
                 .createNTableView()
                 .setTablesSize(0.5,panel.widthProperty())
                 .setItems(tablesPojo)
                 .setColums(
                         getNameColumn(),
                         getRodWidthColumn()
                 )
                 .setSortableAllCollums(false)
                 .setColumsSize(0, 0.7)
                 .setColumsSize(1, 0.3)
                 .getElement();
         
         
        
         
         but= (Button) AppNode.NodeBuilder.create()
                 .setId(CSSID.PANELS_BURRON)
                 .setCoordinate(panel, 290d,150d, null, null)
                 .setText("gngfmgymygmumhyumhyumuym")
                 .setFont(FontsStore.ROBOTO_LIGHT, 25)
                 .setEvent(new RowAddToTable(table))
                 .createNButton()
                 .getElement();
                 
    
    
    
    
        
        
        
        
    
    }

    @Override
    public T getTargetElement() {
       return (T) this.panel;
    }
    

    
    
    public  TableColumn<Equipment, Integer> getRodWidthColumn() {
            
		TableColumn<Equipment, Integer> rodWidthCol = new TableColumn<>("Ширина стержня");
		rodWidthCol.setCellValueFactory(new PropertyValueFactory<>("rodWidth"));
		return rodWidthCol;

    
}
    public  TableColumn<Equipment, String> getNameColumn() {
            
		TableColumn<Equipment, String> nameCol = new TableColumn<>("Наименование");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		return nameCol;

    
}
    

}
