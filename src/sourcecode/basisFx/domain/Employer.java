package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class Employer extends ActiveRecord {

    private static Employer INSTANCE = new Employer();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);

    public static Employer getINSTANCE() {
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

    public Employer() {
        super("Employer");
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {

        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        String expression="SELECT  * from "+ this.entityName+" where isFired=false";

        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs = stmt.executeQuery(expression);
            while (rs.next()) {
                Employer pojo=new Employer();
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
            String expression = "UPDATE "+    this.entityName+ " SET  " +
                    " name = ?," +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setInt(2, id.get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employer find(int id) {
        Employer pojo=new Employer() ;
        String expression="SELECT  * FROM " +"Employer"+" WHERE ID=?";

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
    public String toString() {
        return getName();
    }

    @Override
    public void insert() {
        try {
            String expression = "INSERT INTO " +  this.entityName
                    + " ("
                    + " name ,  "
                    + " isFired "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, getName());
            pstmt.setBoolean(2, false);
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
