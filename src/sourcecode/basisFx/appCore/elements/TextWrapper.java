package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FontLogic;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TextWrapper extends AppNode{

    protected Text element;
    protected FontsStore font;
    protected Double fontSize;
    protected String text;

    private TextWrapper(Builder builder) {
        element=new Text();

        events = builder.events;
        cssid = builder.cssid;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        metaName = builder.name;
        font = builder.font;
        fontSize = builder.fontSize;
        text = builder.text;
        metaName=builder.metaName;



        bond(this);
        elocateEvents();
        setId();
        setText();
        setFont();

    }

    private void setFont() {
        if(font!=null && fontSize!=null) {
            element.setFont(FontLogic.loadFont(font,fontSize));
        }
    }
    private void setText() {
        if (text != null) {
            element.setText(text);
        }
    }

    private void setId() {
        if (cssid != null) {
            element.setId(cssid.get());
        }
    }
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public Text getElement() {
        return element;
    }


    public static final class Builder {
        public String metaName;
        private String text;
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private FontsStore font;
        private double fontSize;

        private Builder() {
        }

        public Builder setMetaName(String metaName) {
            this.metaName = metaName;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setEvents(ArrayList<AppEvent> val) {
            events = val;
            return this;
        }

        public Builder setCssid(CSSID val) {
            cssid = val;
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

        public Builder setFont(FontsStore val) {
            font = val;
            return this;
        }

        public Builder setFontSize(double val) {
            fontSize = val;
            return this;
        }

        public TextWrapper build() {
            return new TextWrapper(this);
        }
    }
}
