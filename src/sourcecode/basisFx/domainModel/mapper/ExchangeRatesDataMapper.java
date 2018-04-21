package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.domainModel.domaine.ExchangeRates;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExchangeRatesDataMapper extends DataMapper{


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        ExchangeRates domain = (ExchangeRates) d;
        if (
                domain.getExchangeRate()!= null
                        && domain.getStartingDate() !=null
                ) {
            System.out.println("!!!!!!!!!!!!!!ExchangeRatesDataMapper --- объект готов к транзакции");

            return true;
        }
        System.out.println("!!!!!!!!!!!!!!ExchangeRatesDataMapper --- объект НЕ  готов к транзакции");

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {
        int id=selectedDomainObject.getId();

        try {

            String expression="SELECT * FROM " +"ExchangeRates "+" where currencyId= " +id+" ORDER BY startDate Desc";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {


                ExchangeRates pojo=new ExchangeRates();
                pojo.setId(rs.getInt("id"));
                pojo.setCurrencyId(rs.getInt("currencyId"));
                pojo.setExchangeRate(Double.toString(rs.getDouble("rate")));
                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());


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
            System.out.println("ExchangeRatesDataMapper.updateDomainObject".toUpperCase());

            ExchangeRates domaine= (ExchangeRates) d;
            String expression = "UPDATE "+    "ExchangeRates"+ " SET  " +
                    " rate = ?," +
                    " startDate = ?," +
                    " currencyId = ? " +
                    " where id =?";

            PreparedStatement pstmt = null;

            try {

                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(domaine.getExchangeRate()));
                pstmt.setDate(2, Date.valueOf(domaine.getStartingDate()));
                pstmt.setInt(3, domaine.getCurrencyId());
                pstmt.setInt(4, domaine.getId());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {
        ExchangeRates domainObject=(ExchangeRates) d;

        if(isReadyToTransaction(d)) {


            try {
                String expression = "INSERT INTO " + "ExchangeRates "
                        + "("
                        + " rate ,  "
                        + " startDate,  "
                        + " currencyId        "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(domainObject.getExchangeRate()));
                pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
                pstmt.setInt(3, getObservableDomaineId());

                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
