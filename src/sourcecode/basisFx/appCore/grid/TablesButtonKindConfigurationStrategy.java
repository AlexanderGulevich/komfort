package basisFx.appCore.grid;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;

public abstract class TablesButtonKindConfigurationStrategy {

    protected TableWrapper tableWrapper;
    protected ButtonFactory buttonFactory =new ButtonFactory();

    public TablesButtonKindConfigurationStrategy(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public  abstract void organize(GridPaneWrapper gridPaneWrapper);


}
