package basisFx.appCore.menu;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 *
 * @author Alek
 */
public class LeftSideMenuRepresent extends MenuRepresent{

  
    private double heightCounterForIcon=0d;


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
                    .setFont(topLevel.getFontsStore(), topLevel.getSize())
                    .setEvent(eventFactory.leftSideMenuIconClick(topLevel))
                    .setParent(Layers.getVerticalMenuPanel())
                    .createNButton();
        }
    }

    @Override
    public void make() {
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
   



