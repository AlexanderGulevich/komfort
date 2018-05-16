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

public class RatePerHourDataMapper extends DataMapper{
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

        int id=selectedDomainObject.getId();

        String expression="SELECT * FROM " +"RateStore "+" where employerId= " +id+" ORDER BY startDate desc";

        Statement stmt  = Db.getConnection().createStatement();

        ResultSet rs    = stmt.executeQuery(expression);


        while (rs.next()) {


            RatePerHour pojo=new RatePerHour();
            pojo.setId(rs.getInt("id"));


            ComboBoxValue rate =new ComboBoxValue();
            rate.setStringValue(Double.toString(rs.getDouble("rate")));

            pojo.setEmployerId(rs.getInt("employerId"));
            pojo.setRate(rate);
            pojo.setStartingRateDate(rs.getDate("startDate").toLocalDate());


            //вставляю id в список хранимых в бд
            this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

            list.add(pojo);

        }

    }

    @Override
    public void updateDomainObject(DomainObject d)   {
        if(isReadyToTransaction(d)) {
            System.out.println("RatePerHourDataMapper.updateDomainObject".toUpperCase());

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
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d,"RateStore");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        RatePerHour domainObject=(RatePerHour) d;

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
    }
}
