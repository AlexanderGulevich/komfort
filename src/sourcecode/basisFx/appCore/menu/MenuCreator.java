package basisFx.appCore.menu;


/**
 *
 * @author Alek
 */
public final class MenuCreator {
    private MenuSketch nodes;
    private MenuRepresent represent;

    
    public MenuCreator init() {
        represent.setMenuComponent(nodes.getMenuComponents());
        represent.make();
        return this;
    } 

    public MenuRepresent getRepresent() {
        return represent;
    }
    public MenuCreator setMenuSketch(MenuSketch nodes) {
        this.nodes = nodes;
        this.nodes.initSpiritNodes();
        return this;
    }

    public MenuCreator setRepresent(MenuRepresent represent) {
        this.represent = represent;
        return this;
    }

    
    
    
    
      
   
    
}
