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
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,""),
               create("Списки", null, composit.COMPOSITE,"")
                                        );
    }
    
}
