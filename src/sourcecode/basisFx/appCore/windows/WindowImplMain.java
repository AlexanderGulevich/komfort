package basisFx.appCore.windows;


import basisFx.appCore.settings.Settings;

public class WindowImplMain extends WindowImpl {

    private static WindowImplMain instance;

    public static WindowImplMain getInstance(){
        if (instance == null) {
           return instance=new WindowImplMain();
        }else {
           return WindowImplMain.instance;
        }
    }

    private WindowImplMain() {
        super(Settings.WIDTH,Settings.HEIGHT,Settings.TITLE);

    }
    @Override
    public void initUndecoratedStageButtons() {
        new ButtonsForStageThreeEntity(windowAbstraction);
    }


}
