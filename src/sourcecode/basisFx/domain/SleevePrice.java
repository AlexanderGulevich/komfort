package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class SleevePrice extends ActiveRecord {

    private static SleevePrice INSTANCE = new SleevePrice();
    private SimpleObjectProperty<Double> price = new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>(this, "startDate", null);

    public static SleevePrice getINSTANCE() {
        return INSTANCE;
    }

    public Double getPrice() {
        return price.get();
    }

    public SimpleObjectProperty<Double> priceProperty() {
        return price;
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    @Override
    public String toString() {
        return getPrice().toString();
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        ObservableList<ActiveRecord> list = createNewActiveRecordList();
        String expression = "SELECT * FROM " + this.entityName + " where sleeveId= " + id + " ORDER BY startDate desc";
        try {
            Statement stmt = Db.connection.createStatement();
            ResultSet rs = stmt.executeQuery(expression);
            while (rs.next()) {
                SleevePrice pojo = new SleevePrice();
                pojo.setId(rs.getInt("id"));
                pojo.setPrice(rs.getDouble("price"));
                pojo.setStartDate(rs.getDate("startDate").toLocalDate());
                list.add(pojo);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
