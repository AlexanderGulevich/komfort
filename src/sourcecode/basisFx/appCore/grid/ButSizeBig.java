package basisFx.appCore.grid;

public class ButSizeBig extends ButSizeForGrid {

    @Override
    public void init() {
        setColumnWidth(130d);
        buttonAdd=buttonFactory.addRowButton(tableWrapper);
        buttonDel=buttonFactory.deleteRowButton(tableWrapper);
    }

}
