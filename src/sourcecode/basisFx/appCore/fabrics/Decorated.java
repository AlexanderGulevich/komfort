package basisFx.appCore.fabrics;

import basisFx.appCore.utils.SystemRegistry;

public class Decorated extends DecorationAbstractFabric {
    @Override
    public WindowFabric createWindowFabric() {
        WindowDecoratedFabric fabric = new WindowDecoratedFabric();
        SystemRegistry.windowFabric=fabric;
        return fabric;
    }
}
