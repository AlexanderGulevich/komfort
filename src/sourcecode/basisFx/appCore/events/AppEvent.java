package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.CallBackParametrized;
import basisFx.appCore.interfaces.CallBackTyped;
import basisFx.service.Mediator;
import javafx.scene.Node;
import lombok.Setter;


public abstract class AppEvent {

    protected AppNode nodeWrapper;
    @Setter protected Mediator mediator;
    @Setter protected CallBackParametrized callBackParametrized;
    @Setter protected CallBackTyped callBackTyped;

    public abstract void setEventToElement(AppNode node);
    public abstract void setEventToElement(Node node);
    public abstract void run() ;

}
