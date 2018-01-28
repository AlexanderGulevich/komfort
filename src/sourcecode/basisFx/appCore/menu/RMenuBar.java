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
public class RMenuBar extends MenuRepresent{
    
    private  NMenuBar nMenuBar;
    private  MenuBar menuBar=new MenuBar();
    private  CSSID css;
    private  MenuSketchUtils menuComponent;
    private  AnchorPane ap;
    private  AnchorCoordinate c;

    @Override
    public void setCss(CSSID css) {
        this.css = css;
    }

    @Override
    public void setMenuComponent(MenuSketchUtils menuComponent) {
        this.menuComponent = menuComponent;
    }

    @Override
    public void setParentAnchor(AnchorPane ap) {
        this.ap = ap;
    }

    @Override
    public void setCoordinate(AnchorCoordinate c) {
        this.c = c;
    }
    
    
    
    

    public RMenuBar() {
    }
    
    

    
    @Override
    public void make() {
        
        this.nMenuBar=AppNode.NodeBuilder.create()
                .setParentAnchor(ap)
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
    public <T> void makeStructuredMenuView(MenuSketchUtils menuHierarchy, T parentMenu) {
        
        ArrayList<MenuSketchUtils> h=menuHierarchy.getComponents();
        
                        
        for (Iterator<MenuSketchUtils> iterator = h.iterator(); iterator.hasNext();) {
            MenuSketchUtils next = iterator.next();

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
