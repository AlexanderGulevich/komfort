/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
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
        register();

    }


    @Override
    public void init() {
         panel=(FlowPane) AppNode.NodeBuilder.create()
                .setParent(parent)
                .setCoordinate(panelCoordinate)
                .setHeight(height)
                .setWidth(width)
                .setId(CSSID.LEFT_SIDE_MENU_NAMES_PANEL)
                .createNFlowPane()
                .getElement();
         
       
    
    }

    @Override
    public void register() {
        Layers.setHorisontalFlowPanel(panel);
        System.out.println("basisFx.appCore.panels.HorisontalFlowPanel.register()");
    }
    
}
