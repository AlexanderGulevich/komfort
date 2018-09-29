package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class ButtonBottomRightLittle extends TablesButtonKindConfigurationStrategy {

    private Insets insets = new Insets(3, 3, 3, 3);
    private Button buttonAddLittle = buttonFactory.littleRowAddButton(tableWrapper, tableWrapper.activeRecord.getClass());
    private Button  buttonDelLittle = buttonFactory.littleRowDeleteButton(tableWrapper);

    public ButtonBottomRightLittle(TableWrapper tableWrapper) {
        super(tableWrapper);
    }

    @Override
    public void organize(GridPaneWrapper gridPaneWrapper) {

        gridPaneWrapper.addSpanNode(
                gridPaneWrapper.label.getElement(),
                0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonAddLittle,
                2, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonDelLittle,
                1, 2, 1, 1, HPos.RIGHT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 3, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
