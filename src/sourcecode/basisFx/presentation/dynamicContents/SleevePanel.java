package basisFx.presentation.dynamicContents;


import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTwoLinkedTable;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDate;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;

public class SleevePanel  extends DynamicContentPanel {
    private ServiceTwoLinkedTable mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTwoLinkedTable();
    }

    @Override
    public void customDynamicElementsInit() {

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Втулка ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
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


          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new ButPosTop()))
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
                                .setPropertyName("price")
                                .build(),
                        ColumnWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.7d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();


        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setGridName("Поставщики втулок и цены")
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
