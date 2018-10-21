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
    protected Boolean gridLinesVisibility;
    protected GridOrganization gridOrganization;
    public LabelWrapper label;
    private ArrayList <ColumnConstraints> column ;

    private GridPaneWrapper(Builder builder) {
        element=new GridPane();

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
        gridLinesVisibility=builder.gridLinesVisibility;
        gridOrganization =builder.gridOrganization;
        applyLabel();
        applyColums();
        bond(this);
        applyLineVisibility();
        applyCssId();
        applyGridConfiguration();
        apllyBindingByParentHeight();
    }

    private void apllyBindingByParentHeight() {
        if (parentAnchor != null) {
            bindGridToParentAnchorHeight();
        }
        if (parentScrollPane != null) {
            bindGridToParentScrollPaneHeight();
        }
        if (parentFlowPane != null) {
            bindGridToParentFlowHeight();
        }
    }

    private void bindGridToParentAnchorHeight() {
        parentAnchor.heightProperty().addListener((observable, oldValue, newValue) -> {
            element.setPrefHeight(newValue.doubleValue()-10d);
            System.err.println(newValue.doubleValue());

        });
    }
    private void bindGridToParentFlowHeight() {
        parentFlowPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            element.setPrefHeight(newValue.doubleValue()-10d);
            System.err.println(newValue.doubleValue());

        });
    }
    private void bindGridToParentScrollPaneHeight() {
        parentScrollPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            element.setPrefHeight(newValue.doubleValue()-10d);
            System.err.println(newValue.doubleValue());

        });
    }


    private void applyGridConfiguration() {
        if (gridOrganization != null) {
            gridOrganization.setParentGridPaneWrapper(this);
            gridOrganization.organize();
        }
    }

    private void applyLineVisibility() {
        if (gridLinesVisibility != null) {
            element.setGridLinesVisible(gridLinesVisibility);
        }
    }

    private void applyColums() {
        for (ColumnConstraints columnConstraints:column) {

            element.getColumnConstraints().add(columnConstraints);
        }
    }

    private void applyLabel() {

        if (name != null) {
            label =LabelWrapper.newBuilder()
                    .setCssid(CSSID.LABEL_TEXT)
                    .setName(name)
                    .setFont(FontsStore.ROBOTO_LIGHT)
                    .setAlignment(Pos.BASELINE_LEFT)
                    .setFontSize(25d)
                    .build();
        }


    }
    public void tableHeightSwitchingByGrid(TableView tableView) {

        element.heightProperty().addListener((obs, oldVal, newVal) -> {

            tableView.setPrefHeight(element.getHeight());
        });

    }
    public void tableWidthSwitchingByGrid(TableView tableView) {

        element.widthProperty().addListener((obs, oldVal, newVal) -> {

            tableView.setPrefWidth(element.getWidth());
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
        private ArrayList <ColumnConstraints> columns=new ArrayList<>();
        private boolean gridLinesVisibility;
        private GridOrganization gridOrganization;

        public Builder setGridLinesVisibility(boolean gridLinesVisibility) {
            this.gridLinesVisibility = gridLinesVisibility;
            return this;
        }

        public Builder setGridOrganization(GridOrganization gridOrganization) {
            this.gridOrganization = gridOrganization;
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

        public Builder setName(String val) {
            name = val;
            return this;
        }

        public Builder setStage(Stage val) {
            stage = val;
            return this;
        }

        public Builder setColumnVsPercent(double percentWidth){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(percentWidth);
            columns.add(column);
            return this;

        }

        public Builder setColumnFixed( double width ){
            ColumnConstraints column = new ColumnConstraints();
            column.setPrefWidth(width);
            columns.add(column);
            return this;


        }
        public Builder setColumnWidthByContent( ){
            ColumnConstraints column = new ColumnConstraints();
            columns.add(column);
            return this;


        }


        public Builder setColumnComputerWidth(  ){
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow( Priority.ALWAYS );
            columns.add(column);
            return this;



        }


        public GridPaneWrapper build() {
            return new GridPaneWrapper(this);
        }
    }
}
