package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class GridOrgSubmitSingleTable extends GridOrganization{

    private TableWrapper tableWrapper;
    private Insets insets = new Insets(3, 3, 3, 3);
    private Button submitButton;

    public GridOrgSubmitSingleTable(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
//        submitButton=buttonFactory.

    }


    @Override
    public void organize() {

        bindHeight(tableWrapper);

        parentGridWrapper.addSpanNode(
                parentGridWrapper.label.getElement(),
                0, 0, 2, 1, HPos.LEFT, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                submitButton,
                1, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
        parentGridWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
