package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Label extends ActiveRecord {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<Counterparty> counterparty =new SimpleObjectProperty<>(this, "counterparty", null);
    //todo private SimpleObjectProperty<String> actualPrice =new SimpleObjectProperty<>(this, "price", null);


    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public Label() {
        super("Label");
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +this.entityName+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Label pojo=new Label();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setCounterparty(Counterparty.getInstance().find(rs.getInt("counterpartyId")));
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
                    " name = ?," +
                    " counterpartyId = ? " +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setInt(2, counterparty.get().id.get());
            pstmt.setInt(3, id.get());
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
        return getName();
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " name ,  "
                    + " counterpartyId "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
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
