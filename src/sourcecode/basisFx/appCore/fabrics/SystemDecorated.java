package basisFx.appCore.fabrics;

import basisFx.appCore.utils.SystemRegistry;

public class SystemDecorated extends SystemDecorationFabric {
    @Override
    public WindowFabric createWindowFabric() {
        WindowDecoratedFabric fabric = new WindowDecoratedFabric();
        SystemRegistry.windowFabric=fabric;
        return fabric;
    }
}
