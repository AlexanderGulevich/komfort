/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.utils;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public class Coordinate {
    
    private AnchorPane parentAnchorPane;
    
    private Node node;

    public Coordinate(Double top, Double right, Double bottom, Double left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Coordinate(AnchorPane parentAnchorPane, Double top, Double right, Double bottom, Double left) {
        this.parentAnchorPane = parentAnchorPane;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Coordinate(AnchorPane parentAnchorPane, Node node, Double top, Double right, Double bottom, Double left) {
        this.parentAnchorPane = parentAnchorPane;
        this.node = node;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Coordinate() {
    }
    
    
    
        
    public Node getNode() {
        return node;
    }

    public Coordinate setChildNode(Node node) {
        this.node = node;
        return this;
    }

    private Double top;

    private Double right;
    
    private Double bottom;
    
    private Double left;

    public double getLeft() {
        return left;
    }

    public Coordinate setLeft(Double left) {
        this.left = left;
        return this;
    }

    public double getBottom() {
        return bottom;
    }

    public Coordinate setBottom(Double bottom) {
        this.bottom = bottom;
        return this;
    }

    public double getRight() {
        return right;
    }

    public Coordinate setRight(Double right) {
        this.right = right;
        return this;
    }

    public double getTop() {
        return top;
    }

    public Coordinate setTop(Double top) {
        this.top = top;
        return this;
    }

    public AnchorPane getParentAnchorPane() {
        return parentAnchorPane;
    }

    public Coordinate setParentAnchorPane(AnchorPane parentAnchorPane) {
        this.parentAnchorPane = parentAnchorPane;
        return this;
    }
    
    public void bonding () {
        
                if (parentAnchorPane!=null){
                    parentAnchorPane.getChildren().add(node);
                }
                if(top!=null){
                    AnchorPane.setTopAnchor(node, top);
                }
                if(right!=null){
                    AnchorPane.setRightAnchor(node, right);
                }
                if(bottom!=null){
                   AnchorPane.setBottomAnchor(node, bottom);
                }
                if(left!=null){
                    AnchorPane.setLeftAnchor(node, left);
                }

}

    
    
}
