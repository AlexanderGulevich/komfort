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
    private SimpleObjectProperty<Integer> numberOfRods=new SimpleObjectProperty<>(this, "numberOfRods", null);
    private SimpleObjectProperty<Packet> packet=new SimpleObjectProperty<>(this, "packet", null);
    private SimpleObjectProperty<Counterparty> counterparty=new SimpleObjectProperty<>(this, "counterparty", null);
    private SimpleObjectProperty<LocalDate> date =new SimpleObjectProperty<>(this, "date", null);


    public OutputPerDay() {
        super("OutputPerDay");
    }

    public static OutputPerDay getINSTANCE() {
        return INSTANCE;
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

    public Integer getNumberOfRods() {
        return numberOfRods.get();
    }

    public SimpleObjectProperty<Integer> numberOfRodsProperty() {
        return numberOfRods;
    }

    public void setNumberOfRods(Integer numberOfRods) {
        this.numberOfRods.set(numberOfRods);
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
    public ObservableList<ActiveRecord> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public ActiveRecord find(int id) {
        return null;
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
                    + " EquipmentId ,  "
                    + " productId ,  "
                    + " rodsNumber ,  "
                    + " packetId ,  "
                    + " date ,  "
                    + " CounterpartyId "
                    + ") VALUES(?,?,?,?,?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, getEquipment().getId());
            pstmt.setInt(2, getProduct().getId());
            pstmt.setInt(3, getNumberOfRods());
            pstmt.setInt(4, getPacket().getId());
            pstmt.setDate(5, Date.valueOf(getDate()));
            pstmt.setInt(6, getCounterparty().getId());
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
                pojo.setCounterparty(Counterparty.getINSTANCE().find(rs.getInt("Counterpartyid")));
                pojo.setDate(rs.getDate("date").toLocalDate());
                pojo.setEquipment(Equipment.getINSTANCE().find(rs.getInt("Equipmentid")));
                pojo.setNumberOfRods(rs.getInt("NumberOfRods"));
                pojo.setPacket(Packet.getINSTANCE().find(rs.getInt("Packetid")));
                pojo.setProduct(Product.getINSTANCE().find(rs.getInt("Productid")));

                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
