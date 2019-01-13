package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceSingleTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;

public class EquipmentPanel extends DynamicContentPanel {
    private ServiceSingleTable mediatorSingleTable;
    private TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceSingleTable();
    }

    @Override
    public void customDynamicElementsInit() {

         tableWrapper = TableWrapper.newBuilder()
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
                                .setPropertyName("name")
                                .build()
                ).build();


        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new ButPosTop()))
                .setGridName("Оборудование")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

    }

    @Override
    public void initServices() {
        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }

}
