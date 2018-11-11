package basisFx.presentation;

import basisFx.appCore.menu.*;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.targets.*;

public class MainMenuSketch extends MenuSketch {

    private double iconSize = 25d;

    public MainMenuSketch() {

        components = new MenuComposite () .add(

                FontItemComposite.newBuilder()
                        .setDescription("Управление затратами и выработкой за день")
                        .setFontsStore(FontsStore.WEBHOSTINGHUB)
                        .setFontSymbol("\uF0A1")
                        .setActive(true)
                        .setFontSize(iconSize)
                        .build().add(

                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет сырья")
//                                    .setTargetCreator(fm.rawMateriaAccountingPanel())
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
                                        .setDescription("Валюты")
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
                                .setDescription("Учет времени")
//                                    .setTargetCreator(fm.timeRecordingPanel())
                                .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Управление сотрудниками")
                                        .setTargetCreator(EmployeesPanel::new)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Архив")
//                                        .setTargetCreator(fm.employeesFiredPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("СЫРЬЕ")
                        .setFontsStore(FontsStore.IONICONS)
                        .setFontSymbol("\uF4F4")
                        .setFontSize(iconSize+4)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Пакеты")
                                        .setTargetCreator(PacketPanel::new)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Этикетки")
                                        .setTargetCreator(LabelPanel::new)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Втулки")
                                        .setTargetCreator(SleevePanel::new)
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Бумага")
                                        .setTargetCreator(PaperPanel::new)
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Вспомогательная информация")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFontSymbol("")
                        .setFontSize(iconSize)
                        .build().add(
                            FontItemLeaf.newBuilder()
                                    .setDescription("Продукция")
                                    .setTargetCreator(ProductPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Оборудование")
                                    .setTargetCreator(EquipmentPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Контрагенты")
                                    .setTargetCreator(CounterpartyPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Валюты")
                                    .setTargetCreator(ExchangeRatesPanel::new)
                                    .build()
                )
//                ,
//
//                FontItemComposite.newBuilder().setDescription("Настройки")
//                        .setFontsStore(FontsStore.FOUNDATION)
//                        .setFontSymbol("\uF214")
//                        .setFontSize(iconSize)
//                        .build().add()

        );


    }


    public MenuComponent getComponents() {
        return components;
    }
}
