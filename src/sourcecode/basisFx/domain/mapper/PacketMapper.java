//package basisFx.domain.mapper;
//
//import basisFx.dataSource.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Packet;
//import basisFx.domain.domaine.PacketSize;
//import javafx.collections.ObservableList;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
//public class PacketMapper  extends ActiveRecord {
//
//    private static PacketMapper ourInstance = new PacketMapper();
//
//    public static PacketMapper getInstance() {
//        return ourInstance;
//    }
//
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Packet pojo = (Packet) d;
//        if (
//                pojo.getSize()!=null &&
//                pojo.getCounterparty()!=null
//                ) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getDomainList(ObservableList list)   {
//
//
//            String expression="SELECT * FROM " +"Packet"+" ORDER BY ID";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            HashMap<Integer, DomainObject> packetSizeHm = dataMapperFabric.packetSizeMapper().toHashMapByCommonRawId();
//            HashMap<Integer, DomainObject> counterpartyHm = dataMapperFabric.counterpartyMapper().toHashMapByCommonRawId();
//
//            while (rs.next()) {
//
//                int packetSizeId=rs.getInt("packetSizeId");
//                int counterpartyId=rs.getInt("counterpartyId");
//                PacketSize packetSize = (PacketSize) packetSizeHm.get(packetSizeId);
//                Counterparty counterparty = (Counterparty) counterpartyHm.get(counterpartyId);
//
//                Packet pojo=new Packet();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setSize(packetSize.toComboBoxValue());
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
//
//    }
//
//    @Override
//    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//    @Override
//    public void updateDomainObject(DomainObject d)   {
//
//        if (isReadyToTransaction(d)) {
//            Packet pojo = (Packet) d;
//            String expression = "UPDATE " + "Packet" + " SET  " +
//                    " packetSizeId = ?" +
//                    " counterpartyId = ?" +
//                    " where id=? ";
//
//            PreparedStatement pstmt = null;
//
//            try {
//                pstmt = Db.getConnection().prepareStatement(expression);
//
//                pstmt.setInt(3, pojo.getId());
//                pstmt.setInt(1, pojo.getSize().getId());
//                pstmt.setInt(2, pojo.getCounterparty().getId());
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    @Override
//    public void deleteDomainObject(DomainObject d)   {
//
//         super.delete(d,"Packet");
//
//    }
//
//    @Override
//    public void insertDomainObject(DomainObject d)   {
//        Packet pojo= (Packet) d;
//
//            String expression= "INSERT INTO "+ "Packet "
//                    + "("
//                    +"packetSizeId,"
//                    +  "counterpartyId "
//                    + ") VALUES(?,?)";
//
//        try {
//            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
//            pstmt.setInt(1, pojo.getSize().getId());
//            pstmt.setInt(2, pojo.getCounterparty().getId());
//
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
