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
    private SimpleObjectProperty<BoolComboBox> havingSleeve =new SimpleObjectProperty<>(this, "havingSleeve", null);

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

    public BoolComboBox getHavingSleeve() {
        return havingSleeve.get();
    }

    public SimpleObjectProperty<BoolComboBox> havingSleeveProperty() {
        return havingSleeve;
    }

    public void setHavingSleeve(BoolComboBox havingSleeve) {
        this.havingSleeve.set(havingSleeve);
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
                pojo.setHavingSleeve(new BoolComboBox(rs.getBoolean("havingSleeve") )  );
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
                    " havingSleeve = ? " +
                    " WHERE id= ?" ;
            PreparedStatement pstmt = null;
            pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setBoolean(2, havingSleeve.get().getBoolean());
            pstmt.setInt(3, id.get());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product find(int id) {
        Product pojo=new Product() ;
        String expression="SELECT * FROM " +this.entityName+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setHavingSleeve(new BoolComboBox(rs.getBoolean("havingSleeve")));
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
        int executeResult;
        try {
            String expression = "INSERT INTO " + "Product "
                    + "("
                    + " name ,  "
                    + " havingSleeve "
                    + ") VALUES(?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setString(1, name.get());
            pstmt.setBoolean(2, havingSleeve.get().getBoolean());
            executeResult= pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
