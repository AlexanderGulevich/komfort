package basisFx.presentation.dynamicContents;


import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.ButPosNotExist;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.ButSizeNon;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Employer;
import basisFx.domain.TimeRecordingForEmployers;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceAutoCommitTableByCommonDate;

public class TimeRecordingPanel extends DynamicContentPanel {

    private ServiceAutoCommitTableByCommonDate mediator;
    private DatePickerWrapper datePickerWrapper ;
    private TableWrapper tableWrapper;

    @Override
    public void createServices() {
        mediator = new ServiceAutoCommitTableByCommonDate();
    }

    @Override
    public void customDynamicElementsInit() {

          datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 5d))
                .setParentAnchor(dynamicContentAnchorHolder)
                .setServiceMediator(mediator)
                .build();


          tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(TimeRecordingForEmployers.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceMediator(mediator)
                .setColumnWrappers(
                        ColumnWrapperComboBox.newBuilder(Employer.class)
                                .setColumnName("Работник")
                                .setColumnSize(0.7d)
                                .setIsEditeble(false)
                                .setPropertyName("employer")
                                .build()
                                ,
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Отработанные часы")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("hours")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeNon(),new ButPosNotExist()))
                .setGridName("Учет рабочего времени")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(50d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();



    }

    @Override
    public void initServices() {
        mediator.setTableWrapper(tableWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();
    }
}
