package basisFx.presentation.targets;

import basisFx.appCore.SingleTableMediator;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.ButtonNon;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;
import basisFx.presentation.TargetPanel;

import java.lang.reflect.Method;

public class EquipmentPanel extends TargetPanel {


    @Override
    public void init() {

        System.err.println("EquipmentPanel.init".toUpperCase());

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Equipment.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new SingleTableMediator())
                .setColumnWrappers()
                .build();


        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig(tableWrapper))
                .setColumnVsPercent(80)
                .setColumnVsPercent(20)
                .setName("Gsggsdg Пвави ваваацуци")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(10d,10d,10d,10d))
                .setGridLinesVisibility(false)
                .build();




    }
}
