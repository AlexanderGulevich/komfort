package basisFx.appCore.windows;

import basisFx.appCore.appStructura.PanelsStructura;
import basisFx.appCore.settings.WindowsTitlesNames;

public class MainWindow extends WindowImplimentation {

    private static MainWindow instance;

    public static MainWindow getInstance(PanelsStructura panelsStructura){
        if (instance == null) {
           return instance=new MainWindow(panelsStructura);
        }else {
           return MainWindow.instance;
        }
    }

    private MainWindow(PanelsStructura panelsStructura) {
        super(panelsStructura);
    }
    @Override
    protected String getTitleName() {
        return WindowsTitlesNames.MAIN_WINDOW_NAME.get();
    }
    @Override
    public void initUndecoratedStageButtons() {
        topButtonsFabric.createThreeButtons(window);
    }


}
