package basisFx.domain;

import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class OutputPerDay extends ActiveRecord implements RecordWithDate {

    private static OutputPerDay INSTANCE = new OutputPerDay();
    private SimpleObjectProperty<Equipment> equipment =new SimpleObjectProperty<>(this, "equipment", null);
    private SimpleObjectProperty<Product> product=new SimpleObjectProperty<>(this, "product", null);
    private SimpleObjectProperty<Integer> rodsNumber=new SimpleObjectProperty<>(this, "rodsNumber", null);
    private SimpleObjectProperty<Jumbo> jumbo=new SimpleObjectProperty<>(this, "Jumbo", null);
    private SimpleObjectProperty<Packet> packet=new SimpleObjectProperty<>(this, "packet", null);
    private SimpleObjectProperty<Counterparty> packetCounterparty=new SimpleObjectProperty<>(this, "packetCounterparty", null);
    private SimpleObjectProperty<Counterparty> paperCounterparty=new SimpleObjectProperty<>(this, "paperCounterparty", null);
    private SimpleObjectProperty<LocalDate> date =new SimpleObjectProperty<>(this, "date", null);
    @Override
    public void update() {
        try {
            String expression = "UPDATE "+    this.entityName+ " SET  " +
                      " EquipmentId=? ,  "
                    + " productId=?  ,  "
                    + " rodsNumber=?  ,  "
                    + " JumboId=?  ,  "
                    + " packetId=?  ,  "
                    + " packetCounterpartyId=?,  "
                    + " paperCounterpartyId=?,  "
                    + " date=?    "
                    +" WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getEquipment().getId());
            pstmt.setInt(2, getProduct().getId());
            pstmt.setInt(3, getRodsNumber());
            pstmt.setInt(4, getJumbo().getId());
            pstmt.setInt(5, getPacket().getId());
            pstmt.setInt(6, getPacketCounterparty().getId());
            pstmt.setInt(7, getPaperCounterparty().getId());
            pstmt.setDate(8, Date.valueOf(getDate()));
            pstmt.setInt(7, getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                    + " EquipmentId=? ,  "
                    + " productId=?  ,  "
                    + " rodsNumber=?  ,  "
                    + " rodsWidth=?  ,  "
                    + " packetId=?  ,  "
                    + " packetCounterpartyId=?,  "
                    + " paperCounterpartyId=?,  "
                    + " date=?    "
                    + ") VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getEquipment().getId());
            pstmt.setInt(2, getProduct().getId());
            pstmt.setInt(3, getRodsNumber());
            pstmt.setInt(4, getJumbo().getId());
            pstmt.setInt(5, getPacket().getId());
            pstmt.setInt(6, getPacketCounterparty().getId());
            pstmt.setInt(7, getPaperCounterparty().getId());
            pstmt.setDate(8,Date.valueOf(getDate()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }

    @Override
    public ObservableList<ActiveRecord> getAllByDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +this.entityName+" where date=? " +" ORDER BY id";
        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                OutputPerDay pojo=new OutputPerDay();
                pojo.setId(rs.getInt("id"));
                pojo.setEquipment((Equipment) Equipment.getINSTANCE().find( rs.getInt("EquipmentId") ));
                pojo.setProduct((Product) Product.getINSTANCE().find( rs.getInt("productId") ));
                pojo.setRodsNumber(  rs.getInt("rodsNumber")  );
                pojo.setJumbo((Jumbo) Jumbo.getINSTANCE().find(rs.getInt("JumboId") ));
                pojo.setPacket((Packet) Packet.getINSTANCE().find( rs.getInt("packetId") ));
                pojo.setPacketCounterparty((Counterparty) Counterparty.getINSTANCE().find( rs.getInt("packetCounterpartyId") ));
                pojo.setPaperCounterparty((Counterparty) Counterparty.getINSTANCE().find( rs.getInt("paperCounterpartyId") ));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static OutputPerDay getINSTANCE() {
        return INSTANCE;
    }
    public Equipment getEquipment() {
        return equipment.get();
    }
    public SimpleObjectProperty<Equipment> equipmentProperty() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment.set(equipment);
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
    public Integer getRodsNumber() {
        return rodsNumber.get();
    }
    public SimpleObjectProperty<Integer> rodsNumberProperty() {
        return rodsNumber;
    }
    public void setRodsNumber(Integer rodsNumber) {
        this.rodsNumber.set(rodsNumber);
    }
    public Packet getPacket() {
        return packet.get();
    }
    public SimpleObjectProperty<Packet> packetProperty() {
        return packet;
    }
    public void setPacket(Packet packet) {
        this.packet.set(packet);
    }
    public Counterparty getPacketCounterparty() {
        return packetCounterparty.get();
    }
    public SimpleObjectProperty<Counterparty> packetCounterpartyProperty() {
        return packetCounterparty;
    }
    public void setPacketCounterparty(Counterparty packetCounterparty) {
        this.packetCounterparty.set(packetCounterparty);
    }
    public LocalDate getDate() {
        return date.get();
    }
    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date.set(date);
    }
    public Counterparty getPaperCounterparty() {
        return paperCounterparty.get();
    }
    public SimpleObjectProperty<Counterparty> paperCounterpartyProperty() {
        return paperCounterparty;
    }
    public void setPaperCounterparty(Counterparty paperCounterparty) {
        this.paperCounterparty.set(paperCounterparty);
    }
    public Jumbo getJumbo() {
        return jumbo.get();
    }
    public SimpleObjectProperty<Jumbo> jumboProperty() {
        return jumbo;
    }
    public void setJumbo(Jumbo jumbo) {
        this.jumbo.set(jumbo);
    }
}
