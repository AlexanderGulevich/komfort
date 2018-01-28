/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCustomLogic.settings.CSSID;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class MenuRepresent {
    

    public abstract <T> void   makeStructuredMenuView(MenuSketch c, T parentMenu );
    
    public abstract void setCss(CSSID css);
    public abstract void setMenuComponent(MenuSketch menuComponent);
    public abstract void setParentAnchor(AnchorPane ap);
    public abstract void setCoordinate(AnchorCoordinate c);
    public abstract void make();
    
    //StaticFabricsMethods
    
    public static RepresentMenuBar menuNBarFabric(){
         
        return new RepresentMenuBar();
        
        
    }
    
    

    
}
