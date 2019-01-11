package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import javafx.scene.control.Button;

public  abstract class ButSizeForGrid {

    protected TableWrapper tableWrapper;
    protected Button buttonAdd;
    protected Button  buttonDel;
    protected Double  columnWidth;
    protected ButtonFactory buttonFactory = ButtonFactory.getInstance();

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public Button getButtonDel() {
        return buttonDel;
    }

    public abstract void init();

    public Double getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(Double columnWidth) {
        this.columnWidth = columnWidth;
    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

}
