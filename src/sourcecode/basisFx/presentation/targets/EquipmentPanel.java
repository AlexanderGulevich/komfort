package basisFx.presentation.targets;

import basisFx.appCore.SingleTableMediator;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtonNon;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.TargetPanel;

public class EquipmentPanel extends TargetPanel {


    @Override
    public void init() {


        System.err.println("EquipmentPanel.init".toUpperCase());

        TableWrapper tableWrapper = TableWrapper.newBuilder()
//                .setActiveRecord()
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new SingleTableMediator())
                .setName("111111111111111")
                .build();


        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtonNon(tableWrapper))
                .setColumnVsPercent(139)
                .setColumnVsPercent(200)
                .setName("444")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(10d,10d,10d,10d))
                .setGridLinesVisibility(false)
                .build();




    }
}
