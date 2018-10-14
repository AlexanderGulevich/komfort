package basisFx.presentation.targets;

import basisFx.appCore.MdiatorSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;
import basisFx.presentation.TargetPanel;

public class EquipmentPanel extends TargetPanel {


    @Override
    public void init() {

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Equipment.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new MdiatorSingleTable())
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build()

                )
                .build();


        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig(tableWrapper))
                .setColumnVsPercent(80)
                .setColumnVsPercent(20)
                .setName("Оборудование")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();




    }
}
