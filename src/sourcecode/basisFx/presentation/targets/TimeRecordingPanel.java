package basisFx.presentation.targets;


import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.fabrics.ButtonFactory;
import basisFx.appCore.grid.GridOrgButtonNonSingleTable;
import basisFx.appCore.grid.GridPaneWrapper;
import basisFx.appCore.table.ColumnWrapperComboBox;
import basisFx.appCore.table.ColumnWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Employer;
import basisFx.domain.TimeRecordingForEmployers;
import basisFx.presentation.TargetPanel;
import basisFx.service.ServiceTableAndCommonDate;

public class TimeRecordingPanel extends TargetPanel {

    ServiceTableAndCommonDate mediator = new ServiceTableAndCommonDate(1);

    @Override
    public void init() {

        ButtonWrapper buttonWrapper = ButtonFactory.getInstance().submitButton(
                innerAnchorPane,
                new Coordinate(10d, 13d, null, null),
                mediator
        );


        DatePickerWrapper datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, null, null, 10d))
                .setParentAnchor(innerAnchorPane)
                .setServiceMediator(mediator)
                .build();


        TableWrapper tableWrapper = TableWrapper.newBuilder()
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
                                .build(),
                        ColumnWrapperDouble.newBuilder()
                                .setColumnName("Отработанные часы")
                                .setColumnSize(0.3d)
                                .setIsEditeble(false)
                                .setPropertyName("hours")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setGridOrganization(new GridOrgButtonNonSingleTable(tableWrapper))
                .setName("Учет рабочего времени")
                .setParentAnchor(innerAnchorPane)
                .setCoordinate(new Coordinate(50d,10d,10d,0d))
                .setGridLinesVisibility(false)
                .build();

        mediator.setTableWrapper(tableWrapper);
        mediator.setButtonWrapper(buttonWrapper);
        mediator.setDatePickerWrapper(datePickerWrapper);
        mediator.initElements();


    }
}
