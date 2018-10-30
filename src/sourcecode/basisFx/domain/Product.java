package basisFx.domain;
import basisFx.dataSource.Db;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product  extends ActiveRecord {

    private static Product INSTANCE = new Product();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<BoolComboBox> sleeve =new SimpleObjectProperty<>(this, "havingSleeve", null);

    public static Product getINSTANCE() {
        return INSTANCE;
    }

    public Product() {
        super("Product");
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

    public BoolComboBox getSleeve() {
        return sleeve.get();
    }

    public SimpleObjectProperty<BoolComboBox> sleeveProperty() {
        return sleeve;
    }

    public void setSleeve(BoolComboBox sleeve) {
        this.sleeve.set(sleeve);
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return new ComboBoxValue(name.get(),id.get());
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
        String expression="SELECT * FROM " +"Product"+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Product pojo=new Product();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setSleeve(new BoolComboBox(rs.getBoolean("sleeve") )  );
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
            String expression = "UPDATE "+    "Product"+ " SET  " +
                    " name = ?," +
                    " sleeve = ? " +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setBoolean(2,sleeve.get().getBoolean());
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
    public void insert() {
        try {
            String expression = "INSERT INTO " + "Product "
                    + "("
                    + " name ,  "
                    + " sleeve "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setBoolean(2, sleeve.get().getBoolean());
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
