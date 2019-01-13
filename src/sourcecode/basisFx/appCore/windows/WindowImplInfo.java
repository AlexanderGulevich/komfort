package basisFx.appCore.windows;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class WindowImplInfo extends WindowImpl{

    private  String messagge;

    public WindowImplInfo(WindowBuilder builder) {
        super(builder);
        this.messagge=builder.message;

    }

    @Override
    protected void setDefaultWidthAndHeight() {
        width=530d;
        height=300d;
    }

    @Override
    public void customInit(WindowAbstraction windowAbstraction) {
//        Label label = (Label) windowAbstraction.getNodeFromMap("label").getElement();
//        label.setText(titleName);
//        TextArea textArea = (TextArea) windowAbstraction.getNodeFromMap("textArea").getElement();
//        textArea.setText(messagge);

    }
}
