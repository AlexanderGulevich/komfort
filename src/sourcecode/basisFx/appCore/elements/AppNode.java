package basisFx.appCore.elements;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public abstract class AppNode <T extends Node> {

    protected ArrayList<AppEvent> events;
    protected CSSID cssid;
    protected Double width;
    protected Double height;
    protected Coordinate coordinate;
    protected AnchorPane parentAnchor;
    protected AppNode parent;
    protected Group parentGroup;
    protected FlowPane parentFlowPane;
    protected ScrollPane parentScrollPane;
    protected String name;
    protected Stage stage;

    public String getName() {
        return name;
    }

    public abstract T getElement();

    public Stage getStage() {
        return stage;
    }

    //    protected ArrayList <AppNode> children=new ArrayList<>();
//    protected ArrayList <AppEvent> events=new ArrayList<>();

//    protected Insets insects;

//    protected Font font;
//    protected boolean hasBond;

//    protected String string;
//    protected Insets insets;
//    protected DropShadow dropShadow;



//    protected Callback callback;

//    protected Double widthPerCent=null;
//    protected Pos pos=null;
//    protected KindOfSubmitElement mark;
//

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
            next.setElement(this);

        }
        }
       
        
    
             
    }

 



    }

       


   
   


    

   
    
    
