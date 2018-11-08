package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;

public class ExchangeRates extends ActiveRecord{

    private static ExchangeRates INSTANCE = new ExchangeRates();
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Double> exchangeRate =new SimpleObjectProperty<>(this, "exchangeRate", null);

    public static ExchangeRates getINSTANCE() {
        return INSTANCE;
    }

    public ExchangeRates() {
        super("ExchangeRates");
    }

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
    }

    public Double getExchangeRate() {
        return exchangeRate.get();
    }

    public SimpleObjectProperty<Double> exchangeRateProperty() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate.set(exchangeRate);
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
       return null;
    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return getExchangeRate().toString();
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id)   {
        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM " +"ExchangeRates "+" where currencyId= " +id+" ORDER BY startDate Desc";

        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                ExchangeRates pojo=new ExchangeRates();

                pojo.setId( rs.getInt("id"));
                pojo.setExchangeRate(rs.getDouble("rate"));
                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return list;
    }


    @Override
    public void update()   {

            String expression = "UPDATE "+    "ExchangeRates"+ " SET  " +
                    " rate = ?," +
                    " startDate = ?," +
                    " currencyId = ? " +
                    " where id =?";

            PreparedStatement pstmt = null;

        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord -> ((ExchangeRates) activeRecord).getStartingDate(),
                getStartingDate());


            if (!check) {
                try {
                    pstmt = Db.connection.prepareStatement(expression);
                    pstmt.setDouble(1, Double.valueOf(getExchangeRate()));
                    pstmt.setDate(2, Date.valueOf(getStartingDate()));
                    pstmt.setInt(3, outerId);
                    pstmt.setInt(4, id.get());

                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }


    @Override
    public void insert() {

        boolean check = isUniquenessStartingDate(
                findAllByOuterId(outerId),
                activeRecord ->   ((ExchangeRates) activeRecord).getStartingDate(),
                getStartingDate()
        );

        if (check) {
            String expression = "INSERT INTO " + "ExchangeRates "
                    + "("
                    + " rate ,  "
                    + " startDate,  "
                    + " currencyId        "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt;
            try {
                pstmt = Db.connection.prepareStatement(expression);
                pstmt.setDouble(1, Double.valueOf(getExchangeRate()));
                pstmt.setDate(2, Date.valueOf(getStartingDate()));
                pstmt.setInt(3,  outerId);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }






}
