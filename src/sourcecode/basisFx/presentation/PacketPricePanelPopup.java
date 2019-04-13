package basisFx.presentation;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.PacketPrice;
import basisFx.appCore.DynamicContentPanel;
import basisFx.service.ServiceTablesSingle;

public class PacketPricePanelPopup extends DynamicContentPanel {

    private ServiceTablesSingle mediator;
    private TableWrapper tableWrapper;
    @Override
    public void createServices() {
        mediator = new ServiceTablesSingle();
    }

    @Override
    public void customDynamicElementsInit() {

        tableWrapper  = TableWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setGridName("Реестр цен")
                .setOrganization(new SingleTable(new ButSizeNon(),new CtrlPosNON()))
                .setActiveRecordClass(PacketPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Тариф")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();



        GridPaneWrapper.newBuilder()
                .setGridName("Архив тарифных ставок")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 0d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(
                        new SingleTable(
                                window,
                                tableWrapper,
                                new ButSizeBig(),
                                new CtrlPosTop()
                        ) )
                .build();

        window.setNodeToMap(tableWrapper,"tableWrapper");

    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(tableWrapper);
        mediator.initElements();
    }
}
