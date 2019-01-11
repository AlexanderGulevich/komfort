package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class ProductPrice extends ActiveRecord{

    private static ProductPrice INSTANCE = new ProductPrice();
    private SimpleObjectProperty<Double> price =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);

    public static ProductPrice getINSTANCE() {
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

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
    }


    @Override
    public String toString() {
        return getPrice().toString();
    }


    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM " +this.entityName+" where productId= " +id+" ORDER BY startDate desc";
        try{
        Statement stmt  = Db.connection.createStatement();
        ResultSet rs    = stmt.executeQuery(expression);
        while (rs.next()) {
            ProductPrice pojo=new ProductPrice();
            pojo.setId(rs.getInt("id"));
            pojo.setPrice(rs.getDouble("price"));
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
