/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class DbClick  extends AppEvent{

    protected Node  node;
    protected AppEvent  innerEvent;

    public DbClick(AppEvent appEvent) {
       this.innerEvent=appEvent;
    }
    
    @Override
    public void setEventToElement(AppNode appNode) {
        
        this.node=appNode.getElement();
        this.nodeWrapper =appNode;
        
        
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {

                    try {
                        run();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }}
            }
        );
        
       
      
        
}

    @Override
    public void run() throws SQLException {
        this.innerEvent.setElementNonLogic(nodeWrapper).run();
        
    }
}
