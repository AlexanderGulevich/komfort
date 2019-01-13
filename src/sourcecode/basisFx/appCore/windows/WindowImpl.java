package basisFx.appCore.windows;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.utils.FXMLFileLoader;
import basisFx.presentation.appStructura.GUIStructura;
import javafx.scene.layout.AnchorPane;

public abstract class WindowImpl {
    protected double width;
    protected double height;
    protected WindowAbstraction windowAbstraction;
    protected AnchorPane topLevelAnchorFromFXML;
    protected String titleName;
    protected ButtonsForStage buttonsForStage;
    protected GUIStructura GUIStructura;
    protected DynamicContentPanelCreator dynamicContentPanelCreator;
    protected String parentAnchorNameForFXML;

    public WindowImpl(WindowBuilder builder) {
        if (builder.fxmlFileName != null) {
            topLevelAnchorFromFXML = FXMLFileLoader.load(builder.fxmlFileName);
        }
        if (builder.height != null && builder.width != null) {
            height=builder.height;
            width=builder.width;
        }else {
            setDefaultWidthAndHeight();
        }
        buttonsForStage=builder.buttonsForStage;
        GUIStructura =builder.GUIStructura;
        parentAnchorNameForFXML=builder.parentAnchorNameForFXML;
        dynamicContentPanelCreator=builder.dynamicContentPanelCreator;
        titleName=builder.title;

    }
    public WindowAbstraction getWindowAbstraction() {
        return windowAbstraction;
    }
    public String getTitleName() {
        return titleName;
    }
    public void setWindowAbstraction(WindowAbstraction windowAbstraction) {
        this.windowAbstraction = windowAbstraction;
    }
    protected abstract void setDefaultWidthAndHeight();

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //этот метод необходим в случае если необходимо некое конфигурирование из абстракции моста,
    // после того как абстракция проинициализирована реализацией и реальзация содержит ссылку на абстрацию, хранящую узлы

    public abstract void customInit(WindowAbstraction windowAbstraction);
    public  void initTemplateMethod(WindowAbstraction windowAbstraction){

        if (GUIStructura != null) {
            GUIStructura.init(windowAbstraction);
        }
        if (buttonsForStage != null) {
            buttonsForStage.initTemplateMethod(windowAbstraction);
        }
        if (parentAnchorNameForFXML != null && topLevelAnchorFromFXML != null ) {
            ((AnchorPane) windowAbstraction.getNodeFromMap(parentAnchorNameForFXML)).getChildren().add(topLevelAnchorFromFXML);
        }
        if (dynamicContentPanelCreator != null) {
            dynamicContentPanelCreator.create().initTemplateMethod(windowAbstraction);
        }
        customInit(windowAbstraction);
    }
}
