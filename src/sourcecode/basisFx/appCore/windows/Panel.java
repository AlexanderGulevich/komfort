package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.fabrics.EventFactory;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
    protected CSSID cssid;
    protected AppEvent event;




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
        this.cssid=panelBuilder.cssid;
        this.event=panelBuilder.event;

    }


    public String getName() {
        return name;
    }

    public Panel createInsideTextLayer(FontsStore fs, double size){
       AppNode.NodeBuilder.create()
                .setId(CSSID.LEFT_SIDE_MENU_COMMON_TEXT)
                .setParent(panel)
                .setCoordinate(0d, 0d, 0d, 0d)
                .setFont(fs, size)
                .createText().getElement();
        return this;
    }

    public AnchorPane getPanel() {
        return panel;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static class  PanelBuilder {

        private Coordinate panelCoordinate;
        private AnchorPane parent;
        private Double width;
        private Double height;
        private Insets insects;
        private FontsStore font;
        private double fontSize;
        private Stage stage;
        private String name;
        private CSSID cssid;
        private AppEvent event;


        public static PanelBuilder create(){return new PanelBuilder();}

        public PanelBuilder setStage(Stage stage) {
            this.stage = stage;
            return this;
        }

        public PanelBuilder setCssid(CSSID cssid) {
            this.cssid = cssid;
            return this;
        }

        public PanelBuilder setFont(FontsStore font, double size) {
            this.font = font;
            this.fontSize=size;
            return this;
        }

        public PanelBuilder setCoordinate(Coordinate panelCoordinate) {
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
        public PanelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Panel build(){

            return new Panel(this);

        }


        public PanelBuilder setEvent(AppEvent event) {
            this.event = event;
            return this;
        }
    }


}
