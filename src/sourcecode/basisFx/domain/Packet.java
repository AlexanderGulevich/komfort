package basisFx.domain;


import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Packet extends  ActiveRecord {


    private static Packet INSTANCE = new Packet();
    private SimpleObjectProperty<PacketSize> size =new SimpleObjectProperty<>(this, "size", null);
    private SimpleObjectProperty<Counterparty> counterparty =new SimpleObjectProperty<>(this, "counterparty", null);

    public static Packet getINSTANCE() {
        return INSTANCE;
    }

    public PacketSize getSize() {
        return size.get();
    }

    public SimpleObjectProperty<PacketSize> sizeProperty() {
        return size;
    }

    public void setSize(PacketSize size) {
        this.size.set(size);
    }

    public Counterparty getCounterparty() {
        return counterparty.get();
    }

    public SimpleObjectProperty<Counterparty> counterpartyProperty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty.set(counterparty);
    }

    public Packet() {
        super("Packet");
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
                pojo.setSize(PacketSize.getINSTANCE().find(rs.getInt("packetSizeId")));
                pojo.setCounterparty(Counterparty.getINSTANCE().find(rs.getInt("counterpartyId")));
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
                    " size = ?," +
                    " counterpartyId = ? " +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, size.get().getId());
            pstmt.setInt(2, counterparty.get().id.get());
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
                pojo.setSize(PacketSize.getINSTANCE().find(rs.getInt("size")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pojo;
    }

    @Override
    public String toString() {
        if (getSize() != null) {
            return  getSize().getSize();
        }
        return  null;
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " packetSizeId ,  "
                    + " counterpartyId "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, size.get().getId());
            pstmt.setInt(2, counterparty.get().getId());
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
