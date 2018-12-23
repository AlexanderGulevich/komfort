package basisFx.presentation.targets;

import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridBig;
import basisFx.service.ServiceSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;
import basisFx.presentation.TargetPanel;

public class EquipmentPanel extends TargetPanel {


    @Override
    public void init() {

        ServiceSingleTable mediatorSingleTable = new ServiceSingleTable();

        TableWrapper tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Equipment.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorSingleTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("metaName")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridSingleTable(tableWrapper,new ButtonsSizeForGridBig(),new ButPositionTop()))
                .setGridName("Оборудование")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();

    }
}
