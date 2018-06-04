package basisFx.appCore.appStructura;

import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowFx;
import basisFx.domainModel.MainMenuSketch;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.settings.Settings;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.awt.*;

public class LeftSideIconMenuStructura extends AppMainStructura {

    public LeftSideIconMenuStructura(WindowFx window ) {

        window.setPanel(//Корневой узел прозрачный для безрамкового окна
                panelFabric.transparentRootPanel(
                        new AbstractPanel.PanelBuilder()
                                .setInsets(new Insets(3d, 3d, 3d, 3d))));

        window.setPanel(//Дочерняя панель к корневому узлу, явл. первой видимой
                panelFabric.visibleRootPanel(
                        new AbstractPanel.PanelBuilder()
                                .setParent(Layers.getTransparentRoot())
                                .setPanelCoordinate(new Coordinate(0d, 0d, 0d, 0d))));

        window.setPanel(panelFabric.contentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new Coordinate(80d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ));
        window.setPanel(panelFabric.titlePanel(//ПАНЕЛЬ С ЗАГЛАВИЕМ
                        new AbstractPanel.PanelBuilder().setHeight(70d)
                                .setPanelCoordinate(new Coordinate(0d,0d,null,0d))
                                .setParent(Layers.getVisibleRoot())
                ));
        window.setPanel(panelFabric.windowButtonsPanel(//ПАНЕЛЬ С Кнопками
                        new AbstractPanel.PanelBuilder().setHeight(25d).setWidth(82d)
                                .setPanelCoordinate(new Coordinate(0d,0d,null,null))
                                .setParent(Layers.getVisibleRoot())
                ));
        window.setPanel(panelFabric.verticalMenuPanel(//ВЕРТИКАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setWidth(60d)
                                .setPanelCoordinate(new Coordinate(0d,null,0d,0d))
                                .setParent(Layers.getVisibleRoot())
                ));
        window.setPanel(panelFabric.horisontalFlowPanel(//ГОРИЗОНТАЛЬНОЕ МЕНЮ
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setPanelCoordinate( new Coordinate(49d,0d,null,60d))
                                .setParent(Layers.getVisibleRoot())
                ));
        window.setPanel(panelFabric.textAnchorPanel(//Текстовая панель вывода названия категории меню
                        new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setFont(FontsStore.ROBOTO_LIGHT, 20)
                                .setPanelCoordinate( new Coordinate(15d, 120d, 0d, null))
                                .setParent(Layers.getTitlePanel())
                ));

        window.setTitle(titleFabric.createImageTitle()//КАРТИНКА С ЗАГЛАВИЕМ
                        .setTitleCoordinate(new Coordinate(10d, null, null, 70d))
                        .setTitlePanel(Layers.getTitlePanel())
                        .getInstance()
                );

        window.setPanel(panelFabric.iconAnchorPanel(
                new AbstractPanel.PanelBuilder().setHeight(35d)
                        .setFont(FontsStore.ROBOTO_LIGHT, 20)
                        .setPanelCoordinate( new Coordinate(0d, 0d, null, 0d))
                        .setParent(Layers.getVerticalMenuPanel())
        ));



    }


}
