/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class MenuRepresent {
    
    protected  CSSID css;
    protected  MenuComponents menuComponent;
    protected  AnchorPane ap;
    protected  AnchorCoordinate c;
    protected Double width;
    protected Double height;
    
    
    public abstract <T> void   makeStructuredMenuView(MenuComponents c, T parentMenu );
    
    public abstract void make();
    
    
    
    public void setCss(CSSID id) {
        this.css = id;
         }
      
    public void setMenuComponent(MenuComponents menuComponent) {
        this.menuComponent = menuComponent;
    }


    public void setParentAnchor(AnchorPane ap) {
        this.ap = ap;
    }

    public void setCoordinate(AnchorCoordinate c) {
        this.c = c;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    
    
    

    
    
    
    
    //StaticFabricsMethods
    
    public static MenuBarRepresent menuNBarFabric(){
         
        return new MenuBarRepresent();
        
        
    }
    
    public static LeftSideMenuRepresent menuLeftSideFabric(LeftSideMenuRepresent.namesPanelPalaced np){
         
        return new LeftSideMenuRepresent(np);
        
        
    }
    
    

    
}
