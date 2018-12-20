/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FontLogic;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public  class TextAreaWrapper extends AppNode{

    protected TextArea element;
    protected Boolean isEditable;
    protected Boolean isWrapText;
    protected FontsStore font;
    protected Double fontSize;
    protected String text;

    private TextAreaWrapper(Builder builder) {
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
        isEditable = builder.isEditable;
        isWrapText = builder.isWrapText;
        font = builder.font;
        fontSize = builder.fontSize;
        text = builder.text;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void setText() {
        if (text != null) {
            element.setText(text);
        }
    }

    private void setFont() {
        if (font != null && fontSize != null) {
            Font f = FontLogic.loadFont(font, fontSize);
            element.setFont(f);
        }
    }

    private void setWrapText() {
        if (isWrapText != null) {

            element.setWrapText(isWrapText);
        }
    }





    @Override
    public TextArea getElement() {
        element=new TextArea();
        return element;


    }

    private void setEditable() {
        if (isEditable != null) {
            element.setEditable(isEditable);
        }
    }


    public static final class Builder {
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Double width;
        private Double height;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private Stage stage;
        private Boolean isEditable;
        private Boolean isWrapText;
        private FontsStore font;
        private Double fontSize;
        private String text;

        private Builder() {
        }

        public Builder setEvents(ArrayList<AppEvent> val) {
            events = val;
            return this;
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

        public Builder setIsEditable(Boolean val) {
            isEditable = val;
            return this;
        }

        public Builder setIsWrapText(Boolean val) {
            isWrapText = val;
            return this;
        }

        public Builder setFont(FontsStore val) {
            font = val;
            return this;
        }

        public Builder setFontSize(Double val) {
            fontSize = val;
            return this;
        }

        public Builder setText(String val) {
            text = val;
            return this;
        }

        public TextAreaWrapper build() {
            return new TextAreaWrapper(this);
        }
    }
}
