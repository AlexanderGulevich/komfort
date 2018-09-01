package basisFx.domain;

import basisFx.appCore.menu.*;
import basisFx.appCore.settings.FontsStore;

public class MainMenuSketch extends MenuSketch {

    private TargetFM fm = new TargetFM();
    private double iconSize = 25d;



    public MainMenuSketch() {

        components = new MenuComposite () .add(

                FontItemComposite.newBuilder()
                        .setDescription("Результаты дня")
                        .setFontsStore(FontsStore.WEBHOSTINGHUB)
                        .setFontSymbol("\uF0A1")
                        .setFontSize(iconSize)
                        .build().add(
                            FontItemLeaf.newBuilder()
                                    .setDescription("Сотрудники (учет времени)")
//                                    .setTarget(fm.timeRecordingPanel())
                                    .setActive(true)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Продукция")
//                                    .setTarget(fm.countingRodsPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет сырья")
//                                    .setTarget(fm.rawMateriaAccountingPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Курсы")
//                                    .setTarget(fm.exchangeRatesPanel())
                                    .build()
                ),

                FontItemComposite.newBuilder().setDescription("Проводки")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE52D")
                        .setFontSize(iconSize)
                        .build().add(
                              FontItemLeaf.newBuilder()
                                      .setDescription("Дневная выработка")
//                                      .setTarget(fm.dailyOutputPanel())
                                      .build()
                ),


                FontItemComposite.newBuilder().setDescription("Статистика")
                        .setFontsStore(FontsStore.FAWESOME5SOLID)
                        .setFontSymbol("\uF080")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Затраты")
//                                        .setTarget(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Курсы")
//                                        .setTarget(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Выход")
//                                        .setTarget(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Рентабельность")
//                                        .setTarget(fm.dailyOutputPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Управление сотрудниками")
                        .setFontsStore(FontsStore.FAWESOME5REGULAR)
                        .setFontSymbol("\uF007")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Сотрудики")
//                                        .setTarget(fm.employeesManagerPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Актуальные тарифы")
//                                        .setTarget(fm.employeesActualRate())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Шаблоны тарифов")
//                                        .setTarget(fm.ratePerHourPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бывшие сотрудники")
//                                        .setTarget(fm.employeesFiredPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Динамика цен")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE263")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Продукция")
//                                        .setTarget(fm.productPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Пакеты")
//                                        .setTarget(fm.packetPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Этикетки")
//                                        .setTarget(fm.labelPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Втулки")
//                                        .setTarget(fm.sleevePanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бумага")
//                                        .setTarget(fm.paperPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Вспомогательная информация")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("")
                        .setFontSize(iconSize)
                        .build().add(
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Оборудование")
//                                            .setTarget(fm.equipmentPanel())
                                            .build(),
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Контрагенты")
//                                            .setTarget(fm.counterpartyPanel())
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
