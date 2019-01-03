package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridLittle;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.grid.GridTwoBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.PaperPrice;
import basisFx.domain.Sleeve;

public class PaperPanel  extends DynamicContentPanel {
    private boolean gridVisibility=false;
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();

    @Override
    public void customeInit() {

        TableWrapper leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Бумага ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
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


        TableWrapper rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setActiveRecordClass(PaperPrice.class)
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

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setGridName("Поставщики бумаги и цены")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(
                        new GridTwoBondGrids(
                                leftTableWrapper.getGridPaneWrapper(),
                                rightTableWrapper.getGridPaneWrapper()
                        )
                )
                .build();


        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();
    }

}
