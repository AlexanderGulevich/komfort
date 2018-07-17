package basisFx.appCore.fabrics;

public abstract class DecorationAbstractFabric {

    public abstract WindowFabric createWindowFabric();

    public static Decorated createSystemDecorated(){
        return new Decorated();
    }
    public static UndecoratedAbstract createSystemUndecorated(){
        return new UndecoratedAbstract();
    }


}
