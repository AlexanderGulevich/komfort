package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Equipment;
import basisFx.domain.PacketSize;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class PacketSizePanel extends DynamicContentPanel {
    private ServiceTablesSingle mediatorSingleTable;
    private TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediatorSingleTable = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

         tableWrapper = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
//                .setOrganization(new SingleTable(new ButSizeNon(), new CtrlPosNON()))
                .setActiveRecordClass(PacketSize.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setGridName("")
                .setIsSortableColums(false)
                .setServiceTables(mediatorSingleTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Размер пакета")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("size")
                                .build()
                )
                .build();


        window.setNodeToMap(tableWrapper,"tableWrapper");


        GridPaneWrapper.newBuilder()
                .setGridName("")
                .setOrganization(new SingleTable(this.tableWrapper,new ButSizeBig(),new CtrlPosTop()))
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d,0d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

    }

    @Override
    public void initServices() {
        mediatorSingleTable.setTableWrapper(tableWrapper);
        mediatorSingleTable.initElements();
    }

}
