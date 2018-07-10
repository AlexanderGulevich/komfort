package basisFx.appCore.windows;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.fabrics.WindowTopButtonsFabric;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class WindowImplimentation {

    private double width;
    private double height;
    protected WindowAbstraction window;
    protected String titleName;
    protected WindowTopButtonsFabric topButtonsFabric=WindowTopButtonsFabric.getInstance();
    private  HashMap<String,Panel> panelHashMap =new HashMap<>();


    public WindowImplimentation(GuiStructura structura) {
        ArrayList<Panel> panels = structura.getPanels();

        for (Panel panel : panels) {
            panelHashMap.put(panel.getName(),panel);
        }
    }

    protected abstract String getTitleName();
    public abstract void initUndecoratedStageButtons();


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWindow(WindowAbstraction window) {
        this.window = window;
    }
    public  HashMap getPanelHashMap(){
        return panelHashMap;
    }
    public  Panel getPanel(String str){
        return panelHashMap.get(str);
    }


}
