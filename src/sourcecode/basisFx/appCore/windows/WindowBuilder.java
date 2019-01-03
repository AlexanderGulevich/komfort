package basisFx.appCore.windows;

import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.presentation.appStructura.GUIStructura;

public class WindowBuilder {
    public GUIStructura GUIStructura;
    public DynamicContentPanelCreator dynamicContentPanelCreator;
    public Double width;
    public Double height;
    public String fxmlFileName;
    public String title;
    public String parentAnchorNameForFXML;
    public ButtonsForStage buttonsForStage;

    private WindowBuilder(Builder builder) {
        GUIStructura = builder.GUIStructura;
        dynamicContentPanelCreator = builder.dynamicContentPanelCreator;
        width = builder.width;
        height = builder.height;
        fxmlFileName = builder.fxmlFileName;
        title = builder.title;
        parentAnchorNameForFXML = builder.parentAnchorname;
        buttonsForStage = builder.buttonsForStage;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private GUIStructura GUIStructura;
        private DynamicContentPanelCreator dynamicContentPanelCreator;
        private double width;
        private double height;
        private String fxmlFileName;
        private String title;
        private String parentAnchorname;
        private ButtonsForStage buttonsForStage;

        private Builder() {
        }

        public Builder setGUIStructura(GUIStructura val) {
            GUIStructura = val;
            return this;
        }

        public Builder setTargetCreater(DynamicContentPanelCreator dynamicContentPanelCreator) {
            this.dynamicContentPanelCreator = dynamicContentPanelCreator;
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

        public Builder setFxmlFileName(String val) {
            fxmlFileName = val;
            return this;
        }

        public Builder setTitle(String val) {
            title = val;
            return this;
        }

        public Builder setParentAnchorNameForFXML(String val) {
            parentAnchorname = val;
            return this;
        }

        public Builder setButtonsForStage(ButtonsForStage val) {
            buttonsForStage = val;
            return this;
        }

        public WindowBuilder build() {
            return new WindowBuilder(this);
        }
    }
}
