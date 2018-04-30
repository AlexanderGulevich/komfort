/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.fabrics.EventFactory;
import basisFx.appCore.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class MenuRepresent {
    
    protected CSSID css;
    protected MenuComponent menuComponent;
    protected AnchorPane ap;
    protected Coordinate c;
    protected Double width;
    protected Double height;
    protected EventFactory eventFactory=EventFactory.getInstance();
    
    public abstract <T> void   makeStructuredMenuView(MenuComponent c, T parentMenu );
    
    public abstract void make();
    
    
    
    public void setCss(CSSID id) {
        this.css = id;
         }
      
    public void setMenuComponent(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
    }


    public void setParentAnchor(AnchorPane ap) {
        this.ap = ap;
    }

    public void setCoordinate(Coordinate c) {
        this.c = c;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
   
    
}
