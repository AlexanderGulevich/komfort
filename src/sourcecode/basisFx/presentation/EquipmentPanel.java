package basisFx.presentation;

import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeBig;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;

public class EquipmentPanel extends DynamicContentPanel {
    private ServiceTablesSingle mediatorSingleTable;
    private TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

         tableWrapper = TableWrapper.newBuilder()
                 .setActiveRecordClass(Equipment.class)
                 .setUnitOfWork(unitOfWork)
                 .setIsEditable(true)
                 .setCssClasses(CSSclasses.TABLE_BFx)
                 .setIsSortableColums(false)
                 .setServiceTables(mediatorSingleTable)
                 .setColWrappers(
                         ColWrapperString.newBuilder()
                                 .setColumnName("Наименование")
                                 .setColumnSize(1d)
                                 .setIsEditeble(true)
                                 .setPropertyName("name")
                                 .build()
                 ).build();


        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeBig(),new CtrlPosTop()))
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
