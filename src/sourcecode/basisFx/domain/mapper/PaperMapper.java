//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Paper;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class PaperMapper  extends ActiveRecord {
//
//    private static PaperMapper ourInstance = new PaperMapper();
//
//    public static PaperMapper getInstance() {
//        return ourInstance;
//    }
//
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Paper pojo = (Paper) d;
//        if (
//                pojo.getCounterparty()!=null &&
//                        pojo.getCounterparty()!=null
//                ) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getAll(ObservableList list) {
//        try {
//
//            String expression="SELECT * FROM " +"Paper"+" ORDER BY ID";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            HashMap<Integer, DomainObject> counterpartyHm = dataMapperFabric.counterpartyMapper().toHashMapByCommonRawId();
//
//            while (rs.next()) {
//
//                int counterpartyId=rs.getInt("counterpartyId");
//                Counterparty counterparty = (Counterparty)counterpartyHm.get(counterpartyId);
//
//                Paper pojo=new Paper();
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
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EquipmentMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//    @Override
//    public void update(DomainObject d) {
//
//        if (isReadyToTransaction(d)) {
//            Paper pojo = (Paper) d;
//            String expression = "UPDATE " + "Paper" + " SET  " +
//                    " counterpartyId = ?" +
//                    " where id=? ";
//
//            PreparedStatement pstmt = null;
//            try {
//                pstmt = Db.getConnection().prepareStatement(expression);
//
//                pstmt.setInt(2, pojo.getId());
//                pstmt.setInt(1, pojo.getCounterparty().getId());
//
//                pstmt.executeUpdate();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d, "Paper");
//    }
//
//    @Override
//    public void insert(DomainObject d) {
//        Paper pojo= (Paper) d;
//        try {
//            String expression= "INSERT INTO "+ "Paper "
//                    + "(counterpartyId  "
//                    + ") VALUES(?)";
//
//            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
//            pstmt.setInt(1, pojo.getCounterparty().getId());
//
//
//            pstmt.executeUpdate();
//
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EquipmentMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//}
