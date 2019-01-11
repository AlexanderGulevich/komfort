package basisFx.appCore.grid;


public class ButSizeLittle extends ButSizeForGrid {

    @Override
    public void init() {
        setColumnWidth(40d);
        buttonAdd=buttonFactory.littleRowAddButton(tableWrapper);
        buttonDel=buttonFactory.littleRowDeleteButton(tableWrapper);
    }

}
