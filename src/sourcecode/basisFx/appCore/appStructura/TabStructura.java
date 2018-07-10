package basisFx.appCore.appStructura;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowAbstraction;

public class TabStructura extends GuiStructura {


    public TabStructura( WindowAbstraction windowAbstraction) {



        windowAbstraction.setPanel(panelFabric.contentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new Coordinate(80d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ));





        windowAbstraction.windowShow();

    }
}
