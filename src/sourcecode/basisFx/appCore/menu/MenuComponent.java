package basisFx.appCore.menu;

import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import lombok.Getter;
import lombok.Setter;

public abstract class MenuComponent {

    @Getter protected DynamicContentPanelCreator dynamicContentPanelCreator;
    @Getter protected MenuComponent parent;
    @Getter protected boolean isActive;
    protected boolean hasParent;
    @Getter @Setter protected String fxmlFileName;

    public boolean hasParent() {
        return hasParent;
    }

    public void setParent(MenuComponent parent) {
        hasParent=true;
        this.parent = parent;
    }

    public abstract boolean  isComposit();
}
