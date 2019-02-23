package basisFx.appCore.windows;

public class WindowImplDialog extends WindowImpl {
    private  String messagge;

    public WindowImplDialog(WindowBuilder builder) {
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
         serviceCrossWindow.setMessage(builder.message);
    }

    @Override
    public void addToRegistry(WindowAbstraction windowAbstraction) {

    }
}
