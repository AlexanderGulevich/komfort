package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.CallBackTyped;
import basisFx.service.ServiceCrossWindow;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.Setter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClosePopupAndSubWindow extends AppEvent{
    protected Button  but;
    protected Long sleepMillis;
    @Setter protected CallBackTyped callBackTyped;

    public void setSleepMillis(long sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void setEventToElement(AppNode n) {
        this.nodeWrapper =n;
        this.but=(Button) n.getElement();
        but.setOnMouseClicked((event) ->check()) ;
        but.setOnAction((event) -> check());
    }

    private void check() {
        if (callBackTyped != null) {
            Boolean call = (Boolean) callBackTyped.call();
            if (call) {
                run();
            }
        } else {
            run();
        }
    }

    @Override
    public void setEventToElement(Node node) {
        this.but=(Button) node;
        but.setOnMouseClicked((event) -> check());
        but.setOnAction((event) ->  check());
    }

    @Override
    public void run() {
        try {

            if (sleepMillis != null) {
                Thread.sleep(sleepMillis);
            }else {
                Thread.sleep(1);
            }

            if (mediator != null) {
                mediator.inform(but);
                ((ServiceCrossWindow) mediator).close();
            }
            Window window = but.getScene().getWindow();
            Stage stage= ((Stage) window);
            stage.close();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClosePopupAndSubWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }



}
