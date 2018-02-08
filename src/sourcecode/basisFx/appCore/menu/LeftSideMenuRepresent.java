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
    private double heightCounterForIcon=0d;
    

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
        ArrayList<MenuComponents> components = c.getComponents();
        
         
        
        for (Iterator<MenuComponents> iterator = components.iterator(); iterator.hasNext();) {
            MenuComponents next = iterator.next();
            
            
            this.heightCounterForIcon+=42d;
            
            //создание кнопок вертикальных
            AppNode.NodeBuilder.create()
                    .setId(CSSID.LEFT_SIDE_MENU_ICON)
                    .setCoordinate(this.heightCounterForIcon, 0d, null, 0d)
                    .setText(next.getMetaInf())
                    .setFont(FontsStore.MATERIAL_ICONS, 25)
                    .setEvent(new AppEvent() {
                        @Override
                        public void setElement(AppNode node) {
                            
                        }

                        @Override
                        public void run() {
                           
                        }
            })
                    .setParent(this.iconpanel)
                    .createNButton();
            
            
            
            AppNode.NodeBuilder.create()
                    .setId(CSSID.LEFT_SIDE_MENU_ICON_TEXT)
                    .setCoordinate(10d, 250d, 10d, null)
                    .setParent(Layers.getTitlePanel())
                    .setText(next.getName())
                    .setFont(FontsStore.ROBOTO, 25)
                    .createNText();
                    
            
            
            
            
            
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
                

      
      
      
        if (this.npPalaced==namesPanelPalaced.CONTENT_PANEL) {
                
            this.namesPanel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParent(Layers.getContentLayer())
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
