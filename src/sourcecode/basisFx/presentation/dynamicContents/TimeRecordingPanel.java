package basisFx.presentation.dynamicContents;

import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.LabelWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.grid.CtrlPosNON;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.grid.ButSizeNon;
import basisFx.appCore.grid.SingleTable;
import basisFx.appCore.interfaces.DataStoreCallBack;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.table.ColWrapperComboBox;
import basisFx.appCore.table.ColWrapperDouble;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.utils.Registry;
import basisFx.dataSource.Db;
import basisFx.domain.*;
import basisFx.presentation.DynamicContentPanel;
import basisFx.service.ServiceTablesAutoCommitByDate;
import javafx.geometry.Pos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TimeRecordingPanel extends DynamicContentPanel {

    private ServiceTablesAutoCommitByDate mediator;
    private DatePickerWrapper datePickerWrapper ;
    private TableWrapper tableWrapper;
    private LabelWrapper label;
    private DataStoreCallBack callBackForColumn;

    @Override
    public void createServices() {
        mediator = new ServiceTablesAutoCommitByDate();
    }

    @Override
    public void customDynamicElementsInit() {


         callBackForColumn = new DataStoreCallBack() {
            @Override
            public boolean check(ActiveRecord activeRecord) {
                TimeRecordingForEmployers entry = (TimeRecordingForEmployers) activeRecord;
                LocalDate date = entry.getDate();
                Integer employerId = entry.getEmployer().getId();

                String expression="SELECT * FROM EmployeesRatePerHour " +
                        "WHERE EMPLOYERID=?" +
                        " and " +
                        " STARTDATE<=?";

                try {
                    PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                    pstmt.setInt(1, employerId);
                    pstmt.setDate(2, Date.valueOf(date));
                    ResultSet rs = pstmt.executeQuery();

                    if (!rs.next()) {
                        Registry.windowFabric.infoWindow("К сожалению, для данной даты не установлен тариф для следующего сотрудника: \n"
                        + entry.getEmployer().getName().toUpperCase().trim()) ;

                        return false;
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return true;
            }
        };

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
        mediator.setDataStoreCallBack(callBackForColumn);
        mediator.initElements();
    }
}
