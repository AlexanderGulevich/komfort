package basisFx.domain;
import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Counterparty extends ActiveRecord {

    private static Counterparty INSTANCE = new Counterparty();
    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<Currency> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Counterparty( ) {
        super("Counterparty");
    }

    public static Counterparty getInstance() {
        return INSTANCE;
    }
    public Currency getCurrency() {
        return currency.get();
    }
    public SimpleObjectProperty<Currency> currencyProperty() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency.set(currency);
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
    public ObservableList <ActiveRecord>  getAll( )   {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
            String expression="SELECT * FROM " +this.entityName+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setCurrency(Currency.getInstance().find(  rs.getInt("currencyId")));
                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update() {
            String expression = "UPDATE " + this.entityName + " SET  " +
                    " name = ?," +
                    " currencyId = ?" +
                    " WHERE id= ?";
            PreparedStatement pstmt = null;
            try {
                pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1, name.get());
                pstmt.setInt(2, currency.get().getId());
                pstmt.setInt(3, id.get());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void insert() {
        try {

                String expression = "INSERT INTO " + this.entityName
                        + "(name ,"
                        + "currencyId"
                        + ") VALUES(?,?)";

                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setString(1,name.get());
                pstmt.setInt(2, currency.get().getId());

                int i=pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }


    @Override
    public Counterparty find(int id) {
        Counterparty pojo=new Counterparty() ;
        String expression="SELECT  FROM " +"Counterparty"+" WHERE ID=?";

        try {
            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setCurrency(Currency.getInstance().find(rs.getInt("currencyId")));
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

}
