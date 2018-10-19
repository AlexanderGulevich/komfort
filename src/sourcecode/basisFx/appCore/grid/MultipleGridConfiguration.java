package basisFx.appCore.grid;

public abstract class MultipleGridConfiguration {
    GridPaneWrapper mainGridWrapper;

    public void setMainGridPaneWrapper(GridPaneWrapper gridPaneWrapper) {
        this.mainGridWrapper = gridPaneWrapper;
    }
    public abstract void init();

}
