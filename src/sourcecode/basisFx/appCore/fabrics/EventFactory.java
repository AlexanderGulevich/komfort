/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.*;
import basisFx.appCore.interfaces.AdditionalButtonsBehaviour;
import basisFx.appCore.interfaces.RowCreater;
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


    public AppEvent closingWindow(){

        return new CloseWindow();


    }
    public AppEvent closingPopup(){

        return new ClosePopup();


    }
   public   AppEvent hidingWindow(){
   
       return new HideWindow();
       
   
   }
   public   AppEvent maximazingSwitcher(){
   
       return new MaximazingSwither();
       
   
   }
   public   AppEvent dbClickEvent(AppEvent appEvent){
   
       return new DbClick(appEvent);
       
   
   }
   public   AppEvent stageDragging(){
   
       return new StageDragging();
       
   
   }

   public   AppEvent leftSideMenuIconClick(MenuComponent component){
   
       return new leftSideMenuIconClick(component);
       
   
   }
   public   MenuButtonsClick menuButtonsClick(MenuComponent component, AdditionalButtonsBehaviour b){
   
       return new MenuButtonsClick(component,b);
       
   
   }
    public   RowAddToTable rowAdd(TableWrapper t, RowCreater rowCreater ){

        return new RowAddToTable(t, rowCreater);

    }
    public   RowDeleteFromTable rowDeleteFromTable(TableWrapper t ){

        return new RowDeleteFromTable(t);

    }
}
