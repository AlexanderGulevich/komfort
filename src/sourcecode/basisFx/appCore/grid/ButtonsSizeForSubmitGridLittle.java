package basisFx.appCore.grid;

public class ButtonsSizeForSubmitGridLittle extends ButtonsSizeForGrid {
    @Override
    public void init() {
        setColumnWidth(40d);
        buttonAdd=buttonFactory.littleRowAddButtonForSubmitTable(tableWrapper);
        buttonDel=buttonFactory.littleRowDeleteButton(tableWrapper);

    }
}
