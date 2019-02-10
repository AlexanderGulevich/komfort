package basisFx.presentation;

import basisFx.appCore.menu.*;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.dynamicContents.*;

public class MainMenuSketch extends MenuSketch {

    private double iconSize = 25d;

    public MainMenuSketch() {

        components = new MenuComposite () .add(

                FontItemComposite.newBuilder()
                        .setDescription("ПАНЕЛЬ УПРАВЛЕНИЯ \n")
                        .setFontsStore(FontsStore.FAWESOME5SOLID)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("\uF015")
                        .setActive(true)
                        .setFontSize(iconSize)
                        .build(),

                FontItemComposite.newBuilder()
                        .setDescription("Управление затратами и выработкой за день \n")
                        .setFontsStore(FontsStore.WEBHOSTINGHUB)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("\uF0A1")
                        .setActive(false)
                        .setFontSize(iconSize)
                        .build().add(
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет времени")
                                    .setDynamicContentPanelCreator(TimeRecordingPanel ::new )
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет выходной продукции")
                                    .setDynamicContentPanelCreator(OutputPanel ::new )
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Учет джамбо-ролей")
                                    .setDynamicContentPanelCreator(JumboAccountingPanel::new)
                                    .build()
                ),

//                FontItemComposite.newBuilder().setDescription("Проводки")
//                        .setFontsStore(FontsStore.MATERIAL_ICONS)
//                        .setFontSymbol("\uE52D")
//                        .setFontSize(iconSize)
//                        .build().add(
//                              FontItemLeaf.newBuilder()
//                                      .setDescription("Дневная выработка")
////                                      .setDynamicContentPanelCreator(fm.dailyOutputPanel())
//                                      .build()
//                ),
//

                FontItemComposite.newBuilder().setDescription("Статистическая информация")
                        .setFontsStore(FontsStore.FAWESOME5SOLID)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("\uF080")
                        .setFontSize(iconSize)
                        .build().add(
                                FontItemLeaf.newBuilder()
                                        .setDescription("Затраты")
//                                        .setDynamicContentPanelCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Валюты")
//                                        .setDynamicContentPanelCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Выход")
//                                        .setDynamicContentPanelCreator(fm.dailyOutputPanel())
                                        .build(),
                                FontItemLeaf.newBuilder()
                                        .setDescription("Рентабельность")
//                                        .setDynamicContentPanelCreator(fm.dailyOutputPanel())
                                        .build()
                ),

                FontItemComposite.newBuilder().setDescription("Управление сотрудниками")
                        .setFontsStore(FontsStore.FAWESOME5REGULAR)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("\uF007")
                        .setFontSize(iconSize)
                        .build().add(

                        FontItemLeaf.newBuilder()
                                .setDescription("Сотрудники")
                                .setDynamicContentPanelCreator(EmployeesPanel::new)
                                .build(),
                        FontItemLeaf.newBuilder()
                                .setDescription("Уволенные")
//                                        .setDynamicContentPanelCreator(fm.employeesFiredPanel())
                                .build()
                ),

                FontItemComposite.newBuilder().setDescription("Управление сырьем")
                        .setFontsStore(FontsStore.IONICONS)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("\uF4F4")
                        .setFontSize(iconSize+2)
                        .build().add(
                        FontItemLeaf.newBuilder()
                                .setDescription("Пакеты")
                                .setDynamicContentPanelCreator(PacketPanel::new)
                                .build(),
                        FontItemLeaf.newBuilder()
                                .setDescription("Этикетки")
                                .setDynamicContentPanelCreator(LabelPanel::new)
                                .build(),
                        FontItemLeaf.newBuilder()
                                .setDescription("Втулки")
                                .setDynamicContentPanelCreator(SleevePanel::new)
                                .build(),
                        FontItemLeaf.newBuilder()
                                .setDescription("Бумага")
                                .setDynamicContentPanelCreator(PaperPanel::new)
                                .build(),
                        FontItemLeaf.newBuilder()
                                .setDescription("Джамбо")
                                .setDynamicContentPanelCreator(JumboPanel::new)
                                .build()
                ),

                FontItemComposite.newBuilder().setDescription("Прочая информация")
                        .setFontsStore(FontsStore.MATERIAL_ICONS)
                        .setFxmlFileName("vbut.fxml")
                        .setFontSymbol("")
                        .setFontSize(iconSize)
                        .build().add(
                            FontItemLeaf.newBuilder()
                                    .setDescription("Продукция")
                                    .setDynamicContentPanelCreator(ProductPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Станки")
                                    .setDynamicContentPanelCreator(EquipmentPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Контрагенты")
                                    .setDynamicContentPanelCreator(CounterpartyPanel::new)
                                    .build(),
                            FontItemLeaf.newBuilder()
                                    .setDescription("Валюты")
                                    .setDynamicContentPanelCreator(ExchangeRatesPanel::new)
                                    .build()



                )
//                ,
//
//                FontItemComposite.newBuilder().setDescription("Настройки")
//                        .setFontsStore(FontsStore.fontcustom)
//                        .setFontSymbol("\uF214")
//                        .setFontSize(iconSize)
//                        .build().add()

        );


    }


    public MenuComponent getComponents() {
        return components;
    }
}
