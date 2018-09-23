//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Sleeve;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
//public class SleeveMapper  extends ActiveRecord {
//
//    private static SleeveMapper ourInstance = new SleeveMapper();
//
//    public static SleeveMapper getInstance() {
//        return ourInstance;
//    }
//
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Sleeve pojo = (Sleeve) d;
//        if (
//                pojo.getCounterparty()!=null
//
//                ) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getDomainList(ObservableList list)   {
//
//        try {
//            String expression="SELECT * FROM " +"Sleeve"+" ORDER BY ID";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            HashMap<Integer, DomainObject> counterpartyHM = dataMapperFabric.counterpartyMapper().toHashMapByCommonRawId();
//
//            while (rs.next()) {
//
//                int counterpartyId=rs.getInt("counterpartyId");
//                Counterparty counterparty = (Counterparty)counterpartyHM.get(counterpartyId);
//
//                Sleeve pojo=new Sleeve();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setCounterparty(counterparty.toComboBoxValue());
//
//                setStoredId(id);
//
//                list.add(pojo);
//
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//    @Override
//    public void updateDomainObject(DomainObject d)   {
//
//        try {
//            if (isReadyToTransaction(d)) {
//                Sleeve pojo = (Sleeve) d;
//                String expression = "UPDATE " + "Sleeve" + " SET  " +
//                        " counterpartyId = ?" +
//                        " where id=? ";
//
//                PreparedStatement pstmt = null;
//
//                    pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setInt(2, pojo.getId());
//                    pstmt.setInt(1, pojo.getCounterparty().getId());
//
//                    pstmt.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteDomainObject(DomainObject d)   {
//        super.deleteForBoundTables(d,"Sleeve","SleevePriceStore ");
//    }
//
//    @Override
//    public void insertDomainObject(DomainObject d)   {
//        Sleeve pojo= (Sleeve) d;
//
//        try {
//            String expression= "INSERT INTO "+ "Sleeve "
//                    + "(counterpartyId  "
//                    + ") VALUES(?)";
//
//            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
//            pstmt.setInt(1, pojo.getCounterparty().getId());
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
