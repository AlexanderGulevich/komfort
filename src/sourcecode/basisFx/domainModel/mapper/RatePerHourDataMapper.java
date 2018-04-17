package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatePerHourDataMapper extends DataMapper{
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        RatePerHour ratePerHour = (RatePerHour) d;

        if (
                ratePerHour.getRate()!= null
                        && ratePerHour.getStartingRateDate() !=null

                ) {
            System.out.println("!!!!!!!!!!!!!!RatePerHourDataMapper --- объект готов к транзакции");

            return true;
        }
        System.out.println("!!!!!!!!!!!!!!RatePerHourDataMapper --- объект НЕ  готов к транзакции");
        System.out.println("!!!!!!!!!!!!!!getStartingRateDate --- объект НЕ  готов к транзакции---"+ratePerHour.getStartingRateDate());
        System.out.println("!!!!!!!!!!!!!!getStringValue --- объект НЕ  готов к транзакции---"+ratePerHour.getRate());

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

        int id=selectedDomainObject.getId();


        try {


        String expression="SELECT * FROM " +"RateStore "+" where employerId= " +id+" ORDER BY startDate";

        Statement stmt  = Db.getConnection().createStatement();

        ResultSet rs    = stmt.executeQuery(expression);


        while (rs.next()) {


            RatePerHour pojo=new RatePerHour();
            pojo.setId(rs.getInt("id"));


            StringValueDomainObject rate =new StringValueDomainObject();
            rate.setStringValue(Double.toString(rs.getDouble("rate")));

            pojo.setEmployerId(rs.getInt("employerId"));
            pojo.setRate(rate);
            pojo.setStartingRateDate(rs.getDate("startDate").toLocalDate());


            //вставляю id в список хранимых в бд
            this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

            list.add(pojo);

        }

    } catch (SQLException ex) {
        Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
    }



    }

    @Override
    public void updateDomainObject(DomainObject d) {
        if(isReadyToTransaction(d)) {


            RatePerHour ratePerHour= (RatePerHour) d;
            String expression = "UPDATE "+    "RateStore"+ " SET  " +
                    " rate = ?," +
                    " startDate = ?," +
                    " employerId = ? ";

            PreparedStatement pstmt = null;

            try {
                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(ratePerHour.getStringValue()));
                pstmt.setDate(2, Date.valueOf(ratePerHour.getStartingRateDate()));
                pstmt.setInt(3, ratePerHour.getEmployerId());
                pstmt.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {
        RatePerHour domainObject=(RatePerHour) d;

        if(isReadyToTransaction(d)) {


            try {
                String expression = "INSERT INTO " + "RateStore "
                        + "("
                        + " rate ,  "
                        + " startDate,  "
                        + " employerId        "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(domainObject.getRate().getStringValue()));
                pstmt.setDate(2, Date.valueOf(domainObject.getStartingRateDate()));
                pstmt.setInt(3, getObservableDomaineId());

                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
