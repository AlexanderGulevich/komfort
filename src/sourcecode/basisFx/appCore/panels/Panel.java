package basisFx.appCore.panels;

import basisFx.appCore.fabrics.EventFactory;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Panel {

    protected Coordinate panelCoordinate;
    protected AnchorPane parent;
    protected Stage stage;
    protected AnchorPane panel;
    protected Double width;
    protected Double height;
    protected Insets insects;
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected FontsStore font;
    protected double fontSize;
    protected String name;


    public Panel(PanelBuilder panelBuilder) {
        this.height=panelBuilder.height;
        this.width=panelBuilder.width;
        this.panelCoordinate=panelBuilder.panelCoordinate;
        this.parent=panelBuilder.parent;
        this.insects=panelBuilder.insects;
        this.font=panelBuilder.font;
        this.fontSize=panelBuilder.fontSize;
        this.stage=panelBuilder.stage;
        this.name=panelBuilder.name;

    }

    public AnchorPane getPanel() {
        return panel;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static class  PanelBuilder {

        protected Coordinate panelCoordinate;
        protected AnchorPane parent;
        protected Double width;
        protected Double height;
        protected Insets insects;
        protected FontsStore font;
        protected double fontSize;
        protected Stage stage;
        protected String name;


        public static PanelBuilder create(){return new PanelBuilder();}

        public PanelBuilder setStage(Stage stage) {
            this.stage = stage;
            return this;
        }

        public PanelBuilder setFont(FontsStore font, double size) {
            this.font = font;
            this.fontSize=size;
            return this;
        }

        public PanelBuilder setPanelCoordinate(Coordinate panelCoordinate) {
            this.panelCoordinate = panelCoordinate;
            return this;
        }

        public Panel.PanelBuilder setParent(AnchorPane parent) {
            this.parent = parent;
            return this;
        }

        public PanelBuilder setWidth(Double width) {
            this.width = width;
            return this;
        }

        public PanelBuilder setHeight(Double height) {
            this.height = height;
            return this;
        }

        public PanelBuilder setInsets(Insets i) {
            this.insects=i;
            return this;
        }
        public void setName(String name) {
            this.name = name;
        }

        public Panel build(){

            return new Panel(this);

        }






    }


}
