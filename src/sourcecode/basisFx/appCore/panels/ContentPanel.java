/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class ContentPanel extends AbstractPanel{

    
    
    
     public ContentPanel(AbstractPanel.PanelBuilder b) {
        
         build(b);

    }
    

    @Override
    public void init() {
           panel=(AnchorPane) AppNode.NodeBuilder.create()
                         .setCoordinate(panelCoordinate)
                         .setParent(parent)
                         .setHeight(height)
                         .setWidth(width)
                         .setId(CSSID.MAIN_CONTENT_ANCHOR)
                         .setStage(stage)
                         .createAnchorPanelWrapper()
                         .getElement();
    

    
    } 

    @Override
    public void register() {
        Layers.setContentLayer(panel);
    }
    
}
