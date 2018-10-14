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

    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<Integer> currencyId =new SimpleObjectProperty<>(this, "currencyId", null);

    public Counterparty( ) {
        super("Counterparty");
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return  new ComboBoxValue(name.get(),id.get());
    }


    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public ComboBoxValue getCurrencyId() {
        return currencyId.get();
    }

    public SimpleObjectProperty<ComboBoxValue> currencyIdProperty() {
        SimpleObjectProperty<ComboBoxValue> currencyId =new SimpleObjectProperty<>(this, "currencyId", null);
        return currencyId;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId.set(currencyId);
    }

    @Override
    public ObservableList <ActiveRecord>  getAll( )   {
        ObservableList <ActiveRecord> list=FXCollections.observableArrayList();
            String expression="SELECT * FROM " +"Counterparty"+" ORDER BY ID";
        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);
            while (rs.next()) {
                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setCurrencyId(rs.getInt("currencyId"));
                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

    }

    @Override
    public void insert() {

    }

    @Override
    public ObservableList<ActiveRecord> getAllByRelatedId(Integer id) {
        return null;
    }


    @Override
    public void update(DomainObject d)   {


        Counterparty counterparty= (Counterparty) d;

        if(isReadyToTransaction(counterparty)) {


            String expression = "UPDATE " + "Counterparty" + " SET  " +
                    " name = ?," +
                    " currencyId = ?" +
                    " WHERE id= ?";

            PreparedStatement pstmt = null;

            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setName(1, counterparty.getName());
                pstmt.setInt(2, counterparty.getCurrencyId().getId());
                pstmt.setInt(3, counterparty.getId());


                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(DomainObject d)   {
        super.delete(d,"Counterparty");
    }

    @Override
    public void insert(DomainObject d)   {

        try {
            if(isReadyToTransaction(d)) {

                Counterparty domainObject = (Counterparty) d;

                    String expression = "INSERT INTO " + "Counterparty"
                            + "(name ,"
                            + "currencyId"
                            + ") VALUES(?,?)";

                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setName(1, domainObject.getName());
                    pstmt.setInt(2, domainObject.getCurrencyId().getId());

                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
