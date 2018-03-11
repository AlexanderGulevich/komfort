/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.LeftSideMenuRepresent;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.registry.Layers;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class leftSideMenuIconClick extends AppEvent{
    protected Button  but;
    protected MenuComponent component;

    public leftSideMenuIconClick(MenuComponent component) {
        this.component = component;
    }
    
    @Override
    public void setElement(AppNode n) {
        this.appNode=n;
        this.but=(Button) n.getElement();


        but.setOnAction((event) -> {
           
            Text t=(Text) Layers.getTextAnchorPanel().getChildren().get(0);
            t.setText("");
    
            LeftSideMenuRepresent.setDefaultStyleVerticalButtons();
            but.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED.get());
       
            run();
        });
    }

    @Override
    public void run() {
     
      
        
        setCommonTextName();
        setButtons();
       
     

             }

    private void setCommonTextName() {
         
        Text t=(Text) Layers.getTextAnchorPanel().getChildren().get(0);
        t.setText(component.getName());
            
        }

    private void setButtons() {

       Layers.getHorisontalFlowPanel().getChildren().clear();
        
             if(this.component.isComposit()){
            
               ArrayList<MenuComponent> inerLevelComponents=  component.getComponents();
//               
                for (Iterator<MenuComponent> iterator1 = inerLevelComponents.iterator(); iterator1.hasNext();) {
                    MenuComponent nextInerLevel = iterator1.next();
                  
                    //создание кнопок горизонтальных
                          AppNode.NodeBuilder.create()
                          .setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS)
                          .setText(nextInerLevel.getName())
                          .setFont(FontsStore.ROBOTO_LIGHT, 17d)
                          .setEvent(
                                  eventFactory.createMenuButtonsClick(    
                                          nextInerLevel,
                                          (button) -> {
                                              LeftSideMenuRepresent.setDefaultStyleHorisontalButtons();
                                              button.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED.get());
                                          
                                          }
                                  )
                          )
                          .setParent(Layers.getHorisontalFlowPanel())
                          .createNButton();

//                    
                }
//              
            
            
            }
    }
    
    
    
    
   
         
            
    
}
