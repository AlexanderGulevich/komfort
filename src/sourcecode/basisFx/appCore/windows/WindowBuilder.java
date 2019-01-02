package basisFx.appCore.windows;

import basisFx.appCore.utils.StandartAnchorsNames;
import basisFx.presentation.TargetPanel;
import basisFx.presentation.appStructura.GuiStructura;

public class WindowBuilder {
    public GuiStructura guiStructura;
    public TargetPanel target;
    public double width;
    public double height;
    public String fxmlFileName;
    public String title;
    public String parentAnchor;
    public StandartAnchorsNames parentAnchorname;
    public ButtonsForStage buttonsForStage;

    private WindowBuilder(Builder builder) {
        guiStructura = builder.guiStructura;
        target = builder.target;
        width = builder.width;
        height = builder.height;
        fxmlFileName = builder.fxmlFileName;
        title = builder.title;
        parentAnchor = builder.parentAnchor;
        parentAnchorname = builder.parentAnchorname;
        buttonsForStage = builder.buttonsForStage;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private GuiStructura guiStructura;
        private TargetPanel target;
        private double width;
        private double height;
        private String fxmlFileName;
        private String title;
        private String parentAnchor;
        private StandartAnchorsNames parentAnchorname;
        private ButtonsForStage buttonsForStage;

        private Builder() {
        }

        public Builder setGuiStructura(GuiStructura val) {
            guiStructura = val;
            return this;
        }

        public Builder setTarget(TargetPanel val) {
            target = val;
            return this;
        }

        public Builder setWidth(double val) {
            width = val;
            return this;
        }

        public Builder setHeight(double val) {
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

        public Builder setParentAnchor(String val) {
            parentAnchor = val;
            return this;
        }

        public Builder setParentAnchorname(StandartAnchorsNames val) {
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
