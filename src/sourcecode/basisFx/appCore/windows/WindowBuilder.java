package basisFx.appCore.windows;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.DynamicContentPanelCreator;
import basisFx.appCore.guiStructura.GUIStructura;

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
        callBackSubWindowClosing = builder.callBackSubWindowClosing;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

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
        private CallBack callBackSubWindowClosing;

        private Builder() {
        }

        public Builder setGUIStructura(GUIStructura val) {
            GUIStructura = val;
            return this;
        }

        public Builder setDynamicContentPanelCreator(DynamicContentPanelCreator val) {
            dynamicContentPanelCreator = val;
            return this;
        }

        public Builder setWidth(Double val) {
            width = val;
            return this;
        }

        public Builder setHeight(Double val) {
            height = val;
            return this;
        }

        public Builder setFxmlFileName(String val) {
            fxmlFileName = val;
            return this;
        }

        public Builder setTitle(String val) {
            title = val;
            return this;
        }

        public Builder setParentAnchorNameForFXML(String val) {
            parentAnchorNameForFXML = val;
            return this;
        }

        public Builder setButtonsForStage(ButtonsForStage val) {
            buttonsForStage = val;
            return this;
        }

        public Builder setMessage(String val) {
            message = val;
            return this;
        }

        public Builder setClosingCallBack(CallBack val) {
            callBackSubWindowClosing = val;
            return this;
        }

        public WindowBuilder build() {
            return new WindowBuilder(this);
        }
    }
}
