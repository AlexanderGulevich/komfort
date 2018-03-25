/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.AnchorCoordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
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
                 .createAnchorPanelWrapper().getElement();

//
//        ScrollPane scrollPane = (ScrollPane) AppNode.NodeBuilder.create()
//                .setParent(Layers.getContentLayer())
//                .setCoordinate(panelCoordinate)
//                .createScrollPaneWrapper().getElement();
//
//
//        panel =  (AnchorPane) AppNode.NodeBuilder.create()
//                .setId(CSSID.TARGET_PANEL)
//                .setParent(scrollPane)
//                .createAnchorPanelWrapper().getElement();

    }

    @Override
    public void register() {}
    
}
