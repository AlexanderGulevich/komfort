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
    private SimpleObjectProperty<Double> width = new SimpleObjectProperty<>(this, "width", null);
    private SimpleObjectProperty<Integer> numberOfProduct = new SimpleObjectProperty<>(this, "numberOfProduct", null);

    public Jumbo() {
        super("Jumbo");
    }

    public static Jumbo getINSTANCE() {
        return INSTANCE;
    }


    public Double getWidth() {
        return width.get();
    }

    public SimpleObjectProperty<Double> widthProperty() {
        return width;
    }

    public void setWidth(Double width) {
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
    public ObservableList<ActiveRecord> getAll() {

        ObservableList<ActiveRecord> list = FXCollections.observableArrayList();
        String expression = "SELECT * FROM " + this.entityName + " ORDER BY ID";
        try {
            Statement stmt = Db.connection.createStatement();
            ResultSet rs = stmt.executeQuery(expression);
            while (rs.next()) {
                Jumbo pojo = new Jumbo();
                pojo.setId(rs.getInt("id"));
                pojo.setWidth(rs.getDouble("width"));
                pojo.setNumberOfProduct(rs.getInt("numberOfProduct"));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update() {
        try {
            String expression = "UPDATE " + this.entityName + " SET  " +
                    " width = ?," +
                    " numberOfProduct = ?" +
                    " WHERE id= ?";
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setDouble(1, getWidth());
            pstmt.setInt(2, getNumberOfProduct());
            pstmt.setInt(3, getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return getWidth().toString();
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
            pstmt.setDouble(1, getWidth());
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