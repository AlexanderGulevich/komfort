package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import javafx.scene.control.Button;

public class ClosePopup extends AppEvent{
    protected Button but;
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
    public void run() {


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        nodeWrapper.getStage().close();





    }

}
