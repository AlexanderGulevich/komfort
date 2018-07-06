package basisFx.appCore.windows;

import basisFx.appCore.panels.Panel;
import basisFx.appCore.settings.WindowsTitlesNames;

import java.util.HashMap;

public class MainWindow extends WindowBridgeImplimentation {

    private static HashMap<String,Panel> panels=new HashMap<>();

    public MainWindow() {

    }
    public static HashMap getPanels(){
        return MainWindow.panels;
    }
    public static Panel getPanel(String str){
        return MainWindow.panels.get(str);
    }
    @Override
    protected void initUndecoratedTitle() {

    }
    @Override
    protected void initDecoratedTitle() {
        window.getStage().setTitle(WindowsTitlesNames.MAIN_WINDOW_NAME.get());
    }
    @Override
    public void initUndecoratedStageButtons() {

    }


}
