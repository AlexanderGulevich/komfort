package basisFx.appCore.fabrics;


import basisFx.appCore.appStructura.LeftAndTopMenuUndecorated;

public class GuiStructuraFabric {
    private static GuiStructuraFabric ourInstance = new GuiStructuraFabric();

    public static GuiStructuraFabric getInstance() {
        return ourInstance;
    }


    public LeftAndTopMenuUndecorated leftAndTopMenuUndecorated(){
        return new LeftAndTopMenuUndecorated();
    }
}
