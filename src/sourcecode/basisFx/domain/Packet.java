package basisFx.domain;


import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Packet extends  ActiveRecord {


    private static Packet INSTANCE = new Packet();
    private SimpleObjectProperty<PacketSize> packetSize =new SimpleObjectProperty<>(this, "packetSize", null);
    private SimpleObjectProperty<Counterparty> counterparty =new SimpleObjectProperty<>(this, "counterparty", null);

    public static Packet getINSTANCE() {
        return INSTANCE;
    }

    public PacketSize getPacketSize() {
        return packetSize.get();
    }

    public SimpleObjectProperty<PacketSize> packetSizeProperty() {
        return packetSize;
    }

    public void setPacketSize(PacketSize packetSize) {
        this.packetSize.set(packetSize);
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

    @Override
    public void update() {
        try {
            String expression = "UPDATE "+    this.entityName+ " SET  " +
                    " packetSize = ?," +
                    " counterpartyId = ? " +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, packetSize.get().getId());
            pstmt.setInt(2, counterparty.get().id.get());
            pstmt.setInt(3, id.get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        if (getPacketSize() != null) {
            return  getPacketSize().getSize();
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
            pstmt.setInt(1, packetSize.get().getId());
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
