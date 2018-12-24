package basisFx.appCore.windows;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class WindowImplInfo extends WindowImpl{

    private  String messagge;

    public WindowImplInfo(String messagge) {
        super(550d, 350d, "Внимание!");
        this.messagge=messagge;

    }

    @Override
    public void init() {
        Label label = (Label) windowAbstraction.getNode("label").getElement();
        label.setText(titleName);
        TextArea textArea = (TextArea) windowAbstraction.getNode("textArea").getElement();
        textArea.setText(messagge);

    }
}
