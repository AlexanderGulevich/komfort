package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.registry.TargetRegistry;
import basisFx.domainModel.pojo.Equipment;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel <T extends Node> extends Target{
    
    private AnchorPane tergetElement;

    @Override
    public void createElement() {
//        
         tergetElement =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();
         
         
         TargetRegistry.targets.add(this);
         
         
         AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE)
                 .setCoordinate(0d, null, 0d, 0d)
                 .setParent((AnchorPane) tergetElement)
                 .createNTableView()
                 .setTablesSize(0.5,tergetElement.widthProperty())
                 .setColums(
                         getNameColumn(),
                         getRodWidthColumn()
                 )
                 .setSortableAllCollums(false)
                 .setColumsSize(0, 0.7)
                 .setColumsSize(1, 0.3);
                 
                 
    
    
    
    
        
        
        
        
    
    }

    @Override
    public T getTargetElement() {
       return (T) this.tergetElement;
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
