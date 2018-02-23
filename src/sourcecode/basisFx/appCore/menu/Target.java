/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.controlPolicy.ColumnManager;
import javafx.scene.Node;

/**
 *
 * @author Alek
 */
public abstract class Target<T extends Node> {
    
    protected ColumnManager colManeger=new ColumnManager();
    
    public abstract void createElement();
    public abstract T getTargetElement();
    
    
    
    
}
