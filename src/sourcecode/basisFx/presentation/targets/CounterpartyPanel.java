package basisFx.presentation.targets;

import basisFx.appCore.MdiatorSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtomRightMiddleBig;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBoxVal;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.TargetPanel;

public class CounterpartyPanel extends TargetPanel {
    @Override
    public void init() {

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Counterparty.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(new MdiatorSingleTable())
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperComboBoxVal.newBuilder()
                        .setColumnName("Валюта ")
                        .setIsEditeble(true)
                        .setColumnSize(0.4d)
                        .setColumnName("currency")
                        .build()

                )
                .build();

        GridPaneWrapper.newBuilder()
                .setButtonKindConfigurationStrategy(new ButtomRightMiddleBig(tableWrapper))
                .setColumnVsPercent(80)
                .setColumnVsPercent(20)
                .setName("Список контрагентов")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

    }







}
