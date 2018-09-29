package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class ButtonNon  extends TablesButtonKindConfigurationStrategy{
    private Insets insets = new Insets(3, 3, 3, 3);

    public ButtonNon(TableWrapper tableWrapper) {
        super(tableWrapper);
    }

    @Override
    public void organize(GridPaneWrapper gridPaneWrapper) {

        gridPaneWrapper.addSpanNode(
                gridPaneWrapper.label.getElement(),
                0, 0, 1, 1, HPos.LEFT, VPos.TOP, insets);
        gridPaneWrapper.addSpanNode(
                tableWrapper.getElement(),
                0, 1, 1, 1, HPos.CENTER, VPos.TOP, insets);

    }
}
