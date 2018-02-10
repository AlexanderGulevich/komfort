/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NMenuBar;
import basisFx.domainModel.settings.CSSID;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
 

/**
 *
 * @author Alek
 */
public class MenuBarRepresent extends MenuRepresent{
    
    private  NMenuBar nMenuBar;
    private  MenuBar menuBar=new MenuBar();
    

    public MenuBarRepresent() {
    }
    
    
    @Override
    public void make() {
        
        this.nMenuBar=AppNode.NodeBuilder.create()
                .setParent(ap)
                .setCoordinate(c)
                .setId(css)
                .createNMenuBar();
        this.menuBar=(MenuBar) this.nMenuBar.getElement();
        
        
        makeStructuredMenuView (menuComponent,null);
    }
    
    /*
    @param <T> - конкретное меню, которое содердит подразделы 
    */
    
    @Override
    public <T> void makeStructuredMenuView(MenuComponent menuHierarchy, T parentMenu) {
        
        ArrayList<MenuComponent> h=menuHierarchy.getComponents();
        
                        
        for (Iterator<MenuComponent> iterator = h.iterator(); iterator.hasNext();) {
            MenuComponent next = iterator.next();

            if (next.isComposit){
                
                Menu menu=new Menu (next.getName());
                
                menuBar.getMenus().add(menu) ;
                
                Menu parent;
                        
                if(parentMenu!=null) {
                    parent=(Menu) parentMenu;
                    parent.getItems().add(menu);
                            }
                
                makeStructuredMenuView(next, menu);
                
            }else{
                 MenuItem item=new MenuItem (next.getName());
                 
                 
                 if(parentMenu!=null) {
                    Menu parent=(Menu) parentMenu;
                    parent.getItems().add(item);
                            }
//                 
//                 item.setOnAction((ActionEvent e) -> {
//                     
//                     AppNode unit=next.getFactory().createElement(next.getId());
//                     
//                     
//                     
//                 });
//            
            }
            
        }

    
    }

    
    
    
    

   
    
}
