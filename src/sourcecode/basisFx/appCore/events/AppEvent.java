package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import javafx.scene.Node;


public abstract class AppEvent {

    protected AppNode nodeWrapper;

    public abstract void setEventToElement(AppNode node);
    public abstract void setEventToElement(Node node);
    public AppEvent setElementNonLogic(AppNode node){

        this.nodeWrapper =node;
        return this;

    };
    public abstract void run() ;

}
