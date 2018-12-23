package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class Employer extends ActiveRecord {

    private static Employer INSTANCE = new Employer();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "metaName", null);

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
                pojo.setName(rs.getString("metaName"));

                list.add(pojo);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return list;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }

}
