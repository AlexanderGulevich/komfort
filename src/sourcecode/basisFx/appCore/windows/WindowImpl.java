package basisFx.appCore.windows;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.FXMLFileLoader;
import basisFx.appCore.guiStructura.GUIStructura;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;

public abstract class WindowImpl {
    @Getter protected double width;
    @Getter protected double height;
    @Getter @Setter protected WindowAbstraction windowAbstraction;
    protected AnchorPane topLevelAnchorFromFXML;
    @Getter protected String titleName;
    @Getter protected String message;
    @Getter protected ButtonsForStage buttonsForStage;
    @Getter protected GUIStructura GUIStructura;
    @Getter protected DynamicContentPanelCreator dynamicContentPanelCreator;
    protected String parentAnchorNameForFXML;
    protected WindowBuilder builder;
    @Getter protected CallBack callBackSubWindowClosing;

    protected abstract void setDefaultWidthAndHeight();
    public abstract void customInit(WindowAbstraction windowAbstraction);

    public WindowImpl(WindowBuilder builder) {
        this.builder=builder;
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

    public  void initTemplateMethod(WindowAbstraction windowAbstraction){

        if (GUIStructura != null) {
            GUIStructura.init(windowAbstraction);
        }
        if (buttonsForStage != null) {
            buttonsForStage.initTemplateMethod(windowAbstraction);
        }

        if (dynamicContentPanelCreator != null) {
            dynamicContentPanelCreator.create().initTemplateMethod(windowAbstraction);
        }

        if (builder.fxmlFileName != null) {
            topLevelAnchorFromFXML = FXMLFileLoader.load(builder.fxmlFileName);
        }
        if (parentAnchorNameForFXML != null && topLevelAnchorFromFXML != null ) {

            AnchorPane parentAnchorHolder = (AnchorPane) windowAbstraction.getNodeFromMap(parentAnchorNameForFXML);

            Coordinate coordinate = new Coordinate(0d, 0d, 0d, 0d);
            coordinate.setChildNode(topLevelAnchorFromFXML);
            coordinate.setParentAnchorPane(parentAnchorHolder);
            coordinate.bonding();

        }
        customInit(windowAbstraction);
    }


}
