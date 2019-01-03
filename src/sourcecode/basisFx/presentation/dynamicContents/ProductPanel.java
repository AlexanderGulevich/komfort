package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.ButPositionTop;
import basisFx.appCore.grid.ButtonsSizeForGridLittle;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.GridSingleTable;
import basisFx.appCore.grid.GridTwoBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperBool;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.table.ColumnWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.ProductPrice;
import basisFx.domain.Product;
import basisFx.presentation.DynamicContentPanel;

public class ProductPanel  extends DynamicContentPanel {

    private boolean gridVisibility=false;
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();

    @Override
    public void customeInit() {

        TableWrapper leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Список продукции ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setActiveRecordClass(Product.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
                .setColumnWrappers(
                        ColumnWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("metaName")
                                .build(),
                        ColumnWrapperBool.newBuilder()
                                .setColumnName("Втулка")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("havingSleeve")
                                .build()
                        )
                .build();

        TableWrapper rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setGridOrganization(new GridSingleTable(new ButtonsSizeForGridLittle(),new ButPositionTop()))
                .setActiveRecordClass(ProductPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediatorServiceTwoLinkedTable)
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


        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setGridName("Управление продуктами и динамика цен")
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
