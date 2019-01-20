package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.PaperPrice;
import basisFx.domain.Sleeve;

public class PaperPanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Бумага ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Sleeve.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build()
                )
                .build();


          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Архив цен ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(PaperPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("rate")
                                .build(),
                        ColWrapperDate.newBuilder()
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
                .setGridName("Поставщики бумаги и цены")
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
