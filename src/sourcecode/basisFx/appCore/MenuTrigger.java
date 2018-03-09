/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.appCore.registry.Layers;
import javafx.scene.control.Button;

/**
 *
 * @author Alek
 */
public class MenuTrigger {
     public void verticalMenuButtonFire(int n){
         Button but = (Button) Layers.getVerticalMenuPanel().getChildren().get(n);
         but.fire();
    }
}
