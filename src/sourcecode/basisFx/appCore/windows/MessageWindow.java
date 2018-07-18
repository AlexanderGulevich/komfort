package basisFx.appCore.windows;

import basisFx.appCore.appStructura.GuiStructura;

public class MessageWindow extends WindowKind {

    private String message;

    public MessageWindow(GuiStructura structura) {
        super(structura,500d , 300d,"Уведомление");
    }

    @Override
    public void initUndecoratedStageButtons() {

    }

    public void setMessage(String message) {
        this.message = message;
    }
}
