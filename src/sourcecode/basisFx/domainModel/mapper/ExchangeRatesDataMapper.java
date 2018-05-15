package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
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

            return true;
        }

        return false;
    }

    @Override
    public void getDomainList(ObservableList list) {

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) throws SQLException {
        int id=selectedDomainObject.getId();

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

    }

    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {
        if(isReadyToTransaction(d)) {


            ExchangeRates domaine= (ExchangeRates) d;
            String expression = "UPDATE "+    "ExchangeRates"+ " SET  " +
                    " rate = ?," +
                    " startDate = ?," +
                    " currencyId = ? " +
                    " where id =?";

            PreparedStatement pstmt = null;


                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(domaine.getExchangeRate()));
                pstmt.setDate(2, Date.valueOf(domaine.getStartingDate()));
                pstmt.setInt(3, domaine.getCurrencyId());
                pstmt.setInt(4, domaine.getId());

                pstmt.executeUpdate();

        }
    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {
        super.delete(d,"ExchangeRates ");
    }

    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {
        ExchangeRates domainObject=(ExchangeRates) d;

        if(isReadyToTransaction(d)) {

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

        }
    }
}
