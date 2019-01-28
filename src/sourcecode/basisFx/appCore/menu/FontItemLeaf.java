package basisFx.appCore.menu;

import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.DynamicContentPanel;
import lombok.Getter;

public class FontItemLeaf extends MenuLeaf{
    @Getter protected String sumbols;
    @Getter protected FontsStore fontsStore;
    @Getter protected double fontSize;
    @Getter protected String description;

    private FontItemLeaf(Builder builder) {
        dynamicContentPanelCreator = builder.dynamicContentPanelCreator;
        sumbols = builder.symbols;
        fontsStore = builder.fontsStore;
        fontSize = builder.fontSize;
        description=builder.description;
        isActive=builder.isActive;
    }


    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        public DynamicContentPanelCreator dynamicContentPanelCreator;
        private boolean isActive;
        private String description;
        private DynamicContentPanel dynamicContentPanel;
        private String symbols;
        private FontsStore fontsStore;
        private double fontSize;

        private Builder() {
        }

        public Builder setActive(boolean active) {
            isActive = active;
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
        public Builder setSymbols(String val) {
            symbols = val;
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

        public FontItemLeaf build() {
            return new FontItemLeaf(this);
        }
    }
}
