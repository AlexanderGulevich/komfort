package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import javafx.geometry.Insets;

import javax.swing.text.TabableView;

public abstract class GridOrganization {

    protected Insets insets = new Insets(3, 3, 3, 3);
    protected GridPaneWrapper parentGridWrapper;
    protected ButtonFactory buttonFactory = ButtonFactory.getInstance();

    public abstract void organize();

    public GridOrganizationButtonTopRightLittleSingleTable setInsets(Insets insets) {
        this.insets = insets;
        return null;
    }
    public void setParentGridPaneWrapper(GridPaneWrapper gridPaneWrapper) {
        this.parentGridWrapper = gridPaneWrapper;
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



}
