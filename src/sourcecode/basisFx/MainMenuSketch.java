package basisFx;

import basisFx.appCore.menu.*;
import basisFx.appCore.settings.FontsStore;
import basisFx.presentation.*;

import static basisFx.appCore.settings.FontsStore.*;

public class MainMenuSketch implements MenuSketch {

    private LeftAndTopBarDirector menuDirector=new LeftAndTopBarDirector();

    private double iconSize = 25d;

    public MainMenuSketch() {

        menuDirector.setComposite(
                LeftAndTopBarItemComposite.builder()
                .description("ПАНЕЛЬ УПРАВЛЕНИЯ \n")
                .fontsStore(FontsStore.FAWESOME5SOLID)
                .fxmlFileName("vbut.fxml")
                .fontSymbol("\uF015")
                .panelCreator(null)
                .isActive(true)
                .fontSize(iconSize)
                .build()
        );

        menuDirector.setComposite(LeftAndTopBarItemComposite.builder()
                        .description("Управление затратами и выработкой за день \n")
                        .fontsStore(FontsStore.WEBHOSTINGHUB)
                        .fxmlFileName("vbut.fxml")
                        .fontSymbol("\uF0A1")
                        .isActive(false)
                        .fontSize(iconSize)
                        .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Учет времени").panelCreator(TimeRecordingPanel::new )
                .build())
        .setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Учет выходной продукции").panelCreator(OutputPanel::new )
                .build())
        .setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Учет джамбо-ролей").panelCreator(JumboAccountingPanel::new)
                .build());



//                LeftAndTopBarItemComposite.newBuilder().setDescription("Проводки")
//                        .setFontsStore(FontsStore.MATERIAL_ICONS)
//                        .setFontSymbol("\uE52D")
//                        .setFontSize(iconSize)
//                        .build().addButEvent(
//                              LeftAndTopBarItemLeaf.newBuilder()
//                                      .setDescription("Дневная выработка")
////                                      .setPanelCreator(fm.dailyOutputPanel())
//                                      .build()
//                ),
        menuDirector.setComposite(LeftAndTopBarItemComposite.builder()
                    .description("Статистическая информация")
                    .fontsStore(FAWESOME5SOLID)
                    .fxmlFileName("vbut.fxml")
                    .fontSymbol("\uF080")
                    .fontSize(iconSize)
                    .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Затраты").panelCreator(null)
                .build() )
        .setLeaf(LeftAndTopBarItemLeaf.builder().name("Валюты").panelCreator(null)
                .build() )
        .setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Выход").panelCreator(null)
                .build() )
        .setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Рентабельность").panelCreator(null)
                .build() );


        menuDirector.setComposite(LeftAndTopBarItemComposite.builder()
                        .description("Управление сотрудниками")
                        .fontsStore(FontsStore.FAWESOME5REGULAR)
                        .fxmlFileName("vbut.fxml")
                        .fontSymbol("\uF007")
                        .fontSize(iconSize)
                        .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                        .name("Сотрудники").panelCreator(EmployeesPanel::new)
                        .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                        .name("Уволенные").panelCreator(FiredEmployeesPanel::new)
                        .build() );




        menuDirector.setComposite(LeftAndTopBarItemComposite.builder()
                        .description("Прочая информация")
                        .fontsStore(FontsStore.MATERIAL_ICONS)
                        .fxmlFileName("vbut.fxml")
                        .fontSymbol("")
                        .fontSize(iconSize)
                        .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Продукция").panelCreator(ProductPanel::new)
                .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Станки").panelCreator(EquipmentPanel::new)
                .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                .name("Контрагенты").panelCreator(CounterpartyPanel::new)
                .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                .name("Валюты").panelCreator(ExchangeRatesPanel::new)
                .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                .name("Ширины ролей").panelCreator(JumboPanel::new)
                .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Пакеты").panelCreator(PacketPanel::new)
                .build()
        ).setLeaf( LeftAndTopBarItemLeaf.builder()
                .name("Этикетки").panelCreator(LabelPanel::new)
                .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Втулки").panelCreator(SleevePanel::new)
                .build()
        ).setLeaf(LeftAndTopBarItemLeaf.builder()
                .name("Бумага").panelCreator(PaperPanel::new)
                .build()
        );



//
//                LeftAndTopBarItemComposite.newBuilder().setDescription("Настройки")
//                        .setFontsStore(FontsStore.fontcustom)
//                        .setFontSymbol("\uF214")
//                        .setFontSize(iconSize)
//                        .build().addButEvent()



    }


    @Override
    public MenuComponent getMenuTree() {
        return menuDirector.getMenuTree();
    }
}
