package basisFx.appCore.menu;

import basisFx.presentation.targets.DynamicElements;

public abstract class MenuComponent {

    protected DynamicElements dynamicElements;
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

    public DynamicElements getDynamicElements() {
        return dynamicElements;
    }

    public abstract boolean  isComposit();



}
