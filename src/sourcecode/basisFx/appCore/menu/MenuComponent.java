package basisFx.appCore.menu;

import basisFx.appCore.interfaces.TargetCreator;

public abstract class MenuComponent {

    protected TargetCreator targetCreator;
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

    public TargetCreator getDynamicElementsCreator() {
        return targetCreator;
    }

    public abstract boolean  isComposit();



}
