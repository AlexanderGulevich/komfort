package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridBig;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;

public class EquipmentPanel extends DynamicContentPanel {


    @Override
    public void customeInit() {

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
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();

    }
}
