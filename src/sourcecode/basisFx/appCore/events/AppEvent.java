package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.service.Mediator;
import javafx.scene.Node;


public abstract class AppEvent {

    protected AppNode nodeWrapper;
    protected Mediator mediator;

    public abstract void setEventToElement(AppNode node);
    public abstract void setEventToElement(Node node);
    public AppEvent setElementNonLogic(AppNode node){

        this.nodeWrapper =node;
        return this;

    };
    public abstract void run() ;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
