///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.appCore.elements;
//
////import basisFx.appCore.events.AppEvent;
//import basisFx.appCore.settings.CSSID;
//import basisFx.appCore.settings.IMGpath;
//import basisFx.appCore.utils.Coordinate;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.FlowPaneWrapper;
//
//import java.util.ArrayList;
//
///**
// *
// * @author Alek
// */
//public class ImgViewWrapper<T extends Node> extends AppNode{
//
//
//    private ImageView element=new ImageView();
//    private IMGpath path;
//
//    private ImgViewWrapper(Builder builder) {
//        events = builder.events;
//        cssid = builder.cssid;
//        width = builder.width;
//        height = builder.height;
//        coordinate = builder.coordinate;
//        parentAnchor = builder.parentAnchor;
//        parentGroup = builder.parentGroup;
//        parentFlowPane = builder.parentFlowPane;
//        parentScrollPane = builder.parentScrollPane;
//        name = builder.name;
//        path = builder.path;
//
//
//        setImage();
//        setSize();
//    }
//
//    private void setSize() {
//        element.setFitHeight(this.height);
//        element.setFitWidth(this.width);
//    }
//
//    private void setImage() {
//        Image image = new Image(path.get());
//        element.setImage(image);
//    }
//
//    public static Builder newBuilder() {
//        return new Builder();
//    }
//
//    @Override
//    public ImageView getElement() {
//        return element;
//    }
//
//
//    public static final class Builder {
//        private ArrayList<AppEvent> events;
//        private CSSID cssid;
//        private Double width;
//        private Double height;
//        private Coordinate coordinate;
//        private AnchorPane parentAnchor;
//        private Group parentGroup;
//        private FlowPaneWrapper parentFlowPane;
//        private ScrollPane parentScrollPane;
//        private String name;
//        private IMGpath path;
//
//        private Builder() {
//        }
//
//        public Builder setEvents(ArrayList<AppEvent> val) {
//            events = val;
//            return this;
//        }
//
//        public Builder setCssid(CSSID val) {
//            cssid = val;
//            return this;
//        }
//
//        public Builder setWidth(Double val) {
//            width = val;
//            return this;
//        }
//
//        public Builder setHeight(Double val) {
//            height = val;
//            return this;
//        }
//
//        public Builder setCoordinate(Coordinate val) {
//            coordinate = val;
//            return this;
//        }
//
//        public Builder setParentAnchor(AnchorPane val) {
//            parentAnchor = val;
//            return this;
//        }
//
//        public Builder setParentGroup(Group val) {
//            parentGroup = val;
//            return this;
//        }
//
//        public Builder setParentFlowPane(FlowPaneWrapper val) {
//            parentFlowPane = val;
//            return this;
//        }
//
//        public Builder setParentScrollPane(ScrollPane val) {
//            parentScrollPane = val;
//            return this;
//        }
//
//        public Builder setName(String val) {
//            name = val;
//            return this;
//        }
//
//        public Builder setPath(IMGpath val) {
//            path = val;
//            return this;
//        }
//
//        public ImgViewWrapper build() {
//            return new ImgViewWrapper(this);
//        }
//    }
//}
