package basisFx.domain;


import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacketSize extends ActiveRecord {

    private static PacketSize INSTANCE = new PacketSize();
    private SimpleObjectProperty<String> size =new SimpleObjectProperty<>(this, "size", null);

    public static PacketSize getINSTANCE() {
        return INSTANCE;
    }

    public String getSize() {
        return size.get();
    }

    public SimpleObjectProperty<String> sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }


    @Override
    public void update() {
        try {
            String expression = "UPDATE "+    this.entityName+ " SET  " +
                    " size = ?" +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, size.get());
            pstmt.setInt(3, id.get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PacketSize find(int id){

    PacketSize pojo=new PacketSize() ;
    String expression="SELECT * FROM " +this.entityName+" WHERE ID=?";

        try {
        PreparedStatement pstmt = Db.connection.prepareStatement(expression);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            pojo.setId(rs.getInt("id"));
            pojo.setSize(rs.getString("size"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return pojo;
    }


    @Override
    public String toString() {
        return getSize();
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " size  "
                    + ") VALUES(?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, size.get());
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
