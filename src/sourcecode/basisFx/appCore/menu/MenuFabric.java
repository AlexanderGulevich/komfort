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
public  class MenuFabric {
    
    

//    public static MenuBarRepresent menuBar(){
//
//        return new MenuBarRepresent();
//
//
//    }

    public  static LeftAndTopMenuRepresent createMenuLeftSideRepresentation(MenuSketch sketch){

        return new LeftAndTopMenuRepresent(sketch);


    }
    
    
}
