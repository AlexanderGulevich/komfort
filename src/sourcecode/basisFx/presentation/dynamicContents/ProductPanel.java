package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.table.*;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColWrapperBool;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.ProductPrice;
import basisFx.domain.Product;
import basisFx.presentation.DynamicContentPanel;

public class ProductPanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper;
    private TableWrapper rightTableWrapper;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Список продукции ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Product.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColWrapperBool.newBuilder()
                                .setColumnName("Втулка")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("havingSleeve")
                                .build()
                        )
                .build();

          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(ProductPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
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
                .setOrganization(
                        new TwoHorisontalBondGrids(
                                leftTableWrapper.getGridPaneWrapper(),
                                rightTableWrapper.getGridPaneWrapper()
                        )
                )
                .build();



    }

    @Override
    public void initServices() {
        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();
    }


}
