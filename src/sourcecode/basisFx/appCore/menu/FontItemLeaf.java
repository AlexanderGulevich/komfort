package basisFx.appCore.menu;

import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.DynamicElements;

public class FontItemLeaf extends MenuLeaf{
    protected String sumbols;
    protected FontsStore fontsStore;
    protected double fontSize;
    protected String description;

    private FontItemLeaf(Builder builder) {
        dynamicElements = builder.dynamicElements;
        sumbols = builder.symbols;
        fontsStore = builder.fontsStore;
        fontSize = builder.fontSize;
        description=builder.description;
        isActive=builder.isActive;
    }

    public String getSumbols() {
        return sumbols;
    }

    public FontsStore getFontsStore() {
        return fontsStore;
    }

    public double getFontSize() {
        return fontSize;
    }

    public String getDescription() {
        return description;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private boolean isActive;
        private String description;
        private DynamicElements dynamicElements;
        private String symbols;
        private FontsStore fontsStore;
        private double fontSize;

        private Builder() {
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }

        public Builder setDynamicElements(DynamicElements val) {
            dynamicElements = val;
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
