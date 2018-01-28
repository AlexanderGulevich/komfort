/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import  basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuSketchUtils;
import basisFx.appCore.menu.MenuSketchUtils.composit;
import static basisFx.appCore.menu.MenuSketchUtils.create;

/**
 *
 * @author Alek
 */
public class MainMenu extends MenuSketch{

    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuSketchUtils.createHeadElement();
       
       menuHierarchy.add(
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE),
               create("ВЭД", null, composit.COMPOSITE)
                                        );
    }
    
}
