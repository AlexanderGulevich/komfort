package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class EmployeesRatePerHour extends ActiveRecord {

    private static EmployeesRatePerHour INSTANCE = new EmployeesRatePerHour();
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Double> rate =new SimpleObjectProperty<>(this, "rate", null);

    public static EmployeesRatePerHour getINSTANCE() {
        return INSTANCE;
    }

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
    }

    public Double getRate() {
        return rate.get();
    }

    public SimpleObjectProperty<Double> rateProperty() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate.set(rate);
    }



    @Override
    public String toString() {
        return null;
    }


    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {

        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM " +this.entityName+" where employerId= " +id+" ORDER BY startDate desc";
        try{
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                EmployeesRatePerHour pojo=new EmployeesRatePerHour();
                pojo.setId(rs.getInt("id"));
                pojo.setRate( rs.getDouble("rate"));
                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());
                list.add(pojo);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    }

