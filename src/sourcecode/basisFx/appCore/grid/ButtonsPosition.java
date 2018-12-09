package basisFx.appCore.grid;

import basisFx.appCore.elements.GridPaneWrapper;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public abstract class ButtonsPosition {

    protected Insets insets = new Insets(3, 3, 3, 3);
    protected GridPaneWrapper parentGridWrapper;


    public abstract void organize(Label label, Button addBut, Button delBut, TableView tableView);

    public void setParentGridWrapper(GridPaneWrapper parentGridWrapper) {
        this.parentGridWrapper = parentGridWrapper;
    }
}
