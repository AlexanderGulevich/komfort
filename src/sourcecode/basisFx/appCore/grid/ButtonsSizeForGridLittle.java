package basisFx.appCore.grid;


public class ButtonsSizeForGridLittle extends ButtonsSizeForGrid {

    @Override
    public void init() {
        setColumnWidth(40d);
        buttonAdd=buttonFactory.littleRowAddButton(tableWrapper);
        buttonDel=buttonFactory.littleRowDeleteButton(tableWrapper);
    }

}
