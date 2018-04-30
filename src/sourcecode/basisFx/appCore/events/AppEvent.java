/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.fabrics.EventFactory;

import java.sql.SQLException;


/**
 *
 * @author 62
 */
public abstract class AppEvent {

    protected AppNode appNode;
    protected EventFactory eventFactory=EventFactory.getInstance();
    
    public abstract void setElement(AppNode node);
    public AppEvent setElementNonLogic(AppNode node){
    
        this.appNode=node;
        return this;
    
    };
    public abstract void run() throws SQLException;
      
}
