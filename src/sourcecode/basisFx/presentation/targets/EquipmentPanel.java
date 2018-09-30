package basisFx.presentation.targets;

import basisFx.appCore.SingleTableMediator;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.DynamicElements;

public class EquipmentPanel extends DynamicElements {


    @Override
    public void init() {

        TableWrapper tableWrapper = TableWrapper.newBuilder()
//                .setActiveRecord()
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new SingleTableMediator())
                .setName("111111111111111")
                .build();


        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig(tableWrapper))
                .setColumnVsPercent(139)
                .setColumnVsPercent(200)
                .setName("444")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(10d,10d,10d,10d))
                .setGridLinesVisibility(true)
                .build();




    }
}
