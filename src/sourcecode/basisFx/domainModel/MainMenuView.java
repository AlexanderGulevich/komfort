/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NAnchor;
import basisFx.appCore.menu.LeftSideMenuRepresent;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;

/**
 *
 * @author Alek
 */
public class MainMenuView {
    
//        
//        MenuCreator.create()
//                .setParentAnchor(Layers.getContentLayer())
//                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
//                .setCss(CSSID.MENUS)
//                .setNodes(new MainMenu())
//                .setRepresent(MenuRepresent.menuNBarFabric())
//                .init();
//        
        LeftSideMenuRepresent represent=(LeftSideMenuRepresent) MenuCreator.create()
                .setParentAnchor(Layers.getVisibleRoot())
                .setCoordinate(new AnchorCoordinate(40d, null, 0d, 0.5d))
                .setWidth(70d)
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(MenuRepresent.menuLeftSideFabric())
                .init().getRepresent();
        
        
        NAnchor top =AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
                .setParentAnchor(represent.getIconpanel())
                .setWidth(40d)
                .setHeight(40d)
//                .setId("topIconPanel")
                .setId(CSSID.top)
                .createNpAnchor();
                
            
                
//        represent.getIconpanel()
        
}
