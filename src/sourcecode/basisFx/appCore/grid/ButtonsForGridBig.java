package basisFx.appCore.grid;

public class ButtonsForGridBig extends ButtonsForGrid {

    @Override
    public void init() {
        setColumnWidth(130d);
        buttonAdd=buttonFactory.addRowButton(tableWrapper);
        buttonDel=buttonFactory.deleteRowButton(tableWrapper);
    }

}
