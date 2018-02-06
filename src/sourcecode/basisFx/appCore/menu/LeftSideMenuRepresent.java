package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class LeftSideMenuRepresent extends MenuRepresent{
    
    private AnchorPane rootLeftSide;
    private AnchorPane iconpanel;
    private AnchorPane namesPanel;

    public AnchorPane getRootLeftSide() {
        return rootLeftSide;
    }

    public AnchorPane getIconpanel() {
        return iconpanel;
    }

    public AnchorPane getNamesPanel() {
        return namesPanel;
    }
    
    
    
     
    

    @Override
    public <T> void makeStructuredMenuView(MenuComponents c, T parentMenu) {
    
    }

    @Override
    public void make() {
        this.rootLeftSide=(AnchorPane) AppNode.NodeBuilder.create()
                .setParentAnchor(Layers.getVisibleRoot())
                .setCoordinate(c)
                .setWidth(width)
                .setId(CSSID.LEFT_SIDE_MENU_ROOT)
                .createNpAnchor()
                .getElement();
        
        this.iconpanel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParentAnchor(rootLeftSide)
                .setCoordinate(new AnchorCoordinate(-40d,null,0d,0d))
                .setWidth(width)
                .setId(CSSID.LEFT_SIDE_MENU_ICON_PANEL)
                .createNpAnchor()
                .getElement();
   
        
//        this.namesPanel=(AnchorPane) AppNode.NodeBuilder.create()
//                .setParentAnchor(rootLeftSide)
//                .setCoordinate(new AnchorCoordinate(0d,null,0d,width/3))
//                .setWidth(width/3*2)
//                .setId(CSSID.LEFT_SIDE_MENU_ICON_TEXT)
//                .createNpAnchor()
//                .getElement();
//   
      
        
        
        makeStructuredMenuView (menuComponent,null);
    
    
    }

   
    
}
