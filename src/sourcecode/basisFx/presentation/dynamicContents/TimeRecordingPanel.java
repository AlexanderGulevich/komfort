package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.CtrlPosNON;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.ButSizeNon;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.domain.Employer;
import basisFx.domain.TimeRecordingForEmployers;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesAutoCommitByDate;
import javafx.geometry.Pos;

public class TimeRecordingPanel extends DynamicContentPanel {

    private ServiceTablesAutoCommitByDate mediator;
    private DatePickerWrapper datePickerWrapper ;
    private TableWrapper tableWrapper;
    private LabelWrapper label;

    @Override
    public void createServices() {
        mediator = new ServiceTablesAutoCommitByDate();
    }

    @Override
    public void customDynamicElementsInit() {

        datePickerWrapper = DatePickerWrapper.newBuilder()
                .setCoordinate(new Coordinate(10d, 15d, null, null))
                .setParentAnchor(dynamicContentAnchorHolder)
                .setServiceTables(mediator)
                .build();


        label =LabelWrapper.newBuilder()
                .setCssClasses(CSSclasses.LABEL_COMMON)
                .setText("Учет рабочего времени")
                .setParentAnchor(dynamicContentAnchorHolder)
                .setCoordinate(new Coordinate(0d, 300d, null, 10d))
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setAlignment(Pos.TOP_LEFT)
                .setFontSize(30d)
                .build();


          tableWrapper = TableWrapper.newBuilder()
                .setActiveRecordClass(TimeRecordingForEmployers.class)
                .setUnitOfWork(unitOfWork)
                .setIsEditable(true)
                .setIsSortableColums(false)
                .setServiceTables(mediator)
                .setColWrappers(
                        ColWrapperComboBox.newBuilder(Employer.class)
                                .setColumnName("Работник")
                                .setColumnSize(0.7d)
                                .setIsEditeble(false)
                                .setPropertyName("employer")
                                .build()
                                ,
                        ColWrapperDouble.newBuilder()
                                .setColumnName("Отработанные часы")
                                .setColumnSize(0.3d)
                                .setIsEditeble(true)
                                .setPropertyName("hours")
                                .build()
                )
                .build();


        GridPaneWrapper.newBuilder()
                .setOrganization(new SingleTable(tableWrapper,new ButSizeNon(),new CtrlPosNON()))
                .setGridName(null)
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
