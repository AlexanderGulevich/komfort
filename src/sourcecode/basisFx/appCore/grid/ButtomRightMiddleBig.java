package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

public class ButtomRightMiddleBig  extends TablesButtonKindConfigurationStrategy{
    private Insets insets = new Insets(3, 3, 3, 3);
    private Button buttonAdd;
    private Button buttonDel;

    public ButtomRightMiddleBig(TableWrapper tableWrapper) {
        super(tableWrapper);
        buttonAdd = buttonFactory.addRowButton(tableWrapper);
        buttonDel = buttonFactory.deleteRowButton(tableWrapper);

    }

    @Override
    public void organize(GridPaneWrapper gridPaneWrapper) {


        gridPaneWrapper.addSpanNode(
                gridPaneWrapper.label.getElement(),
                0, 0, 2, 1, HPos.LEFT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonAdd,
                1, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                buttonDel,
                1, 2, 1, 1, HPos.CENTER, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 1, 2, HPos.CENTER, VPos.TOP, insets);

    }
}
