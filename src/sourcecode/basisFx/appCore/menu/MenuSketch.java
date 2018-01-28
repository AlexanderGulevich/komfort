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
public abstract class MenuSketch {
    protected MenuSketchUtils menuHierarchy;
    public abstract void initSpiritNodes();

    public MenuSketchUtils getMenuHierarchy() {
        return menuHierarchy;
    }
    
    
}
