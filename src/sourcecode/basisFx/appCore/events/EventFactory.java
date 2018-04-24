/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.functional.AdditionalButtonsBehaviour;
import basisFx.appCore.functional.RowCreater;
import basisFx.appCore.menu.MenuComponent;

/**
 *
 * @author Alek
 */
public class EventFactory {
    
    private static EventFactory eventFactory=null;

    private EventFactory() {
    }
    

    public static EventFactory getInstance() {
       if (EventFactory.eventFactory==null){
       
           EventFactory.eventFactory=new EventFactory();
           return EventFactory.eventFactory;
           
       }else{
       
            return EventFactory.eventFactory; 
       }
    }
    
    
   public   AppEvent createClosingWindowEvent(){
   
       return new CloseWindow();
       
   
   }
   public   AppEvent createHidingWindowEvent(){
   
       return new HideWindow();
       
   
   }
   public   AppEvent createMaximazingSwitcher(){
   
       return new MaximazingSwither();
       
   
   }
   public   AppEvent createDbClickEvent(AppEvent appEvent){
   
       return new DbClick(appEvent);
       
   
   }
   public   AppEvent createStageDragging(){
   
       return new StageDragging();
       
   
   }
   
   public   AppEvent createleftSideMenuIconClick(MenuComponent component){
   
       return new leftSideMenuIconClick(component);
       
   
   }
   public   MenuButtonsClick createMenuButtonsClick(MenuComponent component, AdditionalButtonsBehaviour b){
   
       return new MenuButtonsClick(component,b);
       
   
   }
    public   RowAddToTable createRowAdd(TableViewWrapper t, RowCreater rowCreater ){

        return new RowAddToTable(t, rowCreater);

    }
    public   RowDeleteFromTable createRowDeleteFromTable(TableViewWrapper t ){

        return new RowDeleteFromTable(t);

    }
}
