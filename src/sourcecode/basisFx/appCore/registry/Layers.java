/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.registry;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

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
        private    static  AnchorPane verticalMenuPanel;
        private    static  FlowPane   horisontalFlowPanel;
        private    static  AnchorPane textAnchorPanel;
        private    static  AnchorPane windowButtonsPanel;
        private    static  AnchorPane popupTitlePunel;
        private    static  AnchorPane popupTransparentRoot;
        private    static  AnchorPane popupVisibleRoot;
        private    static  AnchorPane popupButtonPanel;
        private    static  AnchorPane popupContentPanel;
        private    static  AnchorPane iconAnchorPanel;


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

    public static void setVerticalMenuPanel(AnchorPane panel) {
        Layers.verticalMenuPanel = panel;
    }

    public static AnchorPane getVerticalMenuPanel() {
        return verticalMenuPanel;
    }

    public static void setHorisontalFlowPanel(FlowPane panel) {
          Layers.horisontalFlowPanel = panel; 
    }
    
    public static FlowPane getHorisontalFlowPanel() {
        return horisontalFlowPanel;
    }

    public static void setTextAnchorPanel(AnchorPane panel) {
          Layers.textAnchorPanel = panel; 
    }

    public static AnchorPane getTextAnchorPanel() {
        return textAnchorPanel;
    }


    public static void setWindowButtonsPanel(AnchorPane windowButtonsPanel) {
        Layers.windowButtonsPanel = windowButtonsPanel;
    }

    public static AnchorPane getWindowButtonsPanel() {
        return windowButtonsPanel;
    }

    public static void setPopupTitlePunel(AnchorPane popupTitlePunel) {
        Layers.popupTitlePunel = popupTitlePunel;
    }

    public static AnchorPane getPopupTitlePunel() {
        return popupTitlePunel;
    }

    public static void setPopupTransparentRoot(AnchorPane popupTransparentRoot) {
        Layers.popupTransparentRoot = popupTransparentRoot;

        System.out.println("Layers.setPopupVisibleRoot -- popupTransparentRoot === "+popupTransparentRoot);
    }

    public static AnchorPane getPopupTransparentRoot() {
        return popupTransparentRoot;
    }

    public static void setPopupVisibleRoot(AnchorPane popupVisibleRoot) {
        Layers.popupVisibleRoot = popupVisibleRoot;

        System.out.println("Layers.setPopupVisibleRoot -- popupVisibleRoot === "+popupVisibleRoot);
    }

    public static AnchorPane getPopupVisibleRoot() {
        return popupVisibleRoot;
    }

    public static void setPopupButtonPanel(AnchorPane popupButtonPanel) {
        Layers.popupButtonPanel = popupButtonPanel;
    }

    public static AnchorPane getPopupButtonPanel() {
        return popupButtonPanel;
    }

    public static void setPopupContentPanel(AnchorPane popupContentPanel) {
        Layers.popupContentPanel = popupContentPanel;
    }

    public static AnchorPane getPopupContentPanel() {
        return popupContentPanel;
    }

    public static void setIconAnchorPanel(AnchorPane iconAnchorPanel) {
        Layers.iconAnchorPanel = iconAnchorPanel;
    }

    public static AnchorPane getIconAnchorPanel() {
        return iconAnchorPanel;
    }
}
