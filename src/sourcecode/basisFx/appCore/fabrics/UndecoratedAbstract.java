package basisFx.appCore.fabrics;

import basisFx.appCore.utils.SystemRegistry;

public class UndecoratedAbstract extends DecorationAbstractFabric {
    @Override
    public WindowFabric createWindowFabric() {
        WindowUndecoratedFabric fabric = new WindowUndecoratedFabric();
        SystemRegistry.windowFabric=fabric;
        return fabric;
    }
}
