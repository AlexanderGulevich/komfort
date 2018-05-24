package basisFx.domainModel.targets;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.panels.Target;
import basisFx.appCore.utils.Coordinate;


public class ExchangeRatesChartPanel extends Target {

    @Override
    protected void configurate() {

        AppNode.NodeBuilder.create()
                .setParent(panel)
                .setCoordinate(new Coordinate(10d,10d,10d,10d))
                .createAreaChartWrapper();



    }
}
