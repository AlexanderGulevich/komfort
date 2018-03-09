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
public  class Layers {
        private    static  AnchorPane visibleRoot;
        private    static  AnchorPane transparentRoot;
        private    static  AnchorPane contentLayer;  
        private    static  AnchorPane titlePanel;  
        private    static  AnchorPane headPanel;
        
        
    public static AnchorPane getVisibleRoot() {
        return visibleRoot;
    }
    public static void setVisibleRoot(AnchorPane r) {
        visibleRoot = r;
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

    public static AnchorPane getTitlePanel() {
        return titlePanel;
    }

    public static void setTitlePanel(AnchorPane titlePanel) {
        Layers.titlePanel = titlePanel;
    }

    public static void setHeadPanel(AnchorPane panel) {
        Layers.headPanel = panel;
    }

    public static AnchorPane getHeadPanel() {
        return headPanel;
    }
    
    
    
}
