/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.elements.AppNode;
import javafx.scene.Node;

/**
 *
 * @author Alek
 */
public abstract class Target<T extends Node> {
    
    public abstract void createElement();
    public abstract T getTargetElement();
    
    
    
    
}
