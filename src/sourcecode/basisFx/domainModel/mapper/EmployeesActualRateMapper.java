package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.EmployeesRatePerHour;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.targets.EmployeesActualRatePanel;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.HashMap;

public class EmployeesActualRateMapper extends DataMapper {
    private static EmployeesActualRateMapper ourInstance = new EmployeesActualRateMapper();

    public static EmployeesActualRateMapper getInstance() {
        return ourInstance;
    }
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        return false;
    }
    @Override
    public void getDomainList(ObservableList list) {

        try {
            String expression=
                    "select EMPLOYERID, STARTDATE, RATE "+
                    " from RATESTORE where " +
                     "(EMPLOYERID, STARTDATE) " +
                     " in " +
                     " (select EMPLOYERID, max(STARTDATE) " +
                            "as date from RATESTORE group by EMPLOYERID) ";

            Statement stmt  = Db.getConnection().createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            HashMap<Integer, DomainObject> employerHm = dataMapperFabric.employerMapper().toHashMapByCommonRawId();

            while (rs.next()) {
                int employerid=rs.getInt("EMPLOYERID");
                Employer domainObject = (Employer) employerHm.get(employerid);
                domainObject.setRate(new ComboBoxValue(Double.toString(rs.getDouble("RATE"))));
                domainObject.setStartingRateDate(rs.getDate("STARTDATE").toLocalDate());
                list.add(domainObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject){}
    @Override
    public void updateDomainObject(DomainObject d) {}
    @Override
    public void deleteDomainObject(DomainObject d) {}
    @Override
    public void insertDomainObject(DomainObject d) {}
}
