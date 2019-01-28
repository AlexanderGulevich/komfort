package basisFx.appCore.menu;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuComposite extends MenuComponent {

    @Getter protected ArrayList<MenuComponent> childs =new ArrayList<>();

    public MenuComponent add(MenuComponent... component){
        List<MenuComponent> menuComponents = Arrays.asList(component);
        for (MenuComponent c:menuComponents) {
            childs.add(c);
            c.setParent(this);
        }
            return this;
    }
    public void remove(MenuComponent component){
        childs.remove(component);
    }

    @Override
    public boolean isComposit() {
        return true;
    }

}
