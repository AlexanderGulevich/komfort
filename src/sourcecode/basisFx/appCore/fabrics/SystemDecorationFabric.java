package basisFx.appCore.fabrics;

public abstract class SystemDecorationFabric {

    public abstract WindowFabric createWindowFabric();

    public static SystemDecorated createSystemDecorated(){
        return new SystemDecorated();
    }
    public static SystemUndecorated createSystemUndecorated(){
        return new SystemUndecorated();
    }


}
