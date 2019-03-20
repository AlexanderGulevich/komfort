package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.utils.Range;
import basisFx.domain.Paper;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Counterparty;
import basisFx.domain.PaperPrice;
import javafx.scene.control.ComboBox;

public class PaperPanel  extends DynamicContentPanel {
    private ServiceTablesTwoLinked mediator;
    private TableWrapper leftTableWrapper ;
    private TableWrapper rightTableWrapper ;
    private RangeDirector rangeDirector;

    @Override
    public void createServices() {
        mediator =new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {
        rangeDirector=new RangeDirector(new ComboBox<>(), mediator, Range.LAST10,Range.getAll());

          leftTableWrapper = TableWrapper.newBuilder()
                .setGridName("Бумага ")
                .setOrganization(new SingleTable(new ButSizeLittle(),new CtrlPosTop()))
                .setActiveRecordClass(Paper.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
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
                .setGridName("Цены ")
                .setOrganization( new SingleTable(new ButSizeLittle(),new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
                .setActiveRecordClass(PaperPrice.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Цена")
                                .setColumnSize(0.4d)
                                .setIsEditeble(true)
                                .setPropertyName("price")
                                .build(),
                        ColWrapperDate.newBuilder()
                                .setColumnName("Действует с")
                                .setColumnSize(0.6d)
                                .setIsEditeble(true)
                                .setPropertyName("startDate")
                                .build()
                )
                .build();

        GridPaneWrapper commonGridPaneWrapper = GridPaneWrapper.newBuilder()
                .setColumnVsPercent(70)
                .setColumnVsPercent(30)
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
        mediator.setAccessoryTableWrapper(rightTableWrapper);
        mediator.setPrimaryTableWrapper(leftTableWrapper);;
        mediator.setRangeDirector(rangeDirector);
        mediator.initElements();
    }

}
