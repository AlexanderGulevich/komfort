package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Currency extends ActiveRecord {

    private static Currency INSTANCE = new Currency();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);

    public Currency() {
        super("Currency");
    }

    public static Currency getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return new ComboBoxValue(name.get(),id.get());
    }
    //todo
    public String toString(){
        return getName();
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Currency pojo=new Currency();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
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
                String expression = "UPDATE  Currency SET  name = ? WHERE id= ?";
                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1,name.get());
                pstmt.setInt(2, id.get());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Currency find(int id) {
        Currency pojo=new Currency() ;
        String expression="SELECT  FROM " +"Currency"+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pojo;

    }

    @Override
    public void insert() {
        try {
                String expression = "INSERT INTO  Currency (name) VALUES(?)";
                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1, name.get());
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
