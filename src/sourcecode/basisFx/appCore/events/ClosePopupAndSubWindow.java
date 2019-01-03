package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Registry;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClosePopupAndSubWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setEventToElement(AppNode n) {
        this.nodeWrapper =n;
        this.but=(Button) n.getElement();
        but.setOnMouseClicked((event) -> {
            run();
        }
        ) ;
    }

    @Override
    public void setEventToElement(Node node) {
        this.but=(Button) node;
        but.setOnMouseClicked((event) -> {
                    run();
                }
        ) ;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            nodeWrapper.getStage().close();
            Registry.infoWindow=null;
            } catch (InterruptedException ex) {
                Logger.getLogger(ClosePopupAndSubWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }



}
