package basisFx.domainModel;

import basisFx.domainModel.targets.TargetFabric;
import  basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.menu.MenuComponent.composit;
import static basisFx.appCore.menu.MenuComponent.create;
import static basisFx.appCore.menu.MenuComponent.create;

/**
 *
 * @author Alek
 */
public class MainMenuSketch extends MenuSketch{
    
    private TargetFabric fabric=new TargetFabric();

    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuComponent.createHeadElement();
       
       menuHierarchy.addInerLevel(//              
               create("Списки", null, composit.COMPOSITE,"")
                       .addInerLevel(
                               create("Оборудование", fabric.createEquipmentPanel(), composit.SIMPLE),
                               create("Персонал", null, composit.SIMPLE),
                               create("Поставщики", null, composit.SIMPLE),
                               create("Потребители", null, composit.SIMPLE)
                       ),
               create("Затраты", null, composit.COMPOSITE,"")
               .addInerLevel(
                               create("dfwfwf", null, composit.SIMPLE),
                               create("hrth", null, composit.SIMPLE),
                               create("tyty", null, composit.SIMPLE),
                               create("44tytnje4", null, composit.SIMPLE)
                       ),
               create("Отчеты", null, composit.COMPOSITE,""),
               create("Ресурсы", null, composit.COMPOSITE,""),
               create("Задачи", null, composit.COMPOSITE,""),
               create("Объекты", null, composit.COMPOSITE,""),
               create("Профит", null, composit.COMPOSITE,"")
                                        );
    }
    
}
