package basisFx.appCore.elements;

import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSid;
import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public abstract class AppNode <T extends Node> {

    protected ArrayList<AppEvent> events;
    protected CSSid CSSid;
    protected CSSclasses[] cssClasses;
    protected String[] cssClassesStrings;
    protected Double width;
    protected Double height;
    protected Coordinate coordinate;
    protected AnchorPane parentAnchor;
    protected Group parentGroup;
    protected FlowPane parentFlowPane;
    protected ScrollPane parentScrollPane;
    protected String metaName;
    protected String text;
    protected Stage stage;
    protected WindowAbstraction windowAbstraction;

    public String getMetaName() {
        return metaName;
    }
    public String getText() {
        return text;
    }
    public abstract Node getElement();
    public Stage getStage() {
        return stage;
    }
    public void setElementToWindowRegistry() {
        if (metaName != null) {
            if (windowAbstraction != null) {
                windowAbstraction.setNodeToMap(this);
            }
        }
    }
    public void bond(AppNode node) {
            if(parentAnchor!=null){     bondAnchorAndNode(node);}
            if(parentFlowPane!=null){   bondNodeWithFlowPane(node);}
            if(parentScrollPane!=null){ bondParentScrollPane(node);}
            if(parentGroup!=null){      bondToGroup(node);}
    }
    private boolean bondToGroup(AppNode n) {
        return parentGroup.getChildren().addAll(n.getElement());
    }
    private void bondParentScrollPane(AppNode n) {
        parentScrollPane.setPannable(true);
        parentScrollPane.setContent(n.getElement());
    }
    private void bondNodeWithFlowPane(AppNode node) {
        parentFlowPane.getChildren().add(node.getElement());
    }
    private void bondAnchorAndNode(AppNode node) {
        this.coordinate.setChildNode(node.getElement());
        this.coordinate.setParentAnchorPane(parentAnchor);
        this.coordinate.bonding();
    }
    protected void elocateEvents() {
        if ( events != null  &&! events.isEmpty()) {
            for (Iterator<AppEvent> iterator = events.iterator(); iterator.hasNext();) {
            AppEvent next = iterator.next();
            next.setEventToElement(this);
        }
        }
    }
    protected void applyCssId() {
        if (CSSid != null) {
            getElement().setId(CSSid.get());
        }
    }
    protected void applyCssClasses() {
        if (cssClasses != null) {
            for (int i = 0; i < cssClasses.length; i++) {
                getElement().getStyleClass().add(cssClasses[i].get());
            }
        }
        if (cssClassesStrings != null) {
            for (int i = 0; i < cssClassesStrings.length; i++) {
                getElement().getStyleClass().add(cssClassesStrings[i]);
            }
        }
    }
    }

       


   
   


    

   
    
    
