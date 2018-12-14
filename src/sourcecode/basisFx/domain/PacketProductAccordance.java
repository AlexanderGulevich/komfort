package basisFx.domain;


import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacketProductAccordance extends ActiveRecord {

    private static PacketProductAccordance INSTANCE = new PacketProductAccordance();
    private SimpleObjectProperty<Product> product = new SimpleObjectProperty<>(this, "product", null);
    private SimpleObjectProperty<Integer> number = new SimpleObjectProperty<>(this, "number", null);

    public PacketProductAccordance() {
        super("PacketProductAccordance");
    }


    public static PacketProductAccordance getINSTANCE() {
        return INSTANCE;
    }

    public Product getProduct() {
        return product.get();
    }

    public SimpleObjectProperty<Product> productProperty() {
        return product;
    }

    public void setProduct(Product product) {
        this.product.set(product);
    }

    public Integer getNumber() {
        return number.get();
    }

    public SimpleObjectProperty<Integer> numberProperty() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number.set(number);
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {

        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +this.entityName+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                PacketProductAccordance pojo=new PacketProductAccordance();
                pojo.setId(rs.getInt("id"));
                pojo.setNumber(rs.getInt("number"));
                pojo.setProduct(Product.getINSTANCE().find(rs.getInt("productId")));
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
            String expression = "UPDATE "+    this.entityName+ " SET  " +
                    " number = ?," +
                    " productId = ?," +
                    " packetSizeId = ?" +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getNumber());
            pstmt.setInt(2, getProduct().id.get());
            pstmt.setInt(3, outerId);
            pstmt.setInt(4, id.get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActiveRecord find(int id) {

        PacketProductAccordance pojo=new PacketProductAccordance() ;
        String expression="SELECT * FROM " +this.entityName+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo.setId(rs.getInt("id"));
                pojo.setProduct(Product.getINSTANCE().find(rs.getInt("productId")));
                pojo.setNumber(rs.getInt("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pojo;

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " number ,  "
                    + " packetSizeId ,  "
                    + " productId "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getNumber());
            pstmt.setInt(2, outerId);
            pstmt.setInt(3, getProduct().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id){

    ObservableList<ActiveRecord> list = createNewActiveRecordList();
    String expression = "SELECT * FROM " + this.entityName + " where packetSizeId= " + id;
        try {
        Statement stmt = Db.connection.createStatement();
        ResultSet rs = stmt.executeQuery(expression);
        while (rs.next()) {
            PacketProductAccordance pojo = new PacketProductAccordance();
            pojo.setId(rs.getInt("id"));
            pojo.setNumber(rs.getInt("number"));
            pojo.setProduct(Product.getINSTANCE().find(rs.getInt("productId")));
            list.add(pojo);
        }
    } catch (
    SQLException e) {
        e.printStackTrace();
    }
        return list;

    }
}
