package basisFx.domainModel;

import  basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuComponents;
import basisFx.appCore.menu.MenuComponents.composit;
import static basisFx.appCore.menu.MenuComponents.create;

/**
 *
 * @author Alek
 */
public class MainMenuSketch extends MenuSketch{

    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuComponents.createHeadElement();
       
       menuHierarchy.add(
//              
               create("1", null, composit.COMPOSITE,""),
               create("2", null, composit.COMPOSITE,""),
               create("3", null, composit.COMPOSITE,""),
               create("4", null, composit.COMPOSITE,""),
               create("5", null, composit.COMPOSITE,""),
               create("6", null, composit.COMPOSITE,""),
               create("7", null, composit.COMPOSITE,"")
                                        );
    }
    
}
