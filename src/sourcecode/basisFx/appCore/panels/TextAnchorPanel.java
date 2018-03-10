/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.LeftSideMenuRepresent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class TextAnchorPanel extends AbstractPanel{

    private Text text;

    public TextAnchorPanel(PanelBuilder b) {
       
          build(b);
          init();
          
    }

    @Override
    public void init() {
        
        panel= (AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(panelCoordinate)
                .setId(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
                .setWidth(width)
                .setHeight(height)
                .setParent(parent)
                .createNpAnchor()
                .getElement();
        
        text = (Text) AppNode.NodeBuilder.create()
                .setId(CSSID.LEFT_SIDE_MENU_COMMON_TEXT)
                .setParent(panel)
                .setCoordinate(0d, 10d, 0d, 0d)
//                .setText(component.getName())
                .setFont(FontsStore.ROBOTO_BOLD, 20)
                .createNText().getElement();
    }

    @Override
    public void register() {
       Layers.setTextAnchorPanel(panel);
    }
    
}
