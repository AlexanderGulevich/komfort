package basisFx.appCore.menu;

import basisFx.domain.targets.Target;

public abstract class MenuComponent {

    protected Target target;
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

    public abstract boolean  isComposit();



}
