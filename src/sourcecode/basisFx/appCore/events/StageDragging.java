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
import javafx.stage.Stage;


public class StageDragging extends AppEvent{
protected Node  node;
protected static double xOffset = 0;
protected static double yOffset = 0;
protected Stage stage;

    @Override
    public void setElement(AppNode appNode) {
        this.appNode=appNode;
        this.node= appNode.getElement();
        stage=appNode.getStage();
        run();


}

    @Override
    public void run() {

         node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                 if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {

                     if(!stage.isMaximized()){
                        xOffset = stage.getX() - event.getScreenX();
                        yOffset = stage.getY() - event.getScreenY();
                     }

                }



            }
        });

         node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 if(!stage.isMaximized()){
                        stage.setX(event.getScreenX() + xOffset);
                        stage.setY(event.getScreenY() + yOffset);
                 }
            }
        });


    }








}