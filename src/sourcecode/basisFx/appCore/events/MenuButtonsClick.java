/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.AdditionalButtonsBehaviour;
import basisFx.appCore.menu.MenuComponent;
import javafx.scene.control.Button;

/**
 *
 * @author Alek
 */
public class MenuButtonsClick extends AppEvent{
    
    protected  Button  but;
    protected MenuComponent component;

    protected AdditionalButtonsBehaviour behaviour ;
    
    

    public MenuButtonsClick(MenuComponent component, AdditionalButtonsBehaviour b) {
        this.component = component;
        this.behaviour= b;

    }
    
    

    @Override
    public void setElement(AppNode node) {
        this.appNode=node;
        this.but=(Button) node.getElement();
        
       
        
        but.setOnMouseClicked((event) -> {
               
            if (this.behaviour!=null) {
             
                    behaviour.execute(this.but);
            }

            run();
        });
    
    }

    @Override
    public void run() {
        
                
        this.component.getTarget().init();
    
    }
    
}
