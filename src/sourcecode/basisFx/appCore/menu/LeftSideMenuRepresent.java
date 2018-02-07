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
    private AnchorPane topIconPanel;
    public enum  namesPanelPalaced{NOT_EXIST, CONTENT_PANEL,LEFT_SIDE};
    private namesPanelPalaced npPalaced;
    

    public LeftSideMenuRepresent(namesPanelPalaced np) {
        this.npPalaced=np;
    }
    
       

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
   
        

      this.topIconPanel =(AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
                .setParentAnchor(iconpanel)
                .setWidth(40d)
                .setHeight(45d)
                .setId(CSSID.TOP_ICON_PANEL)
                .createNpAnchor()
                .getElement();
                

      
      
      
        if (this.npPalaced==namesPanelPalaced.CONTENT_PANEL) {
                
            this.namesPanel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParentAnchor(Layers.getContentLayer())
                .setCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setHeight(30d)
                .setId(CSSID.LEFT_SIDE_MENU_NAMES_PANEL)
                .createNpAnchor()
                .getElement();
              
//   
        }else{
            System.out.println("basisFx.appCore.menu.LeftSideMenuRepresent.make()");
        
        }

      
        
        
        makeStructuredMenuView (menuComponent,null);
    
    
    }

   
    
}
