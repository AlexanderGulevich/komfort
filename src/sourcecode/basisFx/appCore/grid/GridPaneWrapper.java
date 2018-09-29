package basisFx.appCore.grid;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public  class GridPaneWrapper extends AppNode {
   protected GridPane element;
    protected boolean gridLinesVisibility=false;
    public LabelWrapper label;
    public TablesButtonKindConfigurationStrategy buttonKindConfigurationStrategy;
    private ArrayList <ColumnConstraints> column ;

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
        column=builder.columns;
        buttonKindConfigurationStrategy=builder.buttonKindConfigurationStrategy;
        applyLabel();
        applyColums();
        applyButtonStrategy();


        element=new GridPane();
        element.setGridLinesVisible(gridLinesVisibility);
    }

    private void applyButtonStrategy() {
        if (buttonKindConfigurationStrategy != null) {
            buttonKindConfigurationStrategy.organize(this);
        }
    }

    private void applyColums() {
        for (ColumnConstraints columnConstraints:column
             ) {
            element.getColumnConstraints().add(columnConstraints);
        }
    }

    //        gridPaneWrapper.addSpanNode(
//                observedGrid.getGridPane(),
//                0,0,1,1, HPos.LEFT, VPos.TOP,insets);
//
//        gridPaneWrapper.addSpanNode(
//                observerGrid.getGridPane(),
//                1,0,1,1, HPos.LEFT, VPos.TOP,insets);
//
//
//
//        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//
//
//        observedGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//        observerGrid.getGridPane().setPrefHeight(gridPane.getHeight());
//
//    });
    private void applyLabel() {

        if (name != null) {
            label =LabelWrapper.newBuilder()
                    .setName(name)
                    .setFont(FontsStore.ROBOTO_LIGHT)
                    .setAlignment(Pos.BASELINE_LEFT)
                    .setFontSize(20d)
                    .build();
        }


    }
    private void tableHeightSwitchingByGrid(TableView tableView) {

        element.heightProperty().addListener((obs, oldVal, newVal) -> {

            tableView.setPrefHeight(element.getHeight());
        });

    }

    public static Builder newBuilder() {
        return new Builder();
    }




    public void setRowConstraints(){
        RowConstraints rc = new RowConstraints();
        element.getRowConstraints().add(rc);

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
        private TablesButtonKindConfigurationStrategy buttonKindConfigurationStrategy;
        private ArrayList <ColumnConstraints> columns;

        private Builder() {
        }

        public Builder setButtonKindConfigurationStrategy(TablesButtonKindConfigurationStrategy buttonKindConfigurationStrategy) {
            this.buttonKindConfigurationStrategy = buttonKindConfigurationStrategy;
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

        public void setColumnVsPercent(double percentWidth){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(percentWidth);
            columns.add(column);

        }

        public void setColumnFixed( double width ){
            ColumnConstraints column = new ColumnConstraints();
            column.setPrefWidth(width);
            columns.add(column);


        }
        public void setColumn ( ){
            ColumnConstraints column = new ColumnConstraints();
            columns.add(column);


        }


        public void setColumnComputerWidth(  ){
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow( Priority.ALWAYS );
            columns.add(column);



        }


        public GridPaneWrapper build() {
            return new GridPaneWrapper(this);
        }
    }
}
