package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example extends ActiveRecord{
    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<Currency> currency =new SimpleObjectProperty<>(this, "currency", null);

    private static Example INSTANCE = new Example();

    public static Example getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +this.entityName+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Packet pojo=new Packet();
                pojo.setId(rs.getInt("id"));
                pojo.setPacketSize((PacketSize) PacketSize.getINSTANCE().find(rs.getInt("packetSizeId")));
                pojo.setCounterparty((Counterparty) Counterparty.getINSTANCE().find(rs.getInt("counterpartyId")));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void update() {
        String expression = "UPDATE " + this.entityName + " SET  " +
                " name = ?," +
                " currencyId = ?" +
                " WHERE id= ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setInt(2, currency.get().getId());
            pstmt.setInt(3, id.get());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Packet find(int id) {
        Packet pojo=new Packet() ;
        String expression="SELECT * FROM " +entityName+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo.setId(rs.getInt("id"));
                pojo.setPacketSize((PacketSize) PacketSize.getINSTANCE().find(rs.getInt("packetSizeId")));
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

    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
