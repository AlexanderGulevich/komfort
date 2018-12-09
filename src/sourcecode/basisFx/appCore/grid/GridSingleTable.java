package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class GridSingleTable extends GridOrganization{
    private ButtonsSizeForGrid buttonsSizeForGrid;

    public GridSingleTable(TableWrapper tableWrapper, ButtonsSizeForGrid buttonsSizeForGrid, ButtonsPosition position) {
        this.buttonsPosition=position;
        this.tableWrapper = tableWrapper;
        this.buttonsSizeForGrid = buttonsSizeForGrid;
        this.buttonsSizeForGrid.setTableWrapper(tableWrapper);
        this.buttonsSizeForGrid.init();

    }

    public GridSingleTable(ButtonsSizeForGrid buttonsSizeForGrid, ButtonsPosition position) {
        this.buttonsPosition=position;
        this.buttonsSizeForGrid = buttonsSizeForGrid;

    }

    @Override
    public GridSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }


    @Override
    public void organize() {
        buttonsPosition.setParentGridWrapper(parentGridWrapper);
        buttonsSizeForGrid.setTableWrapper(tableWrapper);
        buttonsSizeForGrid.init();

        parentGridWrapper.setColumnComputerWidth();
        parentGridWrapper.setColumnFixed(buttonsSizeForGrid.getColumnWidth());
        parentGridWrapper.setColumnFixed(buttonsSizeForGrid.getColumnWidth());

        bindHeight(tableWrapper);

        buttonsPosition.organize(
                parentGridWrapper.label.getElement(),
                buttonsSizeForGrid.buttonAdd,
                buttonsSizeForGrid.buttonDel,
                tableWrapper.getElement()
        );




    }
}
