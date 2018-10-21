package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class GridOrganizationButtomBottomTopRightBigSingleTable extends GridOrganization{

    private TableWrapper tableWrapper;
    private Button buttonAdd;
    private Button buttonDel;

    public GridOrganizationButtomBottomTopRightBigSingleTable(TableWrapper tableWrapper) {
        this.tableWrapper=tableWrapper;
        buttonAdd = buttonFactory.addRowButton(tableWrapper);
        buttonDel = buttonFactory.deleteRowButton(tableWrapper);

    }

    @Override
    public void organize(   ) {

        bindHeight(tableWrapper);

        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonAdd,
                2, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                buttonDel,
                1, 0, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 3, 2, HPos.CENTER, VPos.TOP, insets);

    }
}
