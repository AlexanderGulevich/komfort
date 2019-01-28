package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.*;
import basisFx.appCore.table.ColWrapperDate;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesTwoLinked;

public class EmployeesRate extends DynamicContentPanel {

    private ServiceTablesTwoLinked mediator;
    private TableWrapper leftTableWrapper;
    private TableWrapper rightTableWrapper;
    private RangeDirector rangeDirector;

    @Override
    public void createServices() {
        mediator = new ServiceTablesTwoLinked();
    }

    @Override
    public void customDynamicElementsInit() {

        rightTableWrapper = TableWrapper.newBuilder()
                .setGridName("Цены")
                 .setActiveRecordClass(LabelPrice.class)
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




         GridPaneWrapper.newBuilder()
                .setGridName("Управление валютами и динамика курсов")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setOrganization(new SingleTable(new ButSizeLittle(), new CtrlPosButAndCombobox(rangeDirector.getComboBox())))
                .setCoordinate(new Coordinate(0d, 10d, 10d, 0d))
                .setGridLinesVisibility(gridVisibility)
                .setOrganization(new TwoHorisontalBondGrids(leftTableWrapper, rightTableWrapper))
                .build();


    }

    @Override
    public void initServices() {
        mediator.setAccessoryTableWrapper(rightTableWrapper);
        mediator.setPrimaryTableWrapper(leftTableWrapper);
        mediator.setRangeDirector(rangeDirector);
        mediator.initElements();

    }
}
