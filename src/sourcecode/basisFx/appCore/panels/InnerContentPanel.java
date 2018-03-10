/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class InnerContentPanel extends AbstractPanel{
 
    public InnerContentPanel(PanelBuilder b) {
       
          build(b);
          init();
          
    }
    
    @Override
    public void init() {
            panel =  (AnchorPane) AppNode.NodeBuilder.create()
                 .setId(CSSID.TARGET_PANEL)
                 .setCoordinate(panelCoordinate)
                 .setParent(Layers.getContentLayer())
                 .createNpAnchor().getElement();
    }

    @Override
    public void register() {}
    
}
