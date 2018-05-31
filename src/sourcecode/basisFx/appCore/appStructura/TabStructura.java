package basisFx.appCore.appStructura;

import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.registry.Layers;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowDecorated;
import basisFx.appCore.windows.WindowFx;
import javafx.stage.Stage;

public class TabStructura extends AppMainStructura{


    public TabStructura( WindowFx windowFx) {



        windowFx.setPanel(panelFabric.contentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА
                        new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new Coordinate(80d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                ));





        windowFx.windowShow();

    }
}
