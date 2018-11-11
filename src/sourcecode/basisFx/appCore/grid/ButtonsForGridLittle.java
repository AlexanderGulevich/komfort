package basisFx.appCore.grid;


public class ButtonsForGridLittle extends ButtonsForGrid {

    @Override
    public void init() {
        setColumnWidth(40d);
        buttonAdd=buttonFactory.littleRowAddButton(tableWrapper);
        buttonDel=buttonFactory.littleRowDeleteButton(tableWrapper);
    }

}
