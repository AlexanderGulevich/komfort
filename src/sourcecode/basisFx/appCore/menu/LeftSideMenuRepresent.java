package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Alek
 */
public class LeftSideMenuRepresent extends MenuRepresent{
    
    private AnchorPane rootLeftSide;
    private static AnchorPane verticalPanel;
    public static  FlowPane horisontalPanel;
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

    public AnchorPane getVerticalPanel() {
        return verticalPanel;
    }

    public FlowPane getHorisontalPanel() {
        return horisontalPanel;
    }
    

    @Override
    public <T> void makeStructuredMenuView(MenuComponent c, T parentMenu) {
        ArrayList<MenuComponent> components = c.getComponents();
        
         
        
        for (Iterator<MenuComponent> iterator = components.iterator(); iterator.hasNext();) {
            MenuComponent topLevel = iterator.next();
            
            
            this.heightCounterForIcon+=42d;
            
            //создание кнопок вертикальных
            AppNode.NodeBuilder.create()
                    .setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS)
                    .setCoordinate(this.heightCounterForIcon, 0d, null, 0d)
                    .setText(topLevel.getMetaInf())
                    .setFont(FontsStore.MATERIAL_ICONS, 25)
                    .setEvent(AppEvent.createleftSideMenuIconClick(topLevel))
                    .setParent(this.verticalPanel)
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
        
        this.verticalPanel=(AnchorPane) AppNode.NodeBuilder.create()
                .setParent(rootLeftSide)
                .setCoordinate(new AnchorCoordinate(-40d,null,0d,0d))
                .setId(CSSID.LEFT_SIDE_MENU_ICON_PANEL)
                .createNpAnchor()
                .getElement();


      this.topIconPanel =(AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(0d, 0d, null, 0d))
                .setParent(verticalPanel)
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
                
            this.horisontalPanel=(FlowPane) AppNode.NodeBuilder.create()
                .setParent(Layers.getContentLayer())
                .setCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                .setId(CSSID.LEFT_SIDE_MENU_NAMES_PANEL)
                .createNFlowPane()
                .getElement();
              
//   
        }
         if (this.npPalaced==namesPanelPalaced.NOT_EXIST) {
          
        }

      
        
        
        makeStructuredMenuView (menuComponent,null);
    
    
    }

   public static void setDefaultStyleHorisontalButtons(){
   
       
       ObservableList<Node> buttons=horisontalPanel.getChildren();
       
       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();
//           
           if(next instanceof Button){
          
             next.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS.get());
          }
           
             }
         }

   public static void setDefaultStyleVerticalButtons(){
   
      
       ObservableList<Node> buttons=verticalPanel.getChildren();
//       
       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();
           
          if(next instanceof Button){
          
             next.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS.get());
          }
           
          
      
         }
   }


   }
   



