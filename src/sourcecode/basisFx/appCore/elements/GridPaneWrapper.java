package basisFx.appCore.elements;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public  class GridPaneWrapper extends AppNode{
   protected GridPane element;
    protected boolean gridLinesVisibility=false;

    private GridPaneWrapper(Builder builder) {
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
        gridLinesVisibility = builder.gridLinesVisibility;



        element=new GridPane();
        element.setGridLinesVisible(gridLinesVisibility);
    }

    public static Builder newBuilder() {
        return new Builder();
    }




    public void setRowConstraints(){
        RowConstraints rc = new RowConstraints();
        element.getRowConstraints().add(rc);

    }



    public void setColumnVsPercent(double percentWidth){
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(percentWidth);
        element.getColumnConstraints().add(column);

    }

    public void setColumnFixed( double width ){
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(width);
        element.getColumnConstraints().add(column);


    }
    public void setColumn ( ){
        ColumnConstraints column = new ColumnConstraints();
        element.getColumnConstraints().add(column);


    }


    public void setColumnComputerWidth(  ){
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow( Priority.ALWAYS );
        element.getColumnConstraints().add(column);



    }

    //добавляет элемент, который будет для нескольких колонок
    public void addSpanNode(Node child,int columnIndex,int rowIndex,int colspan,int rowspan,HPos halignment, VPos valignment,Insets insets){


        element.add( child, columnIndex, rowIndex, colspan, rowspan);
        setConstraints(child, halignment,  valignment);
        setMargin(child,insets);

    }


    private void setConstraints(Node child,HPos halignment, VPos valignment){
        GridPane.setValignment(child,valignment);
        GridPane.setHalignment(child,halignment);
    }

    private void setMargin(Node child, Insets in){
        GridPane.setMargin(child,in);

    }






    @Override
    public GridPane getElement() {
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
        private FlowPane parentFlowPane;
        private ScrollPane parentScrollPane;
        private String name;
        private Stage stage;
        private boolean gridLinesVisibility;

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

        public Builder setGridLinesVisibility(boolean val) {
            gridLinesVisibility = val;
            return this;
        }

        public GridPaneWrapper build() {
            return new GridPaneWrapper(this);
        }
    }
}
