package basisFx.appCore.windows;

import basisFx.appCore.appStructura.GuiStructura;
import basisFx.appCore.fabrics.StageTopButtonsFabric;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class WindowKind {

    private double width;
    private double height;
    protected Window window;
    protected String titleName;
    protected StageTopButtonsFabric topButtonsFabric= StageTopButtonsFabric.getInstance();
    private  HashMap<String,Panel> panelHashMap =new HashMap<>();

    public WindowKind(GuiStructura structura,double width,double height,String titleName) {
        setHeight(height);
        setWidth(width);
        setTitleName(titleName);

        ArrayList<Panel> panels = structura.getPanels();

        for (Panel panel : panels) {
            panelHashMap.put(panel.getName(),panel);
        }
    }

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

    public void setWindow(Window window) {
        this.window = window;
    }
    public  HashMap getPanelHashMap(){
        return panelHashMap;
    }
    public  Panel getPanel(String str){
        return panelHashMap.get(str);
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
