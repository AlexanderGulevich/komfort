package basisFx.appCustomLogic;

import basisFx.appCore.AnchorCoordinate;
import static basisFx.appCore.menu.MenuSketch.create;
import static basisFx.appCore.menu.MenuSketch.composit;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.registry.LayersRegistry;
import basisFx.appCustomLogic.settings.CSSID;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Alek
 */
public class MainMenu {
    
    private MenuSketch menuHierarchy;
    private CSSID css;
    private AnchorPane ap;
    private AnchorCoordinate c;
    private MenuRepresent r;
    
    private void init() {
        
        initMenuSpirit();
        initSpiritNodes();
        initRealMenu();
        
    } 

    public MainMenu(CSSID css, AnchorPane ap, AnchorCoordinate c,MenuRepresent r) {
       this.ap=ap;
       this.c=c;
       this.css=css;
       this.r=r;
       init();

    }


    private void initMenuSpirit() {
         this.menuHierarchy = MenuSketch.createHeadElement();
        
    
    }
    private void initSpiritNodes() {
        
        
       menuHierarchy.add(
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE)
                                        );
        

    }
    private void initRealMenu(){
    
        r.setParentAnchor(ap);
        r.setCoordinate(c);
        r.setCss(css);
        r.setMenuComponent(menuHierarchy);
        
        r.make();
        
    }
    
     
      
   
    
}
