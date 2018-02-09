package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Alek
 */
public class LeftSideMenuRepresent extends MenuRepresent{
    
    private AnchorPane rootLeftSide;
    private AnchorPane iconpanel;
    public static  FlowPane namesPanel;
    private AnchorPane topIconPanel;
    public enum  namesPanelPalaced{NOT_EXIST, CONTENT_PANEL,LEFT_SIDE};
    private namesPanelPalaced npPalaced;
    private double heightCounterForIcon=0d;
    public static  AnchorPane textPanel;
    
    

    public LeftSideMenuRepresent(namesPanelPalaced np) {
        this.npPalaced=np;
    }
    
       

    public AnchorPane getRootLeftSide() {
        return rootLeftSide;
    }

    public AnchorPane getIconpanel() {
        return iconpanel;
    }

    public FlowPane getNamesPanel() {
        return namesPanel;
    }
    
    
    
     
    

    @Override
    public <T> void makeStructuredMenuView(MenuComponents c, T parentMenu) {
        ArrayList<MenuComponents> components = c.getComponents();
        
         
        
        for (Iterator<MenuComponents> iterator = components.iterator(); iterator.hasNext();) {
            MenuComponents topLevel = iterator.next();
            
            
            this.heightCounterForIcon+=42d;
            
            //создание кнопок вертикальных
            AppNode.NodeBuilder.create()
                    .setId(CSSID.LEFT_SIDE_MENU_ICON)
                    .setCoordinate(this.heightCounterForIcon, 0d, null, 0d)
                    .setText(topLevel.getMetaInf())
                    .setFont(FontsStore.MATERIAL_ICONS, 25)
                    .setEvent(AppEvent.createleftSideMenuIconClick(topLevel))
                    .setParent(this.iconpanel)
                    .createNButton();
            
            
            
            
            
        }
        
        
        
    }

    @Override
    public void make() {
        this.rootLeftSide=(AnchorPane) AppNode.NodeBuilder.create()
                .setParent(Layers.getVisibleRoot())
                .setCoordinate(c)
                .setId(CSSID.LEFT_SIDE_MENU_ROOT)
                .createNpAnchor()
                .getElement();
        
        this.iconpanel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParent(rootLeftSide)
                .setCoordinate(new AnchorCoordinate(-40d,null,0d,0d))
                .setId(CSSID.LEFT_SIDE_MENU_ICON_PANEL)
                .createNpAnchor()
                .getElement();
   
        

      this.topIconPanel =(AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
                .setParent(iconpanel)
                .setId(CSSID.TOP_ICON_PANEL)
                .createNpAnchor()
                .getElement();
                

      this.textPanel =(AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(10d, 70d, 0d, null))
                .setId(CSSID.LEFT_SIDE_MENU_ICON_TEXT_PANEL)
                .setParent(Layers.getTitlePanel())
                .createNpAnchor()
                .getElement();
                

      
      
      
        if (this.npPalaced==namesPanelPalaced.CONTENT_PANEL) {
                
            this.namesPanel=(FlowPane) AppNode.NodeBuilder.create()
                .setParent(Layers.getContentLayer())
                .setCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setHeight(30d)
                .setId(CSSID.LEFT_SIDE_MENU_NAMES_PANEL)
                .createNFlowPane()
                .getElement();
              
//   
        }
         if (this.npPalaced==namesPanelPalaced.NOT_EXIST) {
          
        }

      
        
        
        makeStructuredMenuView (menuComponent,null);
    
    
    }

   
    
}
