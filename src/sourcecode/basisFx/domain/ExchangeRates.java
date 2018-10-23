package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;

public class ExchangeRates extends ActiveRecord{

    private static ExchangeRates INSTANCE = new ExchangeRates();
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> currencyId =new SimpleObjectProperty<>(this, "currencyId", null);
    private SimpleObjectProperty<String> exchangeRate =new SimpleObjectProperty<>(this, "exchangeRate", null);

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

    public Integer getCurrencyId() {
        return currencyId.get();
    }

    public SimpleObjectProperty<Integer> currencyIdProperty() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId.set(currencyId);
    }

    public String getExchangeRate() {
        return exchangeRate.get();
    }

    public SimpleObjectProperty<String> exchangeRateProperty() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate.set(exchangeRate);
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return new ComboBoxValue(exchangeRate.get(),id.get());
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
    public ObservableList<ActiveRecord> findAllByOuterId(int id)   {
        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM " +"ExchangeRates "+" where currencyId= " +id+" ORDER BY startDate Desc";

        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                ExchangeRates pojo=new ExchangeRates();

                pojo.setId( rs.getInt("id"));
                pojo.setCurrencyId(rs.getInt("currencyId"));
                pojo.setExchangeRate(Double.toString(rs.getDouble("rate")));
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
//
//            ExchangeRates domainObject= (ExchangeRates) d;
//            String expression = "UPDATE "+    "ExchangeRates"+ " SET  " +
//                    " rate = ?," +
//                    " startDate = ?," +
//                    " currencyId = ? " +
//                    " where id =?";
//
//            PreparedStatement pstmt = null;
//
//            boolean check = checkUniquenessDateById(
//                    "ExchangeRates",
//                    "startDate",
//                    domainObject.getStartingDate(),
//                    "currencyId",
//                    getObservableDomaineId()
//            );
//
//
//            if (!check) {
//                try {
//                    pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getExchangeRate()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, domainObject.getCurrencyId());
//                    pstmt.setInt(4, domainObject.getId());
//
//                    pstmt.executeUpdate();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

    }


    @Override
    public void insert()   {
//        ExchangeRates domainObject=(ExchangeRates) d;
//
//        try {
//            if(isReadyToTransaction(d)) {
//
//                boolean check = checkUniquenessDateById(
//                        "ExchangeRates",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "currencyId",
//                        getObservableDomaineId()
//                );
//                if (!check) {
//                    String expression = "INSERT INTO " + "ExchangeRates "
//                            + "("
//                            + " rate ,  "
//                            + " startDate,  "
//                            + " currencyId        "
//                            + ") VALUES(?,?,?)";
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getExchangeRate()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, getObservableDomaineId());
//
//                    pstmt.executeUpdate();
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }





}
