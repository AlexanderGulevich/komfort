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
//                                    .setTargetCreator(fm.timeRecordingPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Продукция")
//                                    .setTargetCreator(fm.countingRodsPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет сырья")
//                                    .setTargetCreator(fm.rawMateriaAccountingPanel())
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Курсы")
//                                    .setTargetCreator(fm.exchangeRatesPanel())
                                    .build()
                ),

                FontItemComposite.newBuilder().setDescription("Проводки")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE52D")
                        .setFontSize(iconSize)
                        .build().add(
                              FontItemLeaf.newBuilder()
                                      .setDescription("Дневная выработка")
//                                      .setTargetCreator(fm.dailyOutputPanel())
                                      .build()
                ),


                FontItemComposite.newBuilder().setDescription("Статистика")
                        .setFontsStore(FontsStore.FAWESOME5SOLID)
                        .setFontSymbol("\uF080")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Затраты")
//                                        .setTargetCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Курсы")
//                                        .setTargetCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Выход")
//                                        .setTargetCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Рентабельность")
//                                        .setTargetCreator(fm.dailyOutputPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Управление сотрудниками")
                        .setFontsStore(FontsStore.FAWESOME5REGULAR)
                        .setFontSymbol("\uF007")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Сотрудики")
//                                        .setTargetCreator(Employ)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Актуальные тарифы")
//                                        .setTargetCreator(fm.employeesActualRate())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Шаблоны тарифов")
//                                        .setTargetCreator(fm.ratePerHourPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бывшие сотрудники")
//                                        .setTargetCreator(fm.employeesFiredPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Динамика цен")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("\uE263")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Продукция")
//                                        .setTargetCreator(fm.productPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Пакеты")
//                                        .setTargetCreator(fm.packetPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Этикетки")
//                                        .setTargetCreator(fm.labelPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Втулки")
//                                        .setTargetCreator(fm.sleevePanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бумага")
//                                        .setTargetCreator(fm.paperPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Вспомогательная информация")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("")
                        .setFontSize(iconSize)
                        .build().add(
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Оборудование")
                                            .setTargetCreator(EquipmentPanel::new)
                                            .build(),
                                    FontItemLeaf.newBuilder()
                                            .setDescription("Контрагенты")
//                                            .setTargetCreator(fm.counterpartyPanel())
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
