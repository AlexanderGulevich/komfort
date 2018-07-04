package basisFx.appCore.appStructura;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowBridgeAbstraction;

public class TabStructura extends PanelsStructura {


    public TabStructura( WindowBridgeAbstraction windowBridgeAbstraction) {



        windowBridgeAbstraction.setPanel(panelFabric.contentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new Coordinate(80d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ));





        windowBridgeAbstraction.windowShow();

    }
}
