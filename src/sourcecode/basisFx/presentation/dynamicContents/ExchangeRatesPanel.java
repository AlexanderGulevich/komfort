package basisFx.presentation.dynamicContents;

import basisFx.appCore.grid.CtrlPosTop;
import basisFx.appCore.grid.ButSizeLittle;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.TwoHorisontalBondGrids;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.DynamicContentPanel;

public class ExchangeRatesPanel extends DynamicContentPanel {

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
                .setGridName("Валюта ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Currency.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build())
                .build();


        rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Курсы ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Курс")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("exchangeRate")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Дата")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(60)
                .setColumnVsPercent(40)
                .setGridName("Управление валютами и динамика курсов")
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
