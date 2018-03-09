/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class TitlePanel extends AbstractPanel {

    public TitlePanel(AbstractPanel.PanelBuilder b) {
        
           build(b);

    }

    
    
    
    
    @Override
    public void init() {
        
         panel=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(panelCoordinate)
                         .setParent(parent)
                         .setId(CSSID.TITLE_PANEL)
                         .setStage(stage)
                         .setHeight(height)
                         .setWidth(width)
                         .setEvent(AppEvent.createStageDragging())
                         .createNpAnchor()
                         .getElement();
    
    }

    @Override
    public void register() {
         Layers.setTitlePanel(panel);
    }

  
    
    
    
    
    
}
