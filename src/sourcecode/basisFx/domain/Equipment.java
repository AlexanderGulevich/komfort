package basisFx.domain;

import basisFx.dataSource.Db;
import basisFx.domain.domaine.ActiveRecord;
import basisFx.domain.domaine.ComboBoxValue;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipment  extends ActiveRecord {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(null, "name", null);
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
        return new ComboBoxValue(getName(),getId());
    }
    @Override
    public boolean isReadyToTransaction() {
        if (name!=null) {
            return true;
        }
        return false;
    }
    @Override
    public  ObservableList <ActiveRecord>  getAll() {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +"Equipment"+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Equipment pojo=new Equipment();
                int id=rs.getInt("id");
                pojo.setId(id);
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
            if (isReadyToTransaction() ){

                String expression = "UPDATE Equipment SET  name = ? WHERE id= ?";

                PreparedStatement pstmt = Db.connection.prepareStatement(expression);

                pstmt.setString(1, entityName);
                pstmt.setInt(2,id.get());


                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insert() {


        try {
            if (isReadyToTransaction()) {

                String expression = "INSERT INTO Equipment (name) VALUES(?)";

                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1, entityName);

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> getAllByRelatedId(Integer id) {
        return null;
    }


}
