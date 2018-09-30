package basisFx.appCore.menu;

import basisFx.appCore.interfaces.TargetCreator;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.TargetPanel;

public class FontItemComposite extends MenuComposite{
    protected String fontSymbol;
    protected String description;
    protected FontsStore fontsStore;
    protected double fontSize;

    private FontItemComposite(Builder builder) {
        targetCreator = builder.targetCreator;
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
        public TargetCreator targetCreator;
        private boolean isActive;
        private String description;
        private String fontSymbol;
        private FontsStore fontsStore;
        private double fontSize;




        private Builder() {
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }


        public Builder setTargetCreator(TargetCreator val) {
            targetCreator = val;
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
