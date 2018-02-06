package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.domainModel.settings.CSSID;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Alek
 */
public final class MenuCreator {
    private MenuSketch nodes;
    private CSSID css;
    private AnchorPane anchorPane;
    private AnchorCoordinate coordinate;
    private MenuRepresent represent;
    private Double width;
    private Double height;
    
    public MenuCreator init() {
        
        represent.setParentAnchor(anchorPane);
        represent.setCoordinate(coordinate);
        represent.setCss(css);
        represent.setMenuComponent(nodes.getMenuHierarchy());
        
        if(this.height!=null)represent.setHeight(height);
        if(this.width!=null)represent.setWidth(width);
        
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

    public MenuCreator setCss(CSSID css) {
        this.css = css;
        return this;
    }

    public MenuCreator setParentAnchor(AnchorPane anchorPane) {
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


    public MenuCreator setWidth(double w) {
        this.width = w;
        return this;
    }

    public MenuCreator setHeight(double h) {
        this.height = h;
        return this;
    }

    public static MenuCreator create(){
        return new MenuCreator();
    }
    
    
    
    
      
   
    
}
