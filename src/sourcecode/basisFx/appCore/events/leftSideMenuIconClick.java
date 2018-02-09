/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.LeftSideMenuRepresent;
import basisFx.appCore.menu.MenuComponents;
import basisFx.domainModel.settings.CSSID;
import basisFx.domainModel.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class leftSideMenuIconClick extends AppEvent{
    protected Button  but;
    protected MenuComponents component;

    public leftSideMenuIconClick(MenuComponents component) {
        this.component = component;
    }
    
    
    
    
    @Override
    public void setElement(AppNode n) {
         this.appNode=n;
        this.but=(Button) n.getElement();
        
        
        
        
        but.setOnMouseClicked((event) -> {
            LeftSideMenuRepresent.textPanel.getChildren().clear();
            run();
        });
    }

    @Override
    public void run() {
     
      
        
        setOveralTextName();
        setButtons();
       
     

             }

    private void setOveralTextName() {
         
        Text ntext = (Text) AppNode.NodeBuilder.create()
                .setId(CSSID.LEFT_SIDE_MENU_ICON_TEXT)
                .setParent(LeftSideMenuRepresent.textPanel)
                .setCoordinate(0d, 10d, 0d, 0d)
                .setText(component.getName())
                .setFont(FontsStore.ROBOTO_BOLD, 20)
                .createNText().getElement();
        }

    private void setButtons() {
       LeftSideMenuRepresent.namesPanel.getChildren().clear();
        
             if(this.component.isComposit()){
            
               ArrayList<MenuComponents> inerLevelComponents=  component.getComponents();
//               
                for (Iterator<MenuComponents> iterator1 = inerLevelComponents.iterator(); iterator1.hasNext();) {
                    MenuComponents nextInerLevel = iterator1.next();
                  
                    //создание кнопок горизонтальных
                          AppNode.NodeBuilder.create()
                          .setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS)
                          .setText(nextInerLevel.getName())
                          .setFont(FontsStore.ROBOTO_LIGHT, 15d)
//                          .setInsects(new Insets(0d, 1d, 0, 1d))
//                          .setMinWidth(150d)
//                          .setMaxWidth(300d)
                          .setParent(LeftSideMenuRepresent.namesPanel)
                          .createNButton();

//                    
                }
//              
            
            
            }
    }
    
    
    
    
   
         
            
    
}
