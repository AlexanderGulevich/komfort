package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class GridOrganizationButtonNonSingleTable extends GridOrganization{
    private TableWrapper tableWrapper;

    public GridOrganizationButtonNonSingleTable(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    @Override
    public void organize() {

        bindHeight(tableWrapper);

        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
