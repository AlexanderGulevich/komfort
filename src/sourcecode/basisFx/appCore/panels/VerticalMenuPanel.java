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
public class VerticalMenuPanel extends AbstractPanel{

     
     public VerticalMenuPanel(AbstractPanel.PanelBuilder b) {
        
          build(b);

    }
     
     
    @Override
    public void init() {
         panel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParent(Layers.getVisibleRoot())
                .setCoordinate(this.panelCoordinate)
                .setHeight(height)
                .setWidth(width)
                .setId(CSSID.LEFT_SIDE_MENU_VERTICAL_PANEL)
                .createAnchorPanelWrapper()
                .getElement();
    }

    @Override
    public void register() {
        Layers.setVerticalMenuPanel(panel);
    }
    
   
    
}
