//package basisFx.domain.mapper;
//
//import basisFx.dataSource.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.PacketProductAccordance;
//import basisFx.domain.domaine.PacketSize;
//import basisFx.domain.domaine.Product;
//import javafx.collections.ObservableList;
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
//public class PacketProductAccordanceMapper extends ActiveRecord {
//
//    private static PacketProductAccordanceMapper ourInstance = new PacketProductAccordanceMapper();
//
//
//    public static PacketProductAccordanceMapper getInstance() {
//        return ourInstance;
//    }
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        PacketProductAccordance pojo = (PacketProductAccordance) d;
//        if (
//                pojo.getSize() != null &&
//                        pojo.getProduct() != null &&
//                        pojo.getNumber() != null
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
//            String expression = "SELECT * FROM " + "PacketProductAccordance" + " ORDER BY ID";
//
//            Statement stmt = Db.getConnection().createStatement();
//
//            ResultSet rs = stmt.executeQuery(expression);
//
//            HashMap<Integer, DomainObject> packetSizeHm = dataMapperFabric.packetSizeMapper().toHashMapByCommonRawId();
//            HashMap<Integer, DomainObject> productHm = dataMapperFabric.productMapper().toHashMapByCommonRawId();
//
//            while (rs.next()) {
//
//                int packetSizeId = rs.getInt("packetSizeId");
//                int productId = rs.getInt("productId");
//
//                PacketSize packetSize =(PacketSize) packetSizeHm.get(packetSizeId);
//                Product product =(Product) productHm.get(productId);
//
//                PacketProductAccordance pojo = new PacketProductAccordance();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setSize(packetSize.toComboBoxValue());
//                pojo.setProduct(product.toComboBoxValue());
//                pojo.setNumber(String.valueOf(rs.getInt("number")) );
//
//                setStoredId(id);
//
//                list.add(pojo);
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
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
//        if (isReadyToTransaction(d)) {
//            PacketProductAccordance pojo = (PacketProductAccordance) d;
//            String expression = "UPDATE " + "PacketProductAccordance" + " SET  " +
//                    " packetSizeId = ?, " +
//                    " productId = ?, " +
//                    " number = ? " +
//                    " where id=? ";
//
//            PreparedStatement pstmt = null;
//
//            try {
//                pstmt = Db.getConnection().prepareStatement(expression);
//
//                pstmt.setInt(4, pojo.getId());
//                pstmt.setInt(1, pojo.getSize().getId());
//                pstmt.setInt(2, pojo.getProduct().getId());
//                pstmt.setInt(3, Integer.valueOf(pojo.getNumber()));
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
//        super.delete(d,"PacketProductAccordance");
//    }
//
//    @Override
//    public void insertDomainObject(DomainObject d)   {
//        PacketProductAccordance pojo = (PacketProductAccordance) d;
//
//            String expression = "INSERT INTO " + "PacketProductAccordance "
//                    + "(packetSizeId,  productId, number "
//                    + ") VALUES(?,?,?)";
//
//        try {
//            PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//            pstmt.setInt(1, pojo.getSize().getId());
//            pstmt.setInt(2, pojo.getProduct().getId());
//            pstmt.setInt(3, Integer.valueOf(pojo.getNumber()));
//
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//}