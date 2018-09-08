//package basisFx.domain.mapper;
//
//import basisFx.dataSource.ActiveRecord;
//import basisFx.dataSource.Db;
//
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Currency;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * Created by AlexanderGulevich on 24.03.2018.
// *
// * @autor AlexanderGulevich
// */
//public class CurrencyMapper extends ActiveRecord {
//
//
//    private Currency domainObject;
//    private static CurrencyMapper ourInstance = new CurrencyMapper();
//
//    public static CurrencyMapper getInstance() {
//        return ourInstance;
//    }
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        domainObject = (Currency) d;
//
//        if (domainObject.getName() != null) {
//            return true;
//        }
//        return false;
//    }
//
//
//
//    @Override
//    public void getDomainList(ObservableList list)  {
//        try {
//                    String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
//
//                    Statement stmt  = Db.getConnection().createStatement();
//
//                    ResultSet rs    = stmt.executeQuery(expression);
//
//
//                    while (rs.next()) {
//
//                        Currency pojo=new Currency();
//
//                        int id=rs.getInt("id");
//                        pojo.setId(id);
//
//                        pojo.setName(rs.getString("name"));
//
//                        setStoredId(id);
//
//                        list.add(pojo);
//
//                    }
//
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//
//    @Override
//    public void updateDomainObject(DomainObject d)  {
//
//
//        try {
//            if(isReadyToTransaction(d)) {
//
//                    domainObject = (Currency) d;
//
//
//                    String expression = "UPDATE " + " Currency " +
//                            " SET  name = ? WHERE id= ?";
//
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setName(1, domainObject.getName());
//                    pstmt.setInt(2, domainObject.getId());
//
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteDomainObject(DomainObject d)   {
//
//            super.deleteForBoundTables(d,"Currency","ExchangeRates");
//
//    }
//
//
//    @Override
//    public void insertDomainObject(DomainObject d)  {
//
//        try {
//            domainObject=(Currency) d;
//
//            if(isReadyToTransaction(d)) {
//
//                    String expression = "INSERT INTO " + " Currency "
//                            + "(name) VALUES(?)";
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setName(1, domainObject.getName());
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
