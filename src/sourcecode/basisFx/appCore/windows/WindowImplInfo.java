package basisFx.appCore.windows;

import basisFx.service.ServiceCrossWindowInfo;
import basisFx.service.ServiceCrossWindowMain_v1;
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
        ((ServiceCrossWindowInfo) serviceCrossWindow).setMessage(builder.message);
    }

    @Override
    public void addToRegistry(WindowAbstraction windowAbstraction) {

    }
}
