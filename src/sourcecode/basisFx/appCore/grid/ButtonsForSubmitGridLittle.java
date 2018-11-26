package basisFx.appCore.grid;

public class ButtonsForSubmitGridLittle extends ButtonsForGrid{
    @Override
    public void init() {
        setColumnWidth(40d);
        buttonAdd=buttonFactory.littleRowAddButtonForSubmitTable(tableWrapper);
        buttonDel=buttonFactory.littleRowDeleteButton(tableWrapper);

    }
}
