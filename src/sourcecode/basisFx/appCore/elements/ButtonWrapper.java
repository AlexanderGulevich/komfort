package basisFx.appCore.elements;

import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FontLogic;
import basisFx.service.ServiceMediator;
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

public class ButtonWrapper extends AppNode{

    protected Boolean isActive;
    protected Insets insects;
    protected FontsStore font;
    protected Double fontSize;
    protected Button element;
    protected String string;
    protected Node graphicNode;
    protected ContentDisplay contentDisplay;
    protected ServiceMediator serviceMediator;

    private ButtonWrapper(Builder builder) {
        element=new Button();

        events = builder.events;
        cssid = builder.cssid;
        width = builder.width;
        height = builder.height;
        coordinate = builder.coordinate;
        parentAnchor = builder.parentAnchor;
        parentGroup = builder.parentGroup;
        parentFlowPane = builder.parentFlowPane;
        parentScrollPane = builder.parentScrollPane;
        text = builder.text;
        stage = builder.stage;
        isActive = builder.isActive;
        insects = builder.insects;
        font = builder.font;
        fontSize = builder.fontSize;
        string = builder.string;
        graphicNode = builder.graphicNode;
        contentDisplay = builder.contentDisplay;
        serviceMediator = builder.serviceMediator;
        metaName=builder.metaName;


        setId();
        setName();
        setPadding();
        setGraphics();
        setFont();
        setSize();
        bond(this);
        elocateEvents();

    }

    public ServiceMediator getServiceMediator() {
        return serviceMediator;
    }

    public void makeActive() {
        if (isActive != null && isActive==true) {

            element.fire();

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

        if (text != null
//                && contentDisplay!=null
                ) {
            element.setText(text);
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
        public String text;
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
        private boolean isActive;
        private Insets insects;
        private FontsStore font;
        private double fontSize;
        private String string;
        private Node graphicNode;
        private ContentDisplay contentDisplay;
        protected ServiceMediator serviceMediator;
        private String metaName;

        private Builder() {
        }


        public Builder setEvents(AppEvent ...val) {
            events=new ArrayList<>();
//            events.addAll(Arrays.asList(val));
            for (AppEvent event:val
                 ) {
                events.add(event);
            }
            return this;
        }

        public ButtonWrapper build() {
            return new ButtonWrapper(this);
        }

        public Builder setCSSid(CSSID val) {
            cssid = val;
            return this;
        }

        public Builder setServiceMediator(ServiceMediator serviceMediator) {
            this.serviceMediator = serviceMediator;
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

        public Builder setText(String val) {
            text = val;
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

        public Builder setMetaName(String metaName) {
            this.metaName = metaName;
            return this;
        }
    }
}
