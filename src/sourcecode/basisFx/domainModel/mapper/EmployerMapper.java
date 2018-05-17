package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployerMapper extends DataMapper {

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
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));

                RatePerHour rate=getNewest(rs.getInt("id"));

                if (rate != null) {

                    pojo.setStartingRateDate(rate.getStartingDate());

                    pojo.setRate(rate);
                }



                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

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
                pstmt.setBoolean(2, true);
                pstmt.setInt(3, employer.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Employer domainObject=(Employer) d;

        if(isReadyToTransaction(d)) {

                String expression = "INSERT INTO " + "Employer "
                        + "("
                        + " name ,  "
                        + " isFired "
                        + "         "
                        + ") VALUES(?,?,)";

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
