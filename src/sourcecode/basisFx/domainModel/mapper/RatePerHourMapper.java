package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatePerHourMapper extends DataMapper{
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        RatePerHour ratePerHour = (RatePerHour) d;

        if (
                ratePerHour.getRate()!= null
                        && ratePerHour.getStartingDate() !=null

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

                RatePerHour pojo=new RatePerHour();

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
                System.out.println("RatePerHourMapper.updateDomainObject".toUpperCase());

                RatePerHour ratePerHour= (RatePerHour) d;
                String expression = "UPDATE "+    "RateStore"+ " SET  " +
                        " rate = ?," +
                        " startDate = ?," +
                        " employerId = ? " +
                        " where id =?";

                PreparedStatement pstmt = null;

                    pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setDouble(1, Double.valueOf(ratePerHour.getRate().getStringValue()));
                    pstmt.setDate(2, Date.valueOf(ratePerHour.getStartingDate()));
                    pstmt.setInt(3, ratePerHour.getEmployerId());
                    pstmt.setInt(4, ratePerHour.getId());
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
        RatePerHour domainObject=(RatePerHour) d;

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
