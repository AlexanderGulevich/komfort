package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Employer;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployerMapper extends DataMapper {


    private static EmployerMapper ourInstance = new EmployerMapper();

    public static EmployerMapper getInstance() {
        return ourInstance;
    }
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Employer employer= (Employer) d;
        if (employer.getName()!= null
             && employer.getIsFired()!= null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list)  {

        try {
            String expression="SELECT * FROM " +"Employer"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Employer pojo=new Employer();

                int id=rs.getInt("id");
                pojo.setId(id);

                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));
//todo newest stop run
//                EmployeesRatePerHour rate=getNewest(rs.getInt("id"));
//
//                if (rate != null) {
//
//                    pojo.setStartingRateDate(rate.getStartingDate());
//
//                    pojo.setRate(rate);
//                }

                setStoredId(id);

                list.add(pojo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {
    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        if(isReadyToTransaction(d)) {

            Employer employer= (Employer) d;
            String expression = "UPDATE "+    "Employer"+ " SET  " +
                    " name = ?," +
                    " isFired = ?" +
                    " WHERE id= ?" ;

            try {
                PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, employer.getName());
                pstmt.setBoolean(2, employer.getIsFired());
                pstmt.setInt(3, employer.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
      super.delete(d,"Employees");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Employer domainObject=(Employer) d;

        if(isReadyToTransaction(d)) {

                String expression = "INSERT INTO " + "Employer "
                        + "("
                        + " name ,  "
                        + " isFired "
                        + ") VALUES(?,?)";

            try {
                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());
                pstmt.setBoolean(2, domainObject.getIsFired());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }


}
