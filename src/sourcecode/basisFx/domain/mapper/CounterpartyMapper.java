//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Currency;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
///**
// * Created by AlexanderGulevich on 11.03.2018.
// *
// * @autor AlexanderGulevich
// */
//public class CounterpartyMapper extends ActiveRecord {
//
//    private static CounterpartyMapper ourInstance = new CounterpartyMapper();
//
//    public static CounterpartyMapper getInstance() {
//        return ourInstance;
//    }
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Counterparty counterparty= (Counterparty) d;
//        if (counterparty.getCurrency()!=null
//                &&counterparty.getName()!=null) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getAll(ObservableList list)   {
//
//            String expression="SELECT * FROM " +"Counterparty"+" ORDER BY ID";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            HashMap<Integer, ComboBoxValue> hm = dataMapperFabric.currencyMapper().toComboBoxValHashMap((val) -> {
//                return ((Currency) val).getName();
//            });
//
//            while (rs.next()) {
//
//                Counterparty pojo=new Counterparty();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//                pojo.setName(rs.getString("name"));
//                pojo.setCurrency(hm.get(rs.getInt("currencyId")));
//
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
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//
//    @Override
//    public void update(DomainObject d)   {
//
//
//        Counterparty counterparty= (Counterparty) d;
//
//        if(isReadyToTransaction(counterparty)) {
//
//
//            String expression = "UPDATE " + "Counterparty" + " SET  " +
//                    " name = ?," +
//                    " currencyId = ?" +
//                    " WHERE id= ?";
//
//            PreparedStatement pstmt = null;
//
//            try {
//                pstmt = Db.getConnection().prepareStatement(expression);
//
//                pstmt.setName(1, counterparty.getName());
//                pstmt.setInt(2, counterparty.getCurrency().getId());
//                pstmt.setInt(3, counterparty.getId());
//
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d,"Counterparty");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//
//        try {
//            if(isReadyToTransaction(d)) {
//
//                Counterparty domainObject = (Counterparty) d;
//
//                    String expression = "INSERT INTO " + "Counterparty"
//                            + "(name ,"
//                            + "currencyId"
//                            + ") VALUES(?,?)";
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setName(1, domainObject.getName());
//                    pstmt.setInt(2, domainObject.getCurrency().getId());
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
