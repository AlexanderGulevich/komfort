package basisFx.appCore.menu;

import basisFx.appCore.interfaces.DynamicContentPanelCreator;

public abstract class MenuComponent {

    protected DynamicContentPanelCreator dynamicContentPanelCreator;
    protected MenuComponent parent;
    protected boolean isActive;
    protected boolean hasParent;

    public boolean hasParent() {
        return hasParent;
    }

    public void setParent(MenuComponent parent) {
        hasParent=true;
        this.parent = parent;
    }

    public DynamicContentPanelCreator getDynamicElementsCreator() {
        return dynamicContentPanelCreator;
    }

    public abstract boolean  isComposit();



}
