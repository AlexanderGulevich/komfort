package basisFx.presentation.targets;

import basisFx.appCore.SingleTableMediator;
import basisFx.appCore.TwoLinkedTablesMediator;
import basisFx.appCore.controls.ColumnWrapper;
import basisFx.appCore.controls.KindOfColumn;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.presentation.DynamicElements;

public class EquipmentPanel extends DynamicElements {


    @Override
    protected void init() {

        TableWrapper.newBuilder()
//                .setActiveRecord()
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new SingleTableMediator())
                .setName("111111111111111")
                .setColumnWrappers(
                        ColumnWrapper.Bulder.create()
                                .setKindOfColumn(KindOfColumn.COMBOBOX)
                        .setColumnName("ghgh")
                        .setEditeble(false)
                        .setColumnSize(34)
                        .

                )



//        GridPaneWrapper.newBuilder()
//                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig())
//                .setColumnVsPercent();


    }
}
