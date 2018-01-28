package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Alek
 */
public class MenuCreator {
    private MenuSketch nodes;
    private CSSID css;
    private AnchorPane anchorPane;
    private AnchorCoordinate coordinate;
    private MenuRepresent represent;
    
    public void init() {
        
        represent.setParentAnchor(anchorPane);
        represent.setCoordinate(coordinate);
        represent.setCss(css);
        represent.setMenuComponent(nodes.getMenuHierarchy());
        
        represent.make();
        
       
        
    } 

    public MenuCreator setNodes(MenuSketch nodes) {
        this.nodes = nodes;
        this.nodes.initSpiritNodes();
        return this;
    }

    public MenuCreator setCss(CSSID css) {
        this.css = css;
        return this;
    }

    public MenuCreator setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        return this;
    }

    public MenuCreator setCoordinate(AnchorCoordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public MenuCreator setRepresent(MenuRepresent represent) {
        this.represent = represent;
        return this;
    }

    public static MenuCreator create(){
        return new MenuCreator();
    }
    
    
      
   
    
}
