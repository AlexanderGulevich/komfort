package basisFx.domainModel;

import basisFx.appCore.menu.MenuSketch;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.menu.MenuComponent.composit;
import basisFx.appCore.settings.FontsStore;

import static basisFx.appCore.menu.MenuComponent.create;
import static basisFx.appCore.menu.MenuComponent.createVertical;

/**
 *
 * @author Alek
 */
public class MainMenuSketch extends MenuSketch{
    
    private TargetFM fm =new TargetFM();

    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuComponent.createHeadElement();
       
       menuHierarchy.addInerLevel(

/////////////////////////////////////////////////

               createVertical("Результаты дня", null, composit.COMPOSITE,"\uF0A1", FontsStore.WEBHOSTINGHUB,25)
                       .addInerLevel(
                               create("Сотрудники (учет времени)", fm.timeRecordingPanel(), composit.SIMPLE),
                               create("Продукция", fm.countingRodsPanel(), composit.SIMPLE),
                               create("Учет сырья", fm.rawMateriaAccountingPanel(), composit.SIMPLE),
                               create("Курсы", fm.exchangeRatesPanel(), composit.SIMPLE)
                       ),


/////////////////////////////////////////////////

               createVertical("Проводки", null, composit.COMPOSITE,"\uF058", FontsStore.FAWESOME5SOLID,25)
                       .addInerLevel(

                               create("Дневная выработка", fm.dailyOutputPanel(), composit.SIMPLE)
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
                               create("Сотрудики", fm.employeesManagerPanel(), composit.SIMPLE),
                               create("Актуальные тарифы", fm.employeesActualRate(), composit.SIMPLE),
                               create("Шаблоны тарифов", fm.ratePerHourPanel(), composit.SIMPLE),
                               create("Уволенные", fm.employeesActualRate(), composit.SIMPLE)

               ),

/////////////////////////////////////////////////

               createVertical("Вспомогательная информация", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,25)
                       .addInerLevel(
                               create("Станки", fm.equipmentPanel(), composit.SIMPLE),
                               create("Продукция", fm.productPanel(), composit.SIMPLE),
                               create("Пакеты", fm.packetPanel(), composit.SIMPLE),
                               create("Этикетка", fm.productPanel(), composit.SIMPLE),
                               create("Контрагенты", fm.counterpartyPanel(), composit.SIMPLE),
                               create("Сырье", fm.counterpartyPanel(), composit.SIMPLE)

                       )



/////////////////////////////////////////////////


       );
    }

}
