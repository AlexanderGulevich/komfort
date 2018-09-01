package basisFx.presentation.windows;


import basisFx.appCore.settings.Settings;

public class MainWindow extends WindowKind {

    private static MainWindow instance;

    public static MainWindow getInstance(){
        if (instance == null) {
           return instance=new MainWindow();
        }else {
           return MainWindow.instance;
        }
    }

    private MainWindow() {
        super(Settings.WIDTH,Settings.HEIGHT,Settings.TITLE);

    }
    @Override
    public void initUndecoratedStageButtons() {
//        topButtonsFabric.createThreeButtons(window);
    }


}
