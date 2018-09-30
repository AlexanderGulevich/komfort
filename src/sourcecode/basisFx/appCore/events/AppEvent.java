package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;

import java.sql.SQLException;

public abstract class AppEvent {

    protected AppNode nodeWrapper;

    public abstract void setEventToElement(AppNode node);
    public AppEvent setElementNonLogic(AppNode node){

        this.nodeWrapper =node;
        return this;

    };
    public abstract void run() throws SQLException;

}
