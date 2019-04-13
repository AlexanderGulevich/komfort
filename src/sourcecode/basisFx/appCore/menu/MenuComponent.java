package basisFx.appCore.menu;


public interface MenuComponent {
      boolean isComposit();
      void setParent(MenuComponent component);
      boolean hasParent();
}
