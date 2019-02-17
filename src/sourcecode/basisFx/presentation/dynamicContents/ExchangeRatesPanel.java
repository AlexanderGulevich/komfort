package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.grid.*;
import basisFx.appCore.utils.Range;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.table.ColWrapperString;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Currency;
import basisFx.domain.ExchangeRates;
import basisFx.presentation.DynamicContentPanel;
import javafx.scene.control.ComboBox;

public class ExchangeRatesPanel extends DynamicContentPanel {

    private ServiceTablesTwoLinked mediator;
    private TableWrapper leftTableWrapper;
    private TableWrapper rightTableWrapper;
    private RangeDirector rangeDirector;

    @Override
    public void createServices() {
        mediator =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {
        rangeDirector=new RangeDirector(new ComboBox<>(), mediator, Range.LAST10,Range.getAll());

        leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Валюта ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Currency.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperString.newBuilder()
                                .setColumnName("Наименование")
                                .setColumnSize(1d)
                                .setIsEditeble(true)
                                .setPropertyName("name")
                                .build())
                .build();


        rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Курсы валют")
                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
                .setActiveRecordClass(ExchangeRates.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Курс")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("rate")
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
                .setColumnVsPercent(70)
                .setColumnVsPercent(30)
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
        mediator.setAccessoryTableWrapper(rightTableWrapper);
        mediator.setPrimaryTableWrapper(leftTableWrapper);;
        mediator.setRangeDirector(rangeDirector);
        mediator.initElements();
    }


}
