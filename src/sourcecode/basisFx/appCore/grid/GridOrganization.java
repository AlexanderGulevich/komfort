package basisFx.appCore.grid;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public abstract class GridOrganization {

    protected Insets insets = new Insets(3, 3, 3, 3);
    protected GridPaneWrapper parentGridWrapper;
    protected ButtonFactory buttonFactory = ButtonFactory.getInstance();
    protected Label label;

    protected ButtonsPosition buttonsPosition;

    public abstract void organize();

    public GridSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return null;
    }
    public void setParentGridPaneWrapper(GridPaneWrapper gridPaneWrapper) {
        this.parentGridWrapper = gridPaneWrapper;
    }

    public GridPaneWrapper getParentGridWrapper() {
        return parentGridWrapper;
    }

    protected void bindHeight(GridPaneWrapper gridPaneWrapper){
        parentGridWrapper.getElement().prefHeightProperty().addListener((observable, oldValue, newValue) -> {
            gridPaneWrapper.getElement().setPrefHeight(newValue.doubleValue()-10d);
        });

    }
    protected void bindHeight(TableWrapper tableWrapper){
        parentGridWrapper.getElement().prefHeightProperty().addListener((observable, oldValue, newValue) -> {
            tableWrapper.getElement().setPrefHeight(newValue.doubleValue()-10d);
        });
    }

    public void setButtonsPosition(ButtonsPosition buttonsPosition) {
        this.buttonsPosition = buttonsPosition;
    }

    public  void setTableWrapper(TableWrapper tableWrapper){};

}
