package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GridOrganizationButtonTopRightLittleSingleTable extends GridOrganization{
    private TableWrapper tableWrapper;
    private Button buttonAddLittle;
    private Button  buttonDelLittle;

    public GridOrganizationButtonTopRightLittleSingleTable(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
        buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper);
        buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);
    }

    @Override
    public GridOrganizationButtonTopRightLittleSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return this;
    }


    @Override
    public void organize() {

        bindHeight(tableWrapper);

        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonAddLittle,
                2, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonDelLittle,
                1, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
