package basisFx.appCore.menu;

import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.settings.FontsStore;
import lombok.Getter;

public class FontItemComposite extends MenuComposite{
    @Getter protected String fontSymbol;
    @Getter protected String description;
    @Getter protected FontsStore fontsStore;
    @Getter protected double fontSize;

    private FontItemComposite(Builder builder) {
        dynamicContentPanelCreator = builder.dynamicContentPanelCreator;
        fontSymbol = builder.fontSymbol;
        fontsStore = builder.fontsStore;
        fontSize = builder.fontSize;
        description=builder.description;
        isActive=builder.isActive;
        fxmlFileName=builder.fxmlFileName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        public DynamicContentPanelCreator dynamicContentPanelCreator;
        private boolean isActive;
        private String description;
        private String fontSymbol;
        private FontsStore fontsStore;
        private double fontSize;
        private String fxmlFileName;

        private Builder() {
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }

        public Builder setFxmlFileName(String fxmlFileName) {
            this.fxmlFileName = fxmlFileName;
            return this;
        }

        public Builder setDynamicContentPanelCreator(DynamicContentPanelCreator val) {
            dynamicContentPanelCreator = val;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setFontSymbol(String val) {
            fontSymbol = val;
            return this;
        }

        public Builder setFontsStore(FontsStore val) {
            fontsStore = val;
            return this;
        }

        public Builder setFontSize(double val) {
            fontSize = val;
            return this;
        }

        public FontItemComposite build() {
            return new FontItemComposite(this);
        }


    }
}
