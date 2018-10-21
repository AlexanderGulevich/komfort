package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class GridOrganizationButtonBottomRightLittleSingleTable extends GridOrganization {
    private TableWrapper tableWrapper;
    private Button buttonAddLittle;
    private Button  buttonDelLittle;

    public GridOrganizationButtonBottomRightLittleSingleTable(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
        buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper, tableWrapper.activeRecord.getClass());
        buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);

    }

    @Override
    public void organize( ) {

        bindHeight(tableWrapper);
        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonAddLittle,
                2, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonDelLittle,
                1, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
