package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.EmployeesRatePerHour;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployeesRateMapper extends DataMapper{


    private static EmployeesRateMapper ourInstance = new EmployeesRateMapper();

    public static EmployeesRateMapper getInstance() {
        return ourInstance;
    }


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        EmployeesRatePerHour employeesRatePerHour = (EmployeesRatePerHour) d;

        if (
                employeesRatePerHour.getRate()!= null
                        && employeesRatePerHour.getStartingDate() !=null

                ) {

            return true;
        }

        return false;
    }


    @Override
    public void getDomainList(ObservableList list) {

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject)   {

        try {
            int selectedDomainObjectId=selectedDomainObject.getId();

            String expression="SELECT * FROM " +"RateStore "+" where employerId= " +selectedDomainObjectId+" ORDER BY startDate desc";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                EmployeesRatePerHour pojo=new EmployeesRatePerHour();

                int id=rs.getInt("id");
                pojo.setId(id);


                pojo.setEmployerId(rs.getInt("employerId"));
                pojo.setRate(new ComboBoxValue(Double.toString(rs.getDouble("rate"))));
                pojo.setStartingRateDate(rs.getDate("startDate").toLocalDate());

                setStoredId(id);

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateDomainObject(DomainObject d)   {
        try {
            if(isReadyToTransaction(d)) {

                EmployeesRatePerHour employeesRatePerHour = (EmployeesRatePerHour) d;
                String expression = "UPDATE "+    "RateStore"+ " SET  " +
                        " rate = ?," +
                        " startDate = ?," +
                        " employerId = ? " +
                        " where id =?";

                PreparedStatement pstmt = null;

                    pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setDouble(1, Double.valueOf(employeesRatePerHour.getRate().getStringValue()));
                    pstmt.setDate(2, Date.valueOf(employeesRatePerHour.getStartingDate()));
                    pstmt.setInt(3, employeesRatePerHour.getEmployerId());
                    pstmt.setInt(4, employeesRatePerHour.getId());
                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d,"RateStore");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        EmployeesRatePerHour domainObject=(EmployeesRatePerHour) d;

        try {
            if(isReadyToTransaction(d)) {

                    String expression = "INSERT INTO " + "RateStore "
                            + "("
                            + " rate ,  "
                            + " startDate,  "
                            + " employerId        "
                            + ") VALUES(?,?,?)";

                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setDouble(1, Double.valueOf(domainObject.getRate().getStringValue()));
                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
                    pstmt.setInt(3, getObservableDomaineId());

                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
