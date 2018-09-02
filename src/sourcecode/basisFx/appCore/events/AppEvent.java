package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;

import java.sql.SQLException;

public abstract class AppEvent {

    protected AppNode appNode;

    public abstract void setElement(AppNode node);
    public AppEvent setElementNonLogic(AppNode node){

        this.appNode=node;
        return this;

    };
    public abstract void run() throws SQLException;

}
