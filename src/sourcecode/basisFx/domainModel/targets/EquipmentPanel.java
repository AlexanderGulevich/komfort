package basisFx.domainModel.targets;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.menu.Target;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.registry.TargetRegistry;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class EquipmentPanel <T extends Node> extends Target{
    
    private T tergetElement;

    @Override
    public void createElement() {
//        
         tergetElement =(T)  AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(new AnchorCoordinate(50d, 10d, 10d, 10d))
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();
         
         
         TargetRegistry.targets.add(this);
         
         
         AppNode.NodeBuilder.create()
                 .setId(CSSID.TABLE)
                 .setCoordinate(0d, 0d, 0d, 0d)
                 .setParent((AnchorPane) tergetElement)
                 .createNTableView();
                 
                 
    
    
    
    
        
        
        
        
    
    }

    @Override
    public T getTargetElement() {
       return this.tergetElement;
    }

  
    
    
    
    
}
