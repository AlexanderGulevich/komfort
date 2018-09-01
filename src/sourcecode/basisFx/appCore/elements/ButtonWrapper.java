/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

//import basisFx.appCore.events.AppEvent;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FontLogic;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class ButtonWrapper extends AppNode{

    protected boolean isActive;
    protected Insets insects;
    protected FontsStore font;
    protected Double fontSize;
    protected Button element=new Button();
    protected String string;
    protected Node graphicNode;
    protected ContentDisplay contentDisplay;
    protected ArrayList<AppEvent> events;

    private ButtonWrapper(Builder builder) {
        events = builder.events;
        cssid = builder.cssid;
        width = builder.width;
        height = builder.height;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        name = builder.name;
        stage = builder.stage;
        isActive = builder.isActive;
        insects = builder.insects;
        font = builder.font;
        fontSize = builder.fontSize;
        string = builder.string;
        graphicNode = builder.graphicNode;
        contentDisplay = builder.contentDisplay;
        parent = builder.parent;


        setName();
        setPadding();
        setGraphics();
        setFont();
        setSize();

        bond(this);
        elocateEvents();




    }

    public static Builder newBuilder() {
        return new Builder();
    }


    @Override
    public Button getElement() {
        return element;
    }


    private void setSize() {
        if(this.height!=null) {
            element.setPrefHeight(this.height);
        }
        if(this.width!=null) {
            element.setPrefWidth(this.width);
        }
    }

    private void setPadding() {
        if(insects!=null){
            element.setPadding(insects);
        }
    }

    private void setFont() {
        if(font!=null && fontSize!=null) {
            element.setFont(FontLogic.loadFont(font,fontSize));
        }
    }

    public void setGraphics(){
        if (graphicNode != null && contentDisplay!=null) {
            element.setGraphic(graphicNode);
            element.setContentDisplay(contentDisplay);
        }
    }

    public void setName(){

        if (name != null
//                && contentDisplay!=null
                ) {
            element.setText(name);
//            element.setContentDisplay(contentDisplay);
        }


    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }


    public static final class Builder {
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Double width;
        private Double height;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private AppNode parent;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private Stage stage;
        private boolean isActive;
        private Insets insects;
        private FontsStore font;
        private double fontSize;
        private String string;
        private Node graphicNode;
        private ContentDisplay contentDisplay;

        private Builder() {
        }


        public Builder setEvents(AppEvent ...val) {
            events=new ArrayList<>();
            events.addAll(Arrays.asList(val));
            return this;
        }

        public ButtonWrapper build() {
            return new ButtonWrapper(this);
        }

        public Builder setCssid(CSSID val) {
            cssid = val;
            return this;
        }

        public Builder setWidth(Double val) {
            width = val;
            return this;
        }

        public Builder setHeight(Double val) {
            height = val;
            return this;
        }

        public Builder setCoordinate(Coordinate val) {
            coordinate = val;
            return this;
        }

        public Builder setParentAnchor(AnchorPane val) {
            parentAnchor = val;
            return this;
        }
        public Builder setParent(AppNode val) {
            parent = val;
            return this;
        }

        public Builder setParentGroup(Group val) {
            parentGroup = val;
            return this;
        }

        public Builder setParentFlowPane(FlowPane val) {
            parentFlowPane = val;
            return this;
        }

        public Builder setParentScrollPane(ScrollPane val) {
            parentScrollPane = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Builder setStage(Stage val) {
            stage = val;
            return this;
        }

        public Builder setIsActive(boolean val) {
            isActive = val;
            return this;
        }

        public Builder setInsects(Insets val) {
            insects = val;
            return this;
        }

        public Builder setFont(FontsStore val) {
            font = val;
            return this;
        }

        public Builder setFontSize(double val) {
            fontSize = val;
            return this;
        }

        public Builder setString(String val) {
            string = val;
            return this;
        }

        public Builder setGraphicNode(Node val) {
            graphicNode = val;
            return this;
        }

        public Builder setContentDisplay(ContentDisplay val) {
            contentDisplay = val;
            return this;
        }
    }
}
