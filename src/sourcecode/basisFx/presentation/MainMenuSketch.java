package basisFx.presentation;

import basisFx.appCore.menu.*;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.targets.EquipmentPanel;

public class MainMenuSketch extends MenuSketch {

    private double iconSize = 25d;

    public MainMenuSketch() {

        components = new MenuComposite () .add(

                FontItemComposite.newBuilder()
                        .setDescription("Результаты дня")
                        .setFontsStore(FontsStore.WEBHOSTINGHUB)
                        .setFontSymbol("\uF0A1")
                        .setActive(true)
                        .setFontSize(iconSize)
                        .build().add(
                            FontItemLeaf.newBuilder()
                                    .setDescription("Сотрудники (учет времени)")
//                                    .setDynamicElements(fm.timeRecordingPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Продукция")
//                                    .setDynamicElements(fm.countingRodsPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет сырья")
//                                    .setDynamicElements(fm.rawMateriaAccountingPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Курсы")
//                                    .setDynamicElements(fm.exchangeRatesPanel())
                                    .build()
                ),

                FontItemComposite.newBuilder().setDescription("Проводки")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE52D")
                        .setFontSize(iconSize)
                        .build().add(
                              FontItemLeaf.newBuilder()
                                      .setDescription("Дневная выработка")
//                                      .setDynamicElements(fm.dailyOutputPanel())
                                      .build()
                ),


                FontItemComposite.newBuilder().setDescription("Статистика")
                        .setFontsStore(FontsStore.FAWESOME5SOLID)
                        .setFontSymbol("\uF080")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Затраты")
//                                        .setDynamicElements(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Курсы")
//                                        .setDynamicElements(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Выход")
//                                        .setDynamicElements(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Рентабельность")
//                                        .setDynamicElements(fm.dailyOutputPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Управление сотрудниками")
                        .setFontsStore(FontsStore.FAWESOME5REGULAR)
                        .setFontSymbol("\uF007")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Сотрудики")
//                                        .setDynamicElements(Employ)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Актуальные тарифы")
//                                        .setDynamicElements(fm.employeesActualRate())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Шаблоны тарифов")
//                                        .setDynamicElements(fm.ratePerHourPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бывшие сотрудники")
//                                        .setDynamicElements(fm.employeesFiredPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Динамика цен")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE263")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Продукция")
//                                        .setDynamicElements(fm.productPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Пакеты")
//                                        .setDynamicElements(fm.packetPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Этикетки")
//                                        .setDynamicElements(fm.labelPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Втулки")
//                                        .setDynamicElements(fm.sleevePanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бумага")
//                                        .setDynamicElements(fm.paperPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Вспомогательная информация")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("")
                        .setFontSize(iconSize)
                        .build().add(
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Оборудование")
                                            .setDynamicElements(new EquipmentPanel())
                                            .build(),
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Контрагенты")
//                                            .setDynamicElements(fm.counterpartyPanel())
                                            .build()
                ),

                FontItemComposite.newBuilder().setDescription("Настройки")
                        .setFontsStore(FontsStore.FOUNDATION)
                        .setFontSymbol("\uF214")
                        .setFontSize(iconSize)
                        .build().add()

        );


    }


    public MenuComponent getComponents() {
        return components;
    }
}
