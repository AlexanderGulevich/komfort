package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class FlowPaneWrapper extends AppNode{

    private FlowPane element =new FlowPane();
    private Double vGap;
    private Double hGap;
    private Insets insects;
    private DropShadow dropShadow;

    private FlowPaneWrapper(Builder builder) {
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
        vGap = builder.vGap;
        hGap = builder.hGap;
        insects = builder.insects;
        dropShadow = builder.dropShadow;

        bond(this);
        elocateEvents();
        setGap();
        setSize();
        setDropShadow();
        setPadding();
        applyCssId();


    }

    private void applyCssId() {
        if (cssid != null) {
            element.setId(cssid.get());
        }
    }

    private void setPadding() {
        if(insects!=null) element.setPadding(insects);
    }

    private void setDropShadow() {
        if(dropShadow!=null) element.setEffect(dropShadow);
    }

    private void setSize() {
        if(this.height!=null) {
            element.setPrefHeight(this.height);
        }
        if(this.width!=null) {
            element.setPrefWidth(this.width);
        }
    }

    private void setGap() {
        if (vGap != null) {
            element.setVgap(vGap);
        }
        if (hGap != null) {
            element.setHgap(hGap);
        }

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public javafx.scene.layout.FlowPane getElement() {
        return element;
    }

    public static final class Builder {
        private ArrayList<AppEvent> events;
        private CSSID cssid;
        private Double width;
        private Double height;
        private Coordinate coordinate;
        private AnchorPane parentAnchor;
        private Group parentGroup;
        private javafx.scene.layout.FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private Double vGap;
        private Double hGap;
        private Insets insects;
        private DropShadow dropShadow;

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

        public Builder setParentFlowPane(javafx.scene.layout.FlowPane val) {
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

        public Builder setVGap(Double val) {
            vGap = val;
            return this;
        }

        public Builder setHGap(Double val) {
            hGap = val;
            return this;
        }

        public Builder setInsects(Insets val) {
            insects = val;
            return this;
        }

        public Builder setDropShadow(DropShadow val) {
            dropShadow = val;
            return this;
        }

        public FlowPaneWrapper build() {
            return new FlowPaneWrapper(this);
        }
    }



}
