//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Price;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//
//public class PacketPriceMapper extends ActiveRecord {
//
//    private static PacketPriceMapper ourInstance = new PacketPriceMapper();
//
//    public static PacketPriceMapper getInstance() {
//        return ourInstance;
//    }
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Price price = (Price) d;
//
//        if (
//                price.getPrice()!= null
//                        && price.getStartingDate() !=null
//
//                ) {
//
//            return true;
//        }
//
//        return false;
//
//    }
//
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
//            String expression="SELECT * FROM " +"PacketPriceStore "+" where packetId= " +selectedDomainObjectId+" ORDER BY startDate desc";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            while (rs.next()) {
//
//                Price pojo=new Price();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setProductId(rs.getInt("packetId"));
//                pojo.setPrice( Double.toString(rs.getDouble("price")));
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
//            Price domainObject= (Price) d;
//
//            String expression = "UPDATE "+    "PacketPriceStore"+ " SET  " +
//                    " price = ?," +
//                    " startDate = ?," +
//                    " packetId = ? " +
//                    " where id =?";
//
//            PreparedStatement pstmt = null;
//
//
//            boolean check = checkUniquenessDateById(
//                    "PacketPriceStore",
//                    "startDate",
//                    domainObject.getStartingDate(),
//                    "packetId",
//                    getObservableDomaineId()
//            );
//
//            if (!check) {
//                try {
//                    pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, domainObject.getProductId());
//                    pstmt.setInt(4, domainObject.getId());
//                    pstmt.executeUpdate();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d,"PacketPriceStore");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//        Price domainObject=(Price) d;
//
//        if(isReadyToTransaction(d)) {
//
//                String expression = "INSERT INTO " + "PacketPriceStore "
//                        + "("
//                        + " price ,  "
//                        + " startDate,  "
//                        + " packetId        "
//                        + ") VALUES(?,?,?)";
//
//
//            boolean check = checkUniquenessDateById(
//                    "PacketPriceStore",
//                    "startDate",
//                    domainObject.getStartingDate(),
//                    "packetId",
//                    getObservableDomaineId()
//            );
//
//            if (!check) {
//                try {
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, getObservableDomaineId());
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
//
//
//}
