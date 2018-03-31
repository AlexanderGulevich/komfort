package basisFx.domainModel;

import  basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.menu.MenuComponent.composit;
import basisFx.domainModel.settings.FontsStore;

import static basisFx.appCore.menu.MenuComponent.create;
import static basisFx.appCore.menu.MenuComponent.createVertical;

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
               createVertical("Списки", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                       .addInerLevel(
                               create("Оборудование", fabric.createEquipmentPanel(), composit.SIMPLE),
                               create("Контрагенты", fabric.createCounterpartyPanel(), composit.SIMPLE),
                               create("Сотрудники", fabric.createEmployeesPanel(), composit.SIMPLE),
                               create("Тарифные ставки", fabric.createRatePerHourPanel(), composit.SIMPLE),
                               create("Страны", fabric.createCountryPanel(), composit.SIMPLE),
                               create("Валюты", fabric.createCurrencyPanel(), composit.SIMPLE)
                       ),


               createVertical("Графики", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                        .addInerLevel(
                               create("Затраты", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),


               createVertical("Движения", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                       .addInerLevel(
                               create("Дневная выработка", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),
               createVertical("Архив", null, composit.COMPOSITE,"" , FontsStore.MATERIAL_ICONS,25),

               createVertical("Контрагенты", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                       .addInerLevel(
                               create("Поставщики", fabric.createEquipmentPanel(), composit.SIMPLE),
                               create("Потребители", null, composit.SIMPLE)
                       ),


               createVertical("F", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25),
               createVertical("W", null, composit.COMPOSITE,"\uF007", FontsStore.MATERIAL_ICONS,25),
               createVertical("er", null, composit.COMPOSITE,"\uF007", FontsStore.MATERIAL_ICONS,25),
               createVertical("qd", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                                        );
    }
    
}
