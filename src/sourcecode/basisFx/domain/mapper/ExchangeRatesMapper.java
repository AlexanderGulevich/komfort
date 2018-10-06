//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.ExchangeRates;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//
//
//public class ExchangeRatesMapper extends ActiveRecord{
//
//
//    private static ExchangeRatesMapper ourInstance = new ExchangeRatesMapper();
//
//    public static ExchangeRatesMapper getInstance() {
//        return ourInstance;
//    }
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        ExchangeRates domain = (ExchangeRates) d;
//        if (
//                domain.getExchangeRate()!= null
//                        && domain.getStartingDate() !=null
//                ) {
//
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void getAll(ObservableList list) {
//
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject)   {
//        int selectedDomainObjectId=selectedDomainObject.getId();
//
//            String expression="SELECT * FROM " +"ExchangeRates "+" where currencyId= " +selectedDomainObjectId+" ORDER BY startDate Desc";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//
//            while (rs.next()) {
//
//                ExchangeRates pojo=new ExchangeRates();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setCurrencyId(rs.getInt("currencyId"));
//                pojo.setExchangeRate(Double.toString(rs.getDouble("rate")));
//                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());
//
//                setStoredId(id);
//
//                list.add(pojo);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void update(DomainObject d)   {
//        if(isReadyToTransaction(d)) {
//
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
//
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d,"ExchangeRates ");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
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
//    }
//}
