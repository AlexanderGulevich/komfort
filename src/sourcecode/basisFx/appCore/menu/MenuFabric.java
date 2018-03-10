/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

/**
 *
 * @author Alek
 */
public class MenuFabric {
    
    
    
    public  MenuBarRepresent menuNBarFabric(){
         
        return new MenuBarRepresent();
        
        
    }
    
    public  LeftSideMenuRepresent createMenuLeftSideRepresentation(){
         
        return new LeftSideMenuRepresent();
        
        
    }
    
    
}
