package basisFx.domainModel;

import  basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.menu.MenuComponent.composit;
import static basisFx.appCore.menu.MenuComponent.create;

/**
 *
 * @author Alek
 */
public class MainMenuSketch extends MenuSketch{
    
    private TargetFM fabric=new TargetFM();

    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuComponent.createHeadElement();
       
       menuHierarchy.addInerLevel(//     
               
               create("Списки", null, composit.COMPOSITE,"")
                       .addInerLevel(
                               create("Оборудование", fabric.createEquipmentPanel(), composit.SIMPLE),
                               create("Контрагенты", fabric.createCounterpartyPanel(), composit.SIMPLE),
                               create("Сотрудники", fabric.createEmployeesPanel(), composit.SIMPLE),
                               create("Тарифные ставки", fabric.createRatePerHourPanel(), composit.SIMPLE),
                               create("Страны", fabric.createCountryPanel(), composit.SIMPLE),
                               create("Валюты", fabric.createCurrencyPanel(), composit.SIMPLE)
                       ),


               create("Графики", null, composit.COMPOSITE,"")
                        .addInerLevel(
                               create("Затраты", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),
               
               
               create("Движения", null, composit.COMPOSITE,"") .addInerLevel(
                               create("Дневная выработка", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),
               create("Архив", null, composit.COMPOSITE,"" )

//               create("Контрагенты", null, composit.COMPOSITE,"") .addInerLevel(
//                               create("Поставщики", fabric.createEquipmentPanel(), composit.SIMPLE),
//                               create("Потребители", null, composit.SIMPLE)
//                       )
//               create("Профит", null, composit.COMPOSITE,"")
                                        );
    }
    
}
