/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class ContentPanel extends AbstractPanel{
    
    
     public ContentPanel(AbstractPanel.PanelBuilder b) {
        
        this.panelCoordinate=b.panelCoordinate;
        this.parent=b.parent;

    }
    

    @Override
    public void init() {
           panel=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(panelCoordinate)
                         .setParent(parent)
                         .setId(CSSID.MAIN_CONTENT_ANCHOR)
                         .setStage(stage)
                         .createNpAnchor()
                         .getElement();
    

    
    } 

    @Override
    public void register() {
        Layers.setContentLayer(panel);
    }
    
}
