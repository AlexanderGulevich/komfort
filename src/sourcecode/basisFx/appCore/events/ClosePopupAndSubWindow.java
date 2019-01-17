package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Registry;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

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
            Thread.sleep(1);

            if (mediator != null) {
                mediator.inform(but);
            }
            Window window = but.getScene().getWindow();
            Stage stage= ((Stage) window);
            stage.close();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClosePopupAndSubWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }



}
