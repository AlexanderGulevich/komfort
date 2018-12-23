package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FontLogic;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;


public  class LabelWrapper extends AppNode{

    private Label element;
    protected FontsStore font;
    protected Double fontSize;
    protected Pos alignment;
    protected String text;

    private LabelWrapper(Builder builder) {
        element=new Label();


        events = builder.events;
        cssid = builder.cssid;
        width = builder.width;
        height = builder.height;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        metaName = builder.metaName;
        font = builder.font;
        fontSize = builder.fontSize;
        alignment = builder.alignment;
        text=builder.text;

        setAlignment();
        setFont();
        appllyText();
        elocateEvents();
        applyCssId();
        bond(this);

    }

    private void appllyText() {
        if (text != null) {
            element.setText(text);
        }
    }

    private void setFont() {
        if (font != null && fontSize!=null) {
            element.setFont(FontLogic.loadFont(font,fontSize));
        }
    }

    private void setAlignment() {
        if (alignment != null) {
            element.setAlignment(alignment);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public Label getElement() {
        return element;
    }

    public static final class Builder {
        public String metaName;
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Double width;
        private Double height;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private FontsStore font;
        private double fontSize;
        private Pos alignment;
        private String text;

        public Builder setMetaName(String metaName) {
            this.metaName = metaName;
            return this;
        }

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

        public Builder setFont(FontsStore val) {
            font = val;
            return this;
        }

        public Builder setFontSize(double val) {
            fontSize = val;
            return this;
        }

        public Builder setAlignment(Pos val) {
            alignment = val;
            return this;
        }

        public Builder setText(String val) {
            text = val;
            return this;
        }

        public LabelWrapper build() {
            return new LabelWrapper(this);
        }
    }


}
