package basisFx.appCore.menu;

import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.targets.DynamicElements;

public class FontItemComposite extends MenuComposite{
    protected String fontSymbol;
    protected String description;
    protected FontsStore fontsStore;
    protected double fontSize;

    private FontItemComposite(Builder builder) {
        dynamicElements = builder.dynamicElements;
        fontSymbol = builder.fontSymbol;
        fontsStore = builder.fontsStore;
        fontSize = builder.fontSize;
        description=builder.description;
        isActive=builder.isActive;
    }

    public String getFontSymbol() {
        return fontSymbol;
    }

    public String getDescription() {
        return description;
    }

    public FontsStore getFontsStore() {
        return fontsStore;
    }

    public double getFontSize() {
        return fontSize;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private boolean isActive;
        private String description;
        private DynamicElements dynamicElements;
        private String fontSymbol;
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
