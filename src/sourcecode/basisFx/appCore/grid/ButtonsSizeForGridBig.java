package basisFx.appCore.grid;

public class ButtonsSizeForGridBig extends ButtonsSizeForGrid {

    @Override
    public void init() {
        setColumnWidth(130d);
        buttonAdd=buttonFactory.addRowButton(tableWrapper);
        buttonDel=buttonFactory.deleteRowButton(tableWrapper);
    }

}
