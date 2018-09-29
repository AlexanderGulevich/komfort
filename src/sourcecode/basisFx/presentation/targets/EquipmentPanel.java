package basisFx.presentation.targets;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.presentation.DynamicElements;

public class EquipmentPanel extends DynamicElements {


    @Override
    protected void init() {

        TableWrapper.newBuilder()
                .setActiveRecord()
                .setColumnResizePolicy()
                .

        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig());

    }
}
