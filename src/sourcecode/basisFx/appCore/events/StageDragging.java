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
    public void setEventToElement(AppNode appNode) {
        this.nodeWrapper =appNode;
        this.node= appNode.getElement();
        stage=appNode.getStage();
        run();


}

    @Override
    public void run() {

         node.setOnMousePressed(event -> {

             System.out.println("StageDragging.handle");
              if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {

                  if(!stage.isMaximized()){
                     xOffset = stage.getX() - event.getScreenX();
                     yOffset = stage.getY() - event.getScreenY();
                  }

             }



         });

         node.setOnMouseDragged(event -> {
             System.out.println("StageDragging.run");
              if(!stage.isMaximized()){
                     stage.setX(event.getScreenX() + xOffset);
                     stage.setY(event.getScreenY() + yOffset);
              }
         });


    }








}