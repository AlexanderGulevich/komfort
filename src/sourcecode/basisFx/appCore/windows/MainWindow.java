package basisFx.appCore.windows;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.settings.Settings;

public class MainWindow extends WindowKind {

    private static MainWindow instance;

    public static MainWindow getInstance(GuiStructura GuiStructura){
        if (instance == null) {
           return instance=new MainWindow(GuiStructura);
        }else {
           return MainWindow.instance;
        }
    }

    private MainWindow(GuiStructura GuiStructura) {
        super(GuiStructura,Settings.WIDTH,Settings.HEIGHT,Settings.TITLE);

    }
    @Override
    public void initUndecoratedStageButtons() {
        topButtonsFabric.createThreeButtons(window);
    }


}
