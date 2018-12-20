package basisFx.appCore.windows;

public class WindowImplInfo extends WindowImpl{
    public WindowImplInfo() {
        super(400d, 350d, "Внимание!");
    }

    @Override
    public void initUndecoratedStageButtons() {
        new ButtonsForStageThreeEntity(windowAbstraction);
    }


}
