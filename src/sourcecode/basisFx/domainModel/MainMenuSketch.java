package basisFx.domainModel;

import basisFx.appCore.menu.MenuSketch;
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
       
       menuHierarchy.addInerLevel(

/////////////////////////////////////////////////

               createVertical("Результаты дня", null, composit.COMPOSITE,"\uF0A1", FontsStore.WEBHOSTINGHUB,25)
                       .addInerLevel(
                               create("Дневная выработка", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),


/////////////////////////////////////////////////

               createVertical("Статистика", null, composit.COMPOSITE,"\uF080", FontsStore.FAWESOME5SOLID,25)
                        .addInerLevel(
                               create("Затраты", null, composit.SIMPLE),
                               create("Курсы", null, composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),

/////////////////////////////////////////////////

               createVertical("Управление сотрудниками", null, composit.COMPOSITE,"\uF007", FontsStore.FAWESOME5REGULAR,25)
                       .addInerLevel(
                               create("Список сотрудников", fabric.createEmployeesPanel(), composit.SIMPLE),
                               create("Тарифные ставки", fabric.createRatePerHourPanel(), composit.SIMPLE),
                               create("Архив сотрудников", fabric.createEmployeesPanel(), composit.SIMPLE)

               ),

/////////////////////////////////////////////////

               createVertical("Вспомогательная информация", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                       .addInerLevel(
                               create("Оборудование", fabric.createEquipmentPanel(), composit.SIMPLE),
                               create("Контрагенты", fabric.createCounterpartyPanel(), composit.SIMPLE),
                               create("Страны", fabric.createCountryPanel(), composit.SIMPLE),
                               create("Валюты", fabric.createCurrencyPanel(), composit.SIMPLE)
                       )



/////////////////////////////////////////////////


       );
    }

}
