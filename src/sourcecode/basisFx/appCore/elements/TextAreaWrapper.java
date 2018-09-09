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



        setEditable();
        setWrapText();
        setFont();
        setText();


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

    public static Builder newBuilder() {
        return new Builder();
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
        private String text;
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

        public void setText(String text) {
            this.text = text;
        }

        private Builder() {
        }

        public Builder events(ArrayList<AppEvent> val) {
            events = val;
            return this;
        }

        public Builder cssid(CSSID val) {
            cssid = val;
            return this;
        }

        public Builder width(Double val) {
            width = val;
            return this;
        }

        public Builder height(Double val) {
            height = val;
            return this;
        }

        public Builder coordinate(Coordinate val) {
            coordinate = val;
            return this;
        }

        public Builder parentAnchor(AnchorPane val) {
            parentAnchor = val;
            return this;
        }

        public Builder parentGroup(Group val) {
            parentGroup = val;
            return this;
        }

        public Builder parentFlowPane(FlowPane val) {
            parentFlowPane = val;
            return this;
        }

        public Builder parentScrollPane(ScrollPane val) {
            parentScrollPane = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder stage(Stage val) {
            stage = val;
            return this;
        }

        public Builder isEditable(Boolean val) {
            isEditable = val;
            return this;
        }

        public Builder isWrapText(Boolean val) {
            isWrapText = val;
            return this;
        }

        public Builder font(FontsStore val) {
            font = val;
            return this;
        }

        public Builder fontSize(Double val) {
            fontSize = val;
            return this;
        }

        public TextAreaWrapper build() {
            return new TextAreaWrapper(this);
        }
    }
}
