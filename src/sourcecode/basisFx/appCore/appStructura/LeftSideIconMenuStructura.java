package basisFx.appCore.appStructura;

import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.MainMenuSketch;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.settings.Settings;
import javafx.stage.Stage;

public class LeftSideIconMenuStructura extends AppMainStructura {

    public LeftSideIconMenuStructura(Stage primaryStage ) {

        windowFabric.unDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setPanel(panelFabric.contentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new Coordinate(80d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.titlePanel(//ПАНЕЛЬ С ЗАГЛАВИЕМ
                        new AbstractPanel.PanelBuilder().setHeight(70d)
                                .setPanelCoordinate(new Coordinate(0d,0d,null,0d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.windowButtonsPanel(//ПАНЕЛЬ С Кнопками
                        new AbstractPanel.PanelBuilder().setHeight(25d).setWidth(82d)
                                .setPanelCoordinate(new Coordinate(0d,0d,null,null))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.verticalMenuPanel(//ВЕРТИКАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setWidth(60d)
                                .setPanelCoordinate(new Coordinate(0d,null,0d,0d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.horisontalFlowPanel(//ГОРИЗОНТАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setPanelCoordinate( new Coordinate(49d,0d,null,60d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.textAnchorPanel(//Текстовая панель вывода названия категории меню
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setFont(FontsStore.ROBOTO_LIGHT, 20)
                                .setPanelCoordinate( new Coordinate(15d, 120d, 0d, null))
                                .setParent(Layers.getTitlePanel())
                ))
                .setTitle(titleFabric.createImageTitle()//КАРТИНКА С ЗАГЛАВИЕМ
                        .setTitleCoordinate(new Coordinate(10d, null, null, 70d))
                        .setTitlePanel(Layers.getTitlePanel())
                        .getInstance()
                )
                .setIconAnchor(
                        new Coordinate(0d, 0d, null, 0d),
                        Layers.getVerticalMenuPanel())
                .windowShow();




        MenuCreator.create()
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(
                        menuFabric.createMenuLeftSideRepresentation()
                ).init();


        menuTrigger.verticalMenuButtonFire(1);

    }


}
