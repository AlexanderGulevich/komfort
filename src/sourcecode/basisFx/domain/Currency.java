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

    public static Currency getINSTANCE() {
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

    public String toString(){
        return getName();
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
        Currency pojo=null;
        String expression="SELECT * FROM " +"Currency"+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo=new Currency() ;
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
