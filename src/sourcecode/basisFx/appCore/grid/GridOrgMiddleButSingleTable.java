package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class GridOrgMiddleButSingleTable extends GridOrganization {

    private TableWrapper tableWrapper;
    private Insets insets = new Insets(3, 3, 3, 3);
    private Button   buttonAddLittle;
    private Button  buttonDelLittle;

    public GridOrgMiddleButSingleTable(TableWrapper tableWrapper) {

        this.tableWrapper = tableWrapper;
        buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper);
        buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);

    }

    @Override
    public void organize() {

        bindHeight(tableWrapper);
        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonAddLittle,
                2, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonDelLittle,
                2, 2, 1, 1, HPos.CENTER, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 2, 2, HPos.CENTER, VPos.TOP, insets);
    }}