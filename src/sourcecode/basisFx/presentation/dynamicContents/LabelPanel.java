package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.ColWrapperString;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.ExchangeRates;
import basisFx.domain.Label;
import basisFx.presentation.DynamicContentPanel;

public class LabelPanel  extends DynamicContentPanel {

    private ServiceTablesTwoLinked mediatorServiceTwoLinkedTable ;
    private  TableWrapper leftTableWrapper ;
    private  TableWrapper rightTableWrapper ;

    @Override
    public void createServices() {
        mediatorServiceTwoLinkedTable =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Этикетки")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Label.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediatorServiceTwoLinkedTable)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build(),
                        ColWrapperComboBox.newBuilder(Counterparty.class)
                                .setColumnName("Поставщик")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("counterparty")
                                .build())
                .build();


          rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Курсы")
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
                .setOrganization(new TwoHorisontalBondGrids(leftTableWrapper,rightTableWrapper))
                .build();




    }

    @Override
    public void initServices() {
        mediatorServiceTwoLinkedTable.setAccessoryTableWrapper(rightTableWrapper);
        mediatorServiceTwoLinkedTable.setPrimaryTableWrapper(leftTableWrapper);
        mediatorServiceTwoLinkedTable.initElements();

    }


}

