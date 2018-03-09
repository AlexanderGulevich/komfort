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

/**
 *
 * @author Alek
 */
public class LeftSideMenuRepresent extends MenuRepresent{

    private AnchorPane topIconPanel;
    private double heightCounterForIcon=0d;
    public static  AnchorPane textAnchor;

    @Override
    public <T> void makeStructuredMenuView(MenuComponent c, T parentMenu) {
        ArrayList<MenuComponent> components = c.getComponents();

        for (Iterator<MenuComponent> iterator = components.iterator(); iterator.hasNext();) {
            MenuComponent topLevel = iterator.next();
            
            
            this.heightCounterForIcon+=50d;
            
            //создание кнопок вертикальных
            AppNode.NodeBuilder.create()
                    .setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS)
                    .setCoordinate(this.heightCounterForIcon, 0d, null, 0d)
                    .setText(topLevel.getMetaInf())
                    .setFont(FontsStore.MATERIAL_ICONS, 25)
                    .setEvent(AppEvent.createleftSideMenuIconClick(topLevel))
                    .setParent(Layers.getVerticalMenuPanel())
                    .createNButton();
        }
    }

    @Override
    public void make() {

      this.textAnchor =(AnchorPane) AppNode.NodeBuilder.create()
                .setCoordinate(new AnchorCoordinate(10d, 70d, 0d, null))
                .setId(CSSID.LEFT_SIDE_MENU_TEXT_PANEL)
                .setParent(Layers.getTitlePanel())
                .createNpAnchor()
                .getElement();

              makeStructuredMenuView (menuComponent,null);
    
    
    }

   public static void setDefaultStyleHorisontalButtons(){
   
       
       ObservableList<Node> buttons=Layers.getHorisontalFlowPanel().getChildren();
       
       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();
//           
           if(next instanceof Button){
          
             next.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS.get());
          }
           
             }
         }

   public static void setDefaultStyleVerticalButtons(){
   
      
       ObservableList<Node> buttons=Layers.getVerticalMenuPanel().getChildren();
//       
       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();
           
          if(next instanceof Button){
          
             next.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS.get());
          }
           
          
      
         }
   }


   }
   



