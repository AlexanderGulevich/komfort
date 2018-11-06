package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employer extends ActiveRecord {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", false);
    private SimpleObjectProperty<Double> rate =new SimpleObjectProperty<>(this, "actualRate", null);

    public String getName() {
        return name.get();
    }
    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public Boolean getIsFired() {
        return isFired.get();
    }

    public SimpleObjectProperty<Boolean> isFiredProperty() {
        return isFired;
    }

    public void setIsFired(Boolean isFired) {
        this.isFired.set(isFired);
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

    public Employer() {
        super("Employer");
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {

        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        String expression=
                "SELECT  r.employerId, r.rate, r.startDate, e.name, e.isFired"+
                        " from  employer as e,"+
                        " (select * from ratePerHourHistory where (employerId, startDate)"+
                        " in (select employerId, max(startDate) from  ratePerHourHistory group by employerId)) as r"+
                        " where r.employerId=e.id and e.isFired = false"+
                        "ORDER BY r.employerId";

        //todo  create union
        try {
            Statement stmt  = Db.connection.createStatement();;
            ResultSet rs = stmt.executeQuery(expression);
            while (rs.next()) {
                Employer pojo=new Employer();
                pojo.setId(rs.getInt("employerId"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));
                pojo.setRate(rs.getDouble("rate"));

                list.add(pojo);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return list;
    }

    @Override
    public void update() {
//            String expression = "UPDATE "+    "Employer"+ " SET  " +
//                    " name = ?," +
//                    " isFired = ?" +
//                    " WHERE id= ?" ;
//
//            try {
//                PreparedStatement pstmt = null;
//
//                pstmt = Db.getConnection().prepareStatement(expression);
//                pstmt.setName(1, employer.getName());
//                pstmt.setBoolean(2, employer.getIsFired());
//                pstmt.setInt(3, employer.getId());
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void insert() {
//
//
//                String expression = "INSERT INTO " + "Employer "
//                        + "("
//                        + " name ,  "
//                        + " isFired "
//                        + ") VALUES(?,?)";
//
//            try {
//                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                pstmt.setName(1, domainObject.getName());
//                pstmt.setBoolean(2, domainObject.getIsFired());
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }

}
