package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class GridOrgTopButSingleTable extends GridOrganization{
    private TableWrapper tableWrapper;
    private ButtonsForGrid  buttonsForGrid;

    public GridOrgTopButSingleTable(TableWrapper tableWrapper, ButtonsForGrid  buttonsForGrid) {
        this.tableWrapper = tableWrapper;
        this.buttonsForGrid=buttonsForGrid;
        this.buttonsForGrid.setTableWrapper(tableWrapper);
        this.buttonsForGrid.init();
    }

    @Override
    public GridOrgTopButSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }


    @Override
    public void organize() {

        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setColumnFixed(buttonsForGrid.getColumnWidth());
        parentGridWrapper.setColumnFixed(buttonsForGrid.getColumnWidth());

        bindHeight(tableWrapper);

        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonsForGrid.getButtonAdd(),
                2, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonsForGrid.getButtonDel(),
                1, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
