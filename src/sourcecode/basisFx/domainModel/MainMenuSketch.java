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
    private double iconSize =25d;


    @Override
    public void initSpiritNodes() {
        
       this.menuHierarchy=MenuComponent.createHeadElement();
       
       menuHierarchy.addInerLevel(

/////////////////////////////////////////////////

               createVertical("Результаты дня", null, composit.COMPOSITE,"\uF0A1", FontsStore.WEBHOSTINGHUB,iconSize)
                       .addInerLevel(
                               create("Сотрудники (учет времени)", fm.timeRecordingPanel(), composit.SIMPLE),
                               create("Продукция", fm.countingRodsPanel(), composit.SIMPLE),
                               create("Учет сырья", fm.rawMateriaAccountingPanel(), composit.SIMPLE),
                               create("Курсы", fm.exchangeRatesPanel(), composit.SIMPLE)
                       ),


/////////////////////////////////////////////////

               createVertical("Проводки", null, composit.COMPOSITE,"\uE52D", FontsStore.MATERIAL_ICONS,iconSize)
                       .addInerLevel(

                               create("Дневная выработка", fm.dailyOutputPanel(), composit.SIMPLE)
                       ),


/////////////////////////////////////////////////

               createVertical("Статистика", null, composit.COMPOSITE,"\uF080", FontsStore.FAWESOME5SOLID,iconSize)
                        .addInerLevel(
                               create("Затраты", null, composit.SIMPLE),
                               create("Курсы", fm.exchangeRatesChartPanel(), composit.SIMPLE),
                               create("Выход", null, composit.SIMPLE),
                               create("Рентабельность", null, composit.SIMPLE)
                       ),

/////////////////////////////////////////////////

               createVertical("Управление сотрудниками", null, composit.COMPOSITE,"\uF007", FontsStore.FAWESOME5REGULAR,iconSize)
                       .addInerLevel(
                               create("Сотрудики", fm.employeesManagerPanel(), composit.SIMPLE),
                               create("Актуальные тарифы", fm.employeesActualRate(), composit.SIMPLE),
                               create("Шаблоны тарифов", fm.ratePerHourPanel(), composit.SIMPLE),
                               create("Бывшие сотрудники", fm.employeesFiredPanel(), composit.SIMPLE)
               ),


/////////////////////////////////////////////////

               createVertical("Динамика цен", null, composit.COMPOSITE,"\uE263", FontsStore.MATERIAL_ICONS,iconSize)
                       .addInerLevel(
                               create("Продукция", fm.productPanel(), composit.SIMPLE),
                               create("Пакеты", fm.packetPanel(), composit.SIMPLE),
                               create("Этикетки", fm.labelPanel(), composit.SIMPLE),
                               create("Втулки", fm.sleevePanel(), composit.SIMPLE),
                               create("Бумага", fm.paperPanel(), composit.SIMPLE)

                       ),



/////////////////////////////////////////////////

               createVertical("Вспомогательная информация", null, composit.COMPOSITE,"", FontsStore.MATERIAL_ICONS,iconSize)
                       .addInerLevel(
                               create("Оборудование", fm.equipmentPanel(), composit.SIMPLE),
                               create("Контрагенты", fm.counterpartyPanel(), composit.SIMPLE)
                       ),



/////////////////////////////////////////////////

               createVertical("Настройки", null, composit.COMPOSITE,"\uF214", FontsStore.FOUNDATION ,iconSize)
                       .addInerLevel(

                       )

       );
    }

}
