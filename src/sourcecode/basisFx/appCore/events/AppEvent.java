/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.MenuComponent;


/**
 *
 * @author 62
 */
public abstract class AppEvent {

    protected AppNode appNode;
    
    public abstract void setElement(AppNode node);
    public AppEvent setElementNonLogic(AppNode node){
    
        this.appNode=node;
        return this;
    
    };
    public abstract void run();
    
    
    
   public static  AppEvent createClosingWindowEvent(){
   
       return new CloseWindow();
       
   
   }
   public static  AppEvent createHidingWindowEvent(){
   
       return new HideWindow();
       
   
   }
   public static  AppEvent createMaximazingSwitcher(){
   
       return new MaximazingSwither();
       
   
   }
   public static  AppEvent createDbClickEvent(AppEvent appEvent){
   
       return new DbClick(appEvent);
       
   
   }
   public static  AppEvent createStageDragging(){
   
       return new StageDragging();
       
   
   }
   
   public static  AppEvent createleftSideMenuIconClick(MenuComponent component){
   
       return new leftSideMenuIconClick(component);
       
   
   }
   public static  MenuButtonsClick createMenuButtonsClick(MenuComponent component, AdditionalButtonsBehaviour b){
   
       return new MenuButtonsClick(component,b);
       
   
   }
   
   
    
}
