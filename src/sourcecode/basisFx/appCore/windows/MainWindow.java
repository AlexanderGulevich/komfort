package basisFx.appCore.windows;

import basisFx.appCore.appStructura.GuiStructura;

public class MainWindow extends WindowImplimentation {

    private static MainWindow instance;

    public static MainWindow getInstance(GuiStructura GuiStructura){
        if (instance == null) {
           return instance=new MainWindow(GuiStructura);
        }else {
           return MainWindow.instance;
        }
    }

    private MainWindow(GuiStructura GuiStructura) {
        super(GuiStructura);
    }
    @Override
    protected String getTitleName() {
        return "KOMFORT";
    }
    @Override
    public void initUndecoratedStageButtons() {
        topButtonsFabric.createThreeButtons(window);
    }


}
