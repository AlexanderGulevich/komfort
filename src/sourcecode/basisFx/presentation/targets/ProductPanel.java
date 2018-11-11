package basisFx.presentation.targets;

import basisFx.appCore.grid.ButtonsForGridLittle;
import basisFx.appCore.mediators.MediatorTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridOrgTopButSingleTable;
import basisFx.appCore.grid.GridOrgTwoBondGrids;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperBool;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.ProductPrice;
import basisFx.domain.Product;
import basisFx.presentation.TargetPanel;

public class ProductPanel  extends TargetPanel {

    private boolean gridVisibility=false;
    private MediatorTwoLinkedTable mediatorTwoLinkedTable =new MediatorTwoLinkedTable();
    private GridOrgTwoBondGrids gridOrganization =new GridOrgTwoBondGrids();

    @Override
    public void init() {

        TableWrapper productTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(Product.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColumnWrapperBool.newBuilder()
                                .setColumnName("Втулка")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("havingSleeve")
                                .build()
                        )
                .build();

        GridPaneWrapper productGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Список продукции ")
                .setGridOrganization(new GridOrgTopButSingleTable(productTableWrapper,new ButtonsForGridLittle()))
                .build();

        TableWrapper priceTableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(ProductPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setMediator(mediatorTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startingDate")
                                .build()
                )
                .build();

        GridPaneWrapper priceGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setGridLinesVisibility(gridVisibility)
                .setName("Архив цен")
                .setGridOrganization(new GridOrgTopButSingleTable(priceTableWrapper,new ButtonsForGridLittle()))
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setName("Управление продуктами и динамика цен")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setGridOrganization(gridOrganization.setGridWrappers(productGridPaneWrapper,priceGridPaneWrapper))
                .build();


        mediatorTwoLinkedTable.setAccessoryTableWrapper(priceTableWrapper);
        mediatorTwoLinkedTable.setPrimaryTableWrapper(productTableWrapper);
        mediatorTwoLinkedTable.initElements();
    }


}
