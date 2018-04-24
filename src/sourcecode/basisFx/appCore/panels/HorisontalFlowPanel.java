/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Alek
 */
public class HorisontalFlowPanel extends AbstractPanel{
    
    private FlowPane panel;
        
    public HorisontalFlowPanel(AbstractPanel.PanelBuilder b) {
        
        build(b);
        
        init();
   

    }


    @Override
    public void init() {
         panel=(FlowPane) AppNode.NodeBuilder.create()
                .setParent(parent)
                .setCoordinate(panelCoordinate)
                .setHeight(height)
                .setWidth(width)
                .setId(CSSID.HORIZONTAL_FLOW_MENU_PANEL)
                .createNFlowPane()
                .getElement();
         
       
    
    }

    @Override
    public void register() {
        Layers.setHorisontalFlowPanel(panel);
      
    }
    
}
