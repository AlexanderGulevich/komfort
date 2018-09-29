package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class ButtomRightMiddleBig  extends TablesButtonKindConfigurationStrategy{
    private Insets insets = new Insets(3, 3, 3, 3);
    private Button buttonAdd = buttonFactory.addRowButton(tableWrapper, tableWrapper.activeRecord.getClass());
    private Button buttonDel = buttonFactory.deleteRowButton(tableWrapper);

    public ButtomRightMiddleBig() {
    }

    @Override
    public void organize(GridPaneWrapper gridPaneWrapper) {


        gridPaneWrapper.addSpanNode(
                gridPaneWrapper.label.getElement(),
                0, 0, 3, 1, HPos.LEFT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonAdd,
                2, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonDel,
                2, 2, 1, 1, HPos.CENTER, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 2, 2, HPos.CENTER, VPos.TOP, insets);

    }
}
