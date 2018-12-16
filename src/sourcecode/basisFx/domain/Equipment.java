package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipment  extends ActiveRecord {

    private static Equipment INSTANCE = new Equipment();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(null, "name", null);

    public static Equipment getINSTANCE() {
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
    public void update() {
        try {
                String expression = "UPDATE Equipment SET  name = ? WHERE id= ?";
                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1, name.get());
                pstmt.setInt(2,id.get());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void insert() {


        try {
            if (isReadyToTransaction()) {

                String expression = "INSERT INTO Equipment (name) VALUES(?)";

                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1, name.get());

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }



}
