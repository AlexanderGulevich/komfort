package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class ProductPrice extends ActiveRecord{

    private static ProductPrice INSTANCE = new ProductPrice();
    private SimpleObjectProperty<String> price =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> productId =new SimpleObjectProperty<>(this, "productId", null);

    public static ProductPrice getINSTANCE() {
        return INSTANCE;
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleObjectProperty<String> priceProperty() {
        return price;
    }

    public void setPrice(String price) {
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

    public Integer getProductId() {
        return productId.get();
    }

    public SimpleObjectProperty<Integer> productIdProperty() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId.set(productId);
    }

    public ProductPrice() {
        super("ProductPrice");
    }


    @Override
    public ComboBoxValue toComboBoxValue() {
        return null;
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        return null;
    }

    @Override
    public void update() {
        String expression = "UPDATE "+    " ProductPriceStore"+ " SET  " +
                " price = ?," +
                " startDate = ?," +
                " productId = ? " +
                " where id =?";

        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord -> ((ExchangeRates) activeRecord).getStartingDate(),
                getStartingDate());

        try {
            if (!check) {
                PreparedStatement pstmt = null;
                pstmt = Db.connection.prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(price.get()));
                pstmt.setDate(2, Date.valueOf(startingDate.get()));
                pstmt.setInt(3, productId.get());
                pstmt.setInt(4, id.get());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public void insert() {
        String expression = "INSERT INTO " + " ProductPriceStore "
                + "("
                + " price ,  "
                + " startDate,  "
                + " productId        "
                + ") VALUES(?,?,?)";
        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord -> ((ExchangeRates) activeRecord).getStartingDate(),
                getStartingDate());
        try {
            if (!check) {
                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(price.get()));
                pstmt.setDate(2, Date.valueOf(startingDate.get()));
                pstmt.setInt(3, productId.get());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM " +" ProductPriceStore "+" where productId= " +id+" ORDER BY startDate desc";
        try{
        Statement stmt  = Db.connection.createStatement();
        ResultSet rs    = stmt.executeQuery(expression);
        while (rs.next()) {
            ProductPrice pojo=new ProductPrice();
            pojo.setId(rs.getInt("id"));
            pojo.setProductId(rs.getInt("productId"));
            pojo.setPrice( Double.toString(rs.getDouble("price")));
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
