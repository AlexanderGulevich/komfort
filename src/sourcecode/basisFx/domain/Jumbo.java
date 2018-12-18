package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jumbo extends ActiveRecord {

    private static Jumbo INSTANCE = new Jumbo();
    private SimpleObjectProperty<Integer> width = new SimpleObjectProperty<>(this, "width", null);
    private SimpleObjectProperty<Integer> numberOfProduct = new SimpleObjectProperty<>(this, "numberOfProduct", null);

    public static Jumbo getINSTANCE() {
        return INSTANCE;
    }

    public Integer getWidth() {
        return width.get();
    }

    public SimpleObjectProperty<Integer> widthProperty() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width.set(width);
    }

    public Integer getNumberOfProduct() {
        return numberOfProduct.get();
    }

    public SimpleObjectProperty<Integer> numberOfProductProperty() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(Integer numberOfProduct) {
        this.numberOfProduct.set(numberOfProduct);
    }


    @Override
    public String toString() {
        if (getWidth() != null) {

            return String.valueOf(getWidth());
        }
        return null;
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " width ,  "
                    + " numberOfProduct "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getWidth());
            pstmt.setInt(2, getNumberOfProduct());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {

        return null;

    }
}