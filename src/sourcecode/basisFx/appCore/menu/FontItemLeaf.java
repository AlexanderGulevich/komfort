package basisFx.appCore.menu;

import basisFx.appCore.settings.FontsStore;
import basisFx.domain.targets.Target;

public class FontItemLeaf extends MenuLeaf{
    protected String sumbols;
    protected FontsStore fontsStore;
    protected double fontSize;
    protected String description;

    private FontItemLeaf(Builder builder) {
        target = builder.target;
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
        private boolean isActive;
        private String description;
        private Target target;
        private String symbols;
        private FontsStore fontsStore;
        private double fontSize;

        private Builder() {
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }

        public Builder setTarget(Target val) {
            target = val;
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
