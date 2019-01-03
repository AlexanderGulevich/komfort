package basisFx.appCore.windows;

public class WindowImplMain extends WindowImpl {

    private static WindowImplMain instance;

    public WindowImplMain(WindowBuilder builder) {
        super(builder);
    }
    public static WindowImplMain getInstance(WindowBuilder builder){
        if (instance == null) {
           return instance=new WindowImplMain(builder);
        }else {
           return WindowImplMain.instance;
        }
    }
    @Override
    protected void setDefaultWidthAndHeight() {
        width=1100d;
        height=700d;
    }
    @Override
    public void customInit(WindowAbstraction windowAbstraction) {
    }
}
