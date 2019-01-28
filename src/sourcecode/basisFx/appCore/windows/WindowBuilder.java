package basisFx.appCore.windows;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.guiStructura.GUIStructura;
import lombok.Setter;
import lombok.experimental.Accessors;

public class WindowBuilder {
    public GUIStructura GUIStructura=null;
    public DynamicContentPanelCreator dynamicContentPanelCreator=null;
    public Double width=null;
    public Double height=null;
    public String fxmlFileName=null;
    public String title=null;
    public String parentAnchorNameForFXML=null;
    public ButtonsForStage buttonsForStage=null;
    public String message;
    public CallBack callBackSubWindowClosing;

    private WindowBuilder(Builder builder) {
        GUIStructura = builder.GUIStructura;
        dynamicContentPanelCreator = builder.dynamicContentPanelCreator;
        width = builder.width;
        height = builder.height;
        fxmlFileName = builder.fxmlFileName;
        title = builder.title;
        parentAnchorNameForFXML = builder.parentAnchorNameForFXML;
        buttonsForStage = builder.buttonsForStage;
        message = builder.message;
        callBackSubWindowClosing = builder.closingCallBack;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Accessors (chain = true) @Setter
    public static final class Builder {
        private basisFx.appCore.guiStructura.GUIStructura GUIStructura;
        private DynamicContentPanelCreator dynamicContentPanelCreator;
        private Double width;
        private Double height;
        private String fxmlFileName;
        private String title;
        private String parentAnchorNameForFXML;
        private ButtonsForStage buttonsForStage;
        private String message;
        private CallBack closingCallBack;

        private Builder() {
        }

        public WindowBuilder build() {
            return new WindowBuilder(this);
        }
    }
}
