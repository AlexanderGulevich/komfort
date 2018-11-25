package basisFx.presentation.targets;


import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridOrgTwoBondGrids;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.TargetPanel;

public class SleevePanel  extends TargetPanel {
    private boolean gridVisibility=false;
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();
    private GridOrgTwoBondGrids gridOrganization =new GridOrgTwoBondGrids();

    @Override
    public void init() {

        TableWrapper labelTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Sleeve.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();

        GridPaneWrapper labelGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Втулка")
                .setGridOrganization(new GridOrgTopButSingleTable(labelTableWrapper,new ButtonsForGridLittle()))
                .build();

        TableWrapper labelPriceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(SleevePrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("rate")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper labelPriceGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Архив цен")
                .setGridOrganization(new GridOrgTopButSingleTable(labelPriceTableWrapper,new ButtonsForGridLittle()))
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Поставщики втулок и цены")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGridWrappers(labelGridPaneWrapper,labelPriceGridPaneWrapper))
                .build();


        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(labelPriceTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(labelTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();
    }



}
