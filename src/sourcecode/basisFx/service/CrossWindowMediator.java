package basisFx.service;

import basisFx.appCore.interfaces.CallBack;
import basisFx.appCore.interfaces.Receiver;
import basisFx.appCore.utils.DTO;
import basisFx.appCore.windows.WindowAbstraction;

public class CrossWindowMediator {
    private WindowAbstraction  parentWindow;
    private WindowAbstraction  subWindow;
    private DTO  dto;
    private Receiver receiver;
    protected CallBack callBackSubWindowClosing;


    public CrossWindowMediator(WindowAbstraction parentWindow) {
        this.parentWindow = parentWindow;
    }

    public void setSubWindow(WindowAbstraction subWindow) {
        this.subWindow = subWindow;
    }

    public void clearSubWindow() {
        subWindow=null;
    }
    public void informParentWindow(DTO dto) {
        receiver.receiveDTO(dto);
        closeSubWindow();
    }
    public void informParentWindowAboutClosing() {
        callBackSubWindowClosing.call();
        closeSubWindow();
    }

    public void closeSubWindow() {
        subWindow.getStage().close();
        subWindow=null;
    }

    public void setDTO(DTO dto) {
        this.dto = dto;
    }

    public void setReceiverDataFromSubWindow(Receiver receiver) {
        this.receiver = receiver;
    }

    public void setCallBackSubWindowClosing(CallBack callBackSubWindowClosing) {
        this.callBackSubWindowClosing = callBackSubWindowClosing;
    }
}
