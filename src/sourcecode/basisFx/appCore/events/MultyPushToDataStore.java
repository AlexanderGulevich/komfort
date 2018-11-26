package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import javafx.scene.control.Button;


public class MultyPushToDataStore  extends AppEvent{

    private Button but;
    private ButtonWrapper buttonWrapper;

    @Override
    public void setEventToElement(AppNode node) {

        buttonWrapper=(ButtonWrapper) node;
        but=(Button) node.getElement();
        but.setOnMouseClicked((event) -> {
            run();
        });
    }

    @Override
    public void run()  {
        buttonWrapper.getServiceMediator().inform(buttonWrapper);
    }
}