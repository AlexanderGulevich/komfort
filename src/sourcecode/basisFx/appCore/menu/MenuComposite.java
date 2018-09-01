package basisFx.appCore.menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuComposite extends MenuComponent {

    protected ArrayList<MenuComponent> childs =new ArrayList<>();

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

    public ArrayList<MenuComponent> getChilds() {
        return childs;
    }

    @Override
    public boolean isComposit() {
        return true;
    }

}
