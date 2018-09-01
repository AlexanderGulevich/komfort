/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

/**
 *
 * @author Alek
 */
public class HideWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setElement(AppNode node) {
        this.appNode=node;
        this.but=(Button) node.getElement();


        but.setOnMouseClicked( (event) -> {
           run();

        }

        ) ;


}

    @Override
    public void run() {
         try {
                Thread.sleep(200);
                appNode.getStage().setIconified(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
