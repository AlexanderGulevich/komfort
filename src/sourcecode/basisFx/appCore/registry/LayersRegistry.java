/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.registry;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public  class LayersRegistry {
        private    static  AnchorPane root;
        private    static  AnchorPane transparentRoot;
        private    static  AnchorPane contentLayer;  
        
        
    public static AnchorPane getRoot() {
        return root;
    }
    public static void setInerRoot(AnchorPane r) {
        root = r;
    }
    public  static  AnchorPane getTransparentRoot() {
        return transparentRoot;
    }
    public  static void setTransparentRoot(AnchorPane r) {
       transparentRoot = r;
    }
    public  static AnchorPane getContentLayer() {
        return contentLayer;
    }
    public  static void setContentLayer(AnchorPane c) {
        contentLayer = c;
    }
    
    
}
