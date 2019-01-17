package basisFx.appCore.windows;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FXMLFileLoader;
import basisFx.appCore.guiStructura.GUIStructura;
import javafx.scene.layout.AnchorPane;

public abstract class WindowImpl {
    protected double width;
    protected double height;
    protected WindowAbstraction windowAbstraction;
    protected AnchorPane topLevelAnchorFromFXML;
    protected String titleName;
    protected String message;
    protected ButtonsForStage buttonsForStage;
    protected GUIStructura GUIStructura;
    protected DynamicContentPanelCreator dynamicContentPanelCreator;
    protected String parentAnchorNameForFXML;
    protected WindowBuilder builder;
    protected CallBack callBackSubWindowClosing;

    public WindowImpl(WindowBuilder builder) {
        this.builder=builder;
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
        message=builder.message;
        callBackSubWindowClosing=builder.callBackSubWindowClosing;

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

            AnchorPane parentAnchorHolder = (AnchorPane) windowAbstraction.getNodeFromMap(parentAnchorNameForFXML);

            Coordinate coordinate = new Coordinate(0d, 0d, 0d, 0d);
            coordinate.setChildNode(topLevelAnchorFromFXML);
            coordinate.setParentAnchorPane(parentAnchorHolder);
            coordinate.bonding();

        }
        if (dynamicContentPanelCreator != null) {
            dynamicContentPanelCreator.create().initTemplateMethod(windowAbstraction);
        }
        customInit(windowAbstraction);
    }


    public String getMessage() {
        return message;
    }

    public ButtonsForStage getButtonsForStage() {
        return buttonsForStage;
    }

    public DynamicContentPanelCreator getDynamicContentPanelCreator() {
        return dynamicContentPanelCreator;
    }

    public CallBack getCallBackSubWindowClosing() {
        return callBackSubWindowClosing;
    }
}
