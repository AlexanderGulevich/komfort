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
    public void update() {
        String expression = "UPDATE "+this.entityName+ " SET  " +
                " rate = ?," +
                " startDate = ?," +
                " employerId = ? " +
                " where id =?";

        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord -> ((EmployeesRatePerHour) activeRecord).getStartingDate(),
                getStartingDate());

        try {
            if (!check) {
                PreparedStatement pstmt = null;
                pstmt = Db.connection.prepareStatement(expression);
                pstmt.setDouble(1, getRate());
                pstmt.setDate(2, Date.valueOf(getStartingDate()));
                pstmt.setInt(3, outerId);
                pstmt.setInt(4, id.get());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void insert() {
        String expression = "INSERT INTO " +this.entityName+ "("
                + " rate ,  "
                + " startDate,  "
                + " employerId        "
                + ") VALUES(?,?,?)";
        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord -> ((EmployeesRatePerHour) activeRecord).getStartingDate(),
                getStartingDate());

        PreparedStatement pstmt;
        if (check) {
            try {
                pstmt = Db.connection.prepareStatement(expression);
                pstmt.setDouble(1, getRate());
                pstmt.setDate(2, Date.valueOf(getStartingDate()));
                pstmt.setInt(3, outerId);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

