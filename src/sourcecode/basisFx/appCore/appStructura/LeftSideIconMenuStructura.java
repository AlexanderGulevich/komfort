package basisFx.appCore.appStructura;

import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.AnchorCoordinate;
import basisFx.domainModel.MainMenuSketch;
import basisFx.domainModel.settings.FontsStore;
import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;

public class LeftSideIconMenuStructura extends AppMainStructura {

    public LeftSideIconMenuStructura(Stage primaryStage ) {

        windowFabric.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setPanel(panelFabric.createContentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new AnchorCoordinate(50d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.createTitlePanel(//ПАНЕЛЬ С ЗАГЛАВИЕМ
                        new AbstractPanel.PanelBuilder().setHeight(70d)
                                .setPanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.createVerticalMenuPanel(//ВЕРТИКАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setWidth(60d)
                                .setPanelCoordinate(new AnchorCoordinate(0d,null,0d,0d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.createHorisontalFlowPanel(//ГОРИЗОНТАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setPanelCoordinate( new AnchorCoordinate(49d,0d,null,60d))
                                .setParent(Layers.getVisibleRoot())
                ))
                .setPanel(panelFabric.createTextAnchorPanel(//Текстовая панель вывода названия категории меню
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setFont(FontsStore.ROBOTO_LIGHT, 20)
                                .setPanelCoordinate( new AnchorCoordinate(15d, 120d, 0d, null))
                                .setParent(Layers.getTitlePanel())
                ))
                .setTitle(titleFabric.createImageTitle()//КАРТИНКА С ЗАГЛАВИЕМ
                        .setTitleCoordinate(new AnchorCoordinate(10d, null, null, 70d))
                        .setTitlePanel(Layers.getTitlePanel())
                        .getInstance()
                )
                .setIconAnchor(
                        new AnchorCoordinate(0d, 0d, null, 0d),
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
